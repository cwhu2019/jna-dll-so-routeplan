package maoko.dllSolibLoad.lib.load;

import java.util.Set;

import com.sun.jna.Library;
import com.sun.jna.Native;

import maoko.common.ClassUtil;
import maoko.common.file.PathUtil;
import maoko.common.log.IWriteLog;
import maoko.common.log.Log4j2Writer;
import maoko.common.model.enm.EOsType;
import maoko.common.system.AppRunPathUitl;
import maoko.common.system.OSPlatformUtil;

/**
 * lib动态库调用方法:dll/so file mast have lib prefix
 * 
 * @author fanpei
 * @date 2019年5月22日下午4:49:43
 */
public class JnaLibCall {
	private static final String LIBPACKAGE = "maoko.dllSolibLoad.lib.load.routeplanEngine";// 接口目录，根据自己的动态库接口所在包名进行修改

	private static final IWriteLog log = new Log4j2Writer(JnaLibCall.class);

	private static final String JNA_LIBRARY_PATH = "jna.library.path";
	private static final String WINDOWS_LIB_PATH = "lib/windows";// local dll file location
	private static final String LINUX_LIB_PATH = "lib/linux"; // local so file location
	private static final String WINDOWS_SEPRATOR = ";";
	private static final String LINUX_SEPRATOR = ":";

	/**
	 * 加载
	 * 
	 * @throws Exception
	 */
	public static void load() throws Exception {

		EOsType ostype = OSPlatformUtil.getOSType();
		setJnaLibPath(ostype);
		// 加载dll
		Set<Class<?>> clazzs = ClassUtil.getClasses(LIBPACKAGE, LibLoad.class, false);
		if (clazzs != null) {
			for (Class<?> dllclass : clazzs) {
				Library libtmp = null;
				@SuppressWarnings("unchecked")
				Class<Library> clazzLib = (Class<Library>) dllclass;
				LibLoad dllName = dllclass.getAnnotation(LibLoad.class);
				try {
					String libname = "";
					if (EOsType.Linux == ostype) {
						libname = dllName.linuxName();
					} else// windows
					{
						libname = dllName.windowsName();
					}
					libtmp = Native.load(libname, clazzLib);
					LibFactory.add(dllclass.getName(), libtmp);// 加入自定义库工厂，用于后续根据名字调用
					log.info("loading lib:{} sucessful", dllclass.getName());
				} catch (Throwable e) {
					log.warn("load lib file faied:{}", e);
				}
			}
			log.info("loaded lib count:{}", LibFactory.totalLib());
		}
	}

	/**
	 * 设置jna加载指定路径
	 * 
	 * @param ostype 系统类型
	 */
	private static void setJnaLibPath(EOsType ostype) {
		String appPath = AppRunPathUitl.getAppRunPath();
		String libRootPath = "";
		String libPath = "";
		// String nameEnd = "";
		String seprator = "";
		if (EOsType.Linux == ostype) {
			libPath = LINUX_LIB_PATH;
			// nameEnd = LINUX_DLL;
			seprator = LINUX_SEPRATOR;
		} else// windows
		{
			libPath = WINDOWS_LIB_PATH;
			// nameEnd = WINDOWS_DLL;
			seprator = WINDOWS_SEPRATOR;
		}
		libRootPath = PathUtil.combinePath(appPath, libPath);
		String jnaPath = System.getProperty(JNA_LIBRARY_PATH);
		System.err.println("jna.library.path:" + jnaPath);
		if (jnaPath == null) {
			jnaPath = libRootPath;
		} else if (!jnaPath.contains(libRootPath)) {
			jnaPath = jnaPath + seprator + libRootPath;
		}
		System.setProperty(JNA_LIBRARY_PATH, jnaPath);
		System.setProperty("jna.debug_load", "true");
		System.err.println("the latest jna.library.path:" + System.getProperty(JNA_LIBRARY_PATH));
	}

}
