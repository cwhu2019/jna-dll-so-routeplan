package cwhu.dllSolibLoad.lib.model.struct.meta;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * @author cwhu2
 * @NAME: RpLane
 * @DESCRIPTION:
 * @DATE: 2020/7/2 15:59
 */
@Structure.FieldOrder({"iLaneID","Shapes","bNeedChangeLane"})
public class RpLane extends Structure {
    public static class ByReference extends RpLane implements Structure.ByReference { }
    public static class ByValue extends RpLane implements Structure.ByValue { }

    public NativeLong iLaneID;
   // public Vector<Coord3dEx.ByValue> vecShape;
    public Pointer Shapes;
    public boolean bNeedChangeLane;
}
