package cwhu.dllSolibLoad.lib.model.struct.meta;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * @NAME: RpLink
 * @DESCRIPTION:
 * @USER: cwhu2
 * @DATE: 2020/7/2 16:04
 */
@Structure.FieldOrder({"iLinkID","Shapes","Lanes"})
public class RpLink extends Structure {
    public static class ByReference extends RpLink implements Structure.ByReference { }
    public static class ByValue extends RpLink implements Structure.ByValue { }
    public NativeLong iLinkID;
   // public Vector<Coord3dEx.ByValue> vecShape;
    public Pointer Shapes;

   // public Vector<RpLane.ByValue> vecLane;
    public Pointer Lanes;
}
