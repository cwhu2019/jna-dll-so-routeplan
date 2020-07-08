package maoko.dllSolibLoad.lib.model.struct.meta;

import com.sun.jna.Structure;
import maoko.dllSolibLoad.lib.model.struct.JavaStructBase;

/**
 * @author cwhu2
 * @NAME: Coord3dEx
 * @DESCRIPTION:
 * @DATE: 2020/7/2 15:51
 */
@Structure.FieldOrder({"dx","dy","dz","adasInfo"})
public class Coord3dEx extends Structure {

    public static class ByReference extends Coord3dEx implements Structure.ByReference { }
    public static class ByValue extends Coord3dEx implements Structure.ByValue { }

    public double dx;
    public double dy;
    public double dz;

    public AdasInfo.ByValue adasInfo;
}
