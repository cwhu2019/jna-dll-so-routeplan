package cwhu.dllSolibLoad.lib.model.struct.meta;

import com.sun.jna.Structure;

/**
 * @author cwhu2
 * @NAME: RpPlacesJNA
 * @DESCRIPTION:
 * @DATE: 2020/7/5 9:55
 */
@Structure.FieldOrder({"src", "dest"})
public class RpPlacesJNA extends Structure {
    public static class ByReference extends RpPlacesJNA implements Structure.ByReference { }
    public static class ByValue extends RpPlacesJNA implements Structure.ByValue { }

    public byte[] src = new byte[256];
    public byte[] dest = new byte[256];
}
