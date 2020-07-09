package cwhu.dllSolibLoad.lib.model.struct;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * <i>native declaration : line 31</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class RPResultJNA extends Structure {
	public byte RPFlag;
	/** C type : RPPlaceJNA* */
	public RPPlaceJNA.ByReference RPPlace;
	public int iPlaceSize;
	/** C type : RPLinkJNA* */
	public RPLinkJNA.ByReference linkArray;
	public int iLinkSize;
	public double dRouteLength;
	public RPResultJNA() {
		super();
	}
	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("RPFlag", "RPPlace", "iPlaceSize", "linkArray", "iLinkSize", "dRouteLength");
	}
	/**
	 * @param RPPlace C type : RPPlaceJNA*<br>
	 * @param linkArray C type : RPLinkJNA*
	 */
	public RPResultJNA(byte RPFlag, RPPlaceJNA.ByReference RPPlace, int iPlaceSize, RPLinkJNA.ByReference linkArray, int iLinkSize, double dRouteLength) {
		super();
		this.RPFlag = RPFlag;
		this.RPPlace = RPPlace;
		this.iPlaceSize = iPlaceSize;
		this.linkArray = linkArray;
		this.iLinkSize = iLinkSize;
		this.dRouteLength = dRouteLength;
	}
	public static class ByReference extends RPResultJNA implements Structure.ByReference {

	};
	public static class ByValue extends RPResultJNA implements Structure.ByValue {

	};
}


