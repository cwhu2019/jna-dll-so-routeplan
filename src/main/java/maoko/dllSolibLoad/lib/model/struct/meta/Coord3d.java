package maoko.dllSolibLoad.lib.model.struct.meta;

import com.sun.jna.Structure;
import maoko.dllSolibLoad.lib.model.struct.JavaStructBase;

/**
 * @author cwhu2
 * @NAME: Coord3d
 * @DESCRIPTION:
 * @DATE: 2020/7/2 15:47
 */
@Structure.FieldOrder({"dx","dy", "dz"})
public class Coord3d extends Structure {
    public static class ByReference extends Coord3d implements Structure.ByReference { }
    public static class ByValue extends Coord3d implements Structure.ByValue { }

    public double dx;
    public double dy;
    public double dz;
}
