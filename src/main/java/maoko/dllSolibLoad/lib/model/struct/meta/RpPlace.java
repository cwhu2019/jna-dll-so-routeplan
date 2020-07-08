package maoko.dllSolibLoad.lib.model.struct.meta;

import com.sun.jna.Structure;
import maoko.dllSolibLoad.lib.model.struct.JavaStructBase;

/**
 * @author cwhu2
 * @NAME: RpPlace
 * @DESCRIPTION:
 * @DATE: 2020/7/2 15:57
 */

@Structure.FieldOrder({"coord3d", "dAngle"})
public class RpPlace extends Structure {

    public static class ByReference extends RpPlace implements Structure.ByReference { }
    public static class ByValue extends RpPlace implements Structure.ByValue { }

    public Coord3d.ByValue coord3d;
    public double dAngle;

    @Override
    public String toString(){
        return Double.toString(coord3d.dx) + ","
                + Double.toString(coord3d.dy) + ","
                + Double.toString(coord3d.dz)+ ","
                + Double.toString(dAngle);
    }
}
