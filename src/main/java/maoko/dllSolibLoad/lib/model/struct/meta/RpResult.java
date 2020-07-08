package maoko.dllSolibLoad.lib.model.struct.meta;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import maoko.dllSolibLoad.lib.model.struct.JavaStructBase;

import java.util.Vector;

/**
 * @NAME: RpResult
 * @DESCRIPTION:
 * @USER: cwhu2
 * @DATE: 2020/7/2 16:06
 */
@Structure.FieldOrder({"RpFlag","RpPlaces","Links", "dRouteLength"})
public class RpResult extends Structure {

    public static class ByReference extends RpResult implements Structure.ByReference { }
    public static class ByValue extends RpResult implements Structure.ByValue { }

    public boolean RpFlag;
   // public Vector<RpPlace.ByValue> vecRpPlace;
    public Pointer RpPlaces;
   // public Vector<RpLink.ByValue> vecLink;
    public Pointer Links;
    public double dRouteLength;
}
