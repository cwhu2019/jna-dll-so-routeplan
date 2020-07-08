package cwhu.dllSolibLoad;

import cwhu.dllSolibLoad.lib.model.struct.meta.RpPlace;
import cwhu.dllSolibLoad.lib.model.struct.meta.RpPlacesJNA;
import cwhu.common.system.AppRunPathUitl;
import cwhu.dllSolibLoad.lib.load.JnaLibCall;
import cwhu.dllSolibLoad.lib.load.LibFactory;
import cwhu.dllSolibLoad.lib.load.routeplanEngine.routeplanEngineLib;
import cwhu.dllSolibLoad.lib.model.struct.meta.Coord3d;
import cwhu.dllSolibLoad.util.ConvertUtils;
import cwhu.sdk.SDKCommon;

import java.util.Vector;

/**
 * Hello world!
 *
 */
public class libApp {
	public static void main(String[] args) {
		try {
			// 初始化
			AppRunPathUitl.initRunPath(libApp.class);
			SDKCommon.init();
			JnaLibCall.load();

			routeplanEngineLib rpLib = LibFactory.get(routeplanEngineLib.class);
			if(rpLib != null) {
				String appRunPath = AppRunPathUitl.getAppRunPath();
				String dbPath = appRunPath + "\\data\\ford\\1stSection_ground_utm.sqlite";
				byte[] byteDbPath = new byte[256];
				ConvertUtils.fillByteArray(byteDbPath, dbPath);
				int iInitialStatus = rpLib.RC_Initialize(byteDbPath);
				System.out.println("RC_Initialize result: " + iInitialStatus);

				Coord3d.ByValue coordStart = new Coord3d.ByValue();
				Coord3d.ByValue coordEnd = new Coord3d.ByValue();
				coordStart.writeField("dx", 385044.92643066857);
				coordStart.writeField("dy", 3530994.6484296084);
				coordStart.writeField("dz", 14.4);
				coordEnd.writeField("dx", 385077.70653618133);
				coordEnd.writeField("dy", 3530932.9447015845);
				coordEnd.writeField("dz", 14.4);

				RpPlace.ByValue rpPlaceStart = new RpPlace.ByValue();
				RpPlace.ByValue rpPlaceEnd = new RpPlace.ByValue();
				rpPlaceStart.writeField("coord3d", coordStart);
				rpPlaceStart.writeField("dAngle", -1);
				rpPlaceEnd.writeField("coord3d", coordEnd);
				rpPlaceEnd.writeField("dAngle", -1);


				Vector<RpPlace.ByValue> vecRpPlace = new Vector<>();
				vecRpPlace.add(rpPlaceStart);
				vecRpPlace.add(rpPlaceEnd);
//
//
//				RpPlace.ByValue[] RpPlaceArray = new RpPlace.ByValue[2];
//				RpPlaceArray[0].writeField("coord3d", coordStart);
//				RpPlaceArray[0].writeField("dAngle", -1);
//				RpPlaceArray[1].writeField("coord3d", coordEnd);
//				RpPlaceArray[1].writeField("dAngle", -1);

//				final String[] myArray = new String[2];
//				myArray[0] = rpPlaceStart.toString();
//				myArray[1] = rpPlaceEnd.toString();
//				//int size= Native.getNativeSize(RpPlace.class);
//				Pointer p = new StringArray(myArray);

				//RpResult.ByReference rpResult = new RpResult.ByReference();

				RpPlacesJNA.ByReference rpPlaces = new RpPlacesJNA.ByReference();
				byte[] src = new byte[256];
				ConvertUtils.fillByteArray(src, rpPlaceStart.toString());
				rpPlaces.writeField("src", src);

				byte[] dest = new byte[256];
				ConvertUtils.fillByteArray(dest, rpPlaceEnd.toString());
				rpPlaces.writeField("dest", dest);
				int istatus = rpLib.RP_RoutePlan_P2P(rpPlaces);

				int iDestroyStatus = rpLib.RC_Destroy();
				System.out.println("RC_Destroy result:" + iDestroyStatus);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
