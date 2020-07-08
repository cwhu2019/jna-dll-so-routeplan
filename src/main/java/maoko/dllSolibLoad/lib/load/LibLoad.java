package maoko.dllSolibLoad.lib.load;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * lib接口注解
 * 
 * @author maoko
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LibLoad {
	/**
	 * linux lib 名称
	 * 
	 * @return
	 */
	String linuxName() default "";

	/**
	 * windows lib 名称
	 * 
	 * @return
	 */
	String windowsName() default "";
}
