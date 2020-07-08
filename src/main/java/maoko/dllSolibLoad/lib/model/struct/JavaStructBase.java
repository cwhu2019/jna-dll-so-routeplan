package maoko.dllSolibLoad.lib.model.struct;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * java struct base
 * 
 * @author fanpei
 *
 */
public abstract class JavaStructBase extends Structure {

	/**
	 * 默认构造函数
	 */
	public JavaStructBase() {
	}

	/**
	 * 构造函数
	 * 
	 * @param _pointer
	 */
	public JavaStructBase(Pointer _pointer) {
		super(_pointer);
	}

	/**
	 * 结构体的引用
	 * 
	 * @author maoko
	 *
	 */
	public static class ByReference extends JavaStructBase implements Structure.ByReference {
	}

	/**
	 * 结构体对象
	 * 
	 * @author fanpei
	 *
	 */
	public static class ByValue extends JavaStructBase implements Structure.ByValue {
	}

	@Override
	protected List<String> getFieldOrder() {
		return getStructFields();
	}

	/**
	 * 自定义反射获取字段顺序
	 * 
	 * @return
	 */
	private List<String> getStructFields() {
		List<String> feilds = new LinkedList<>();
		Field[] declearedFeilds = this.getClass().getDeclaredFields();
		if (declearedFeilds != null && declearedFeilds.length > 0) {
			for (Field f : declearedFeilds) {
				feilds.add(f.getName());
			}
		}
		return feilds;
	}

	/**
	 * 打印字段-测试用
	 */
	@Deprecated
	public void printStructFeilds() {
		List<String> feilds = getStructFields();
		if (feilds == null || feilds.size() == 0)
			System.out.println("feilds:none");
		else {
			StringBuilder feidlSb = new StringBuilder("feilds:");
			for (String f : feilds) {
				feidlSb.append(f);
				feidlSb.append(",");
			}
			System.out.println(feidlSb.toString());
		}
	}

}
