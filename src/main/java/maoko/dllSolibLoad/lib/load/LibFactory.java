package maoko.dllSolibLoad.lib.load;

import java.util.HashMap;
import java.util.Map;

import com.sun.jna.Library;

import maoko.common.StringUtil;
import maoko.common.exception.DataIsNullException;

/**
 * lib factory
 * 
 * @author maoko
 *
 */
public class LibFactory {
	private static Map<String, Library> dlls;

	static {
		dlls = new HashMap<String, Library>();
	}

	/**
	 * add clazz dll
	 * 
	 * @param clazzName dll's clazz name
	 * @param dll
	 */
	public static void add(String clazzName, Library dll) {
		dlls.put(clazzName, dll);
	}

	/**
	 * get dll
	 * 
	 * @param          <T>
	 * 
	 * @param libClazz
	 * @return
	 * @throws DataIsNullException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T get(Class<T> libClazz) throws DataIsNullException {
		T lib = (T) dlls.get(libClazz.getName());
		if (lib == null)
			throw new DataIsNullException(
					StringUtil.getMsgStr("dll factory not contain class  [{}] ", libClazz.getName()));
		return lib;
	}

	/**
	 * total lib count
	 * 
	 * @return
	 */
	public static int totalLib() {
		return dlls.size();
	}

}
