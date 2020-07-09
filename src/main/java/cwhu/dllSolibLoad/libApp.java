package cwhu.dllSolibLoad;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import cwhu.common.system.AppRunPathUitl;
import cwhu.dllSolibLoad.lib.load.JnaLibCall;
import cwhu.dllSolibLoad.lib.load.LibFactory;
import cwhu.dllSolibLoad.lib.load.routeplanEngine.routeplanEngineLib;
import cwhu.dllSolibLoad.lib.model.struct.Coord3DJNA;
import cwhu.dllSolibLoad.lib.model.struct.RPPlaceJNA;
import cwhu.dllSolibLoad.lib.model.struct.RPResultJNA;
import cwhu.dllSolibLoad.util.ConvertUtils;

/**
 * Hello world!
 *
 * @author cwhu2
 */
public class libApp {
	public static void main(String[] args) {
		try {
			// 初始化
			AppRunPathUitl.initRunPath(libApp.class);
			//SDKCommon.init();
			JnaLibCall.load();

			routeplanEngineLib rpLib = LibFactory.get(routeplanEngineLib.class);
			if(rpLib != null) {
				String appRunPath = AppRunPathUitl.getAppRunPath();
				String dbPath = appRunPath + "\\data\\ford\\1stSection_ground_utm.sqlite";
				byte[] byteDbPath = new byte[256];
				ConvertUtils.fillByteArray(byteDbPath, dbPath);
				int iInitialStatus = rpLib.RC_Initialize(byteDbPath);
				System.out.println("RC_Initialize result: " + iInitialStatus);

				Coord3DJNA.ByValue coordStart = new Coord3DJNA.ByValue();
				Coord3DJNA.ByValue coordEnd = new Coord3DJNA.ByValue();
				coordStart.writeField("x", 385044.92643066857);
				coordStart.writeField("y", 3530994.6484296084);
				coordStart.writeField("z", 14.4);
				coordEnd.writeField("x", 385077.70653618133);
				coordEnd.writeField("y", 3530932.9447015845);
				coordEnd.writeField("z", 14.4);

				int placeSize  = 2;
				RPPlaceJNA[] RpPlaceArray = (RPPlaceJNA[])new RPPlaceJNA().toArray(placeSize);
				RpPlaceArray[0].writeField("coord", coordStart);
				RpPlaceArray[0].writeField("angle",-1);
				RpPlaceArray[1].writeField("coord", coordEnd);
				RpPlaceArray[1].writeField("angle",-1);
				RPResultJNA.ByReference rpResult = new RPResultJNA.ByReference();
				int istatus = rpLib.RP_RoutePlan_P2P(RpPlaceArray, placeSize, rpResult);

				//手动释放C++申请的内存
				rpResult.freeMem();
				Pointer pRpResult = rpResult.getPointer();
				long peer = Pointer.nativeValue(pRpResult);
				Native.free(peer);
				//避免Memory对象被GC时重复执行Nativ.free()方法
				Pointer.nativeValue(pRpResult, 0);

				int iDestroyStatus = rpLib.RC_Destroy();
				System.out.println("RC_Destroy result:" + iDestroyStatus);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
