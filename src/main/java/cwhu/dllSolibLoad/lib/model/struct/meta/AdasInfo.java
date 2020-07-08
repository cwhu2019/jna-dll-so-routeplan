package cwhu.dllSolibLoad.lib.model.struct.meta;

import com.sun.jna.Structure;

/**
 * @author cwhu2
 * @NAME: AdasInfo
 * @DESCRIPTION:
 * @DATE: 2020/7/2 15:50
 */
@Structure.FieldOrder({"dCurvature", "dSlopEV", "dHeading"})
public class AdasInfo extends Structure {

    public static class ByReference extends AdasInfo implements Structure.ByReference { }
    public static class ByValue extends AdasInfo implements Structure.ByValue { }

    public double dCurvature;
    public double dSlopEV;
    public double dHeading;
}
