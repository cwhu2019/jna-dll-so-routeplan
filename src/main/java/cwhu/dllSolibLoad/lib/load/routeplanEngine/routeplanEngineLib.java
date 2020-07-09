package cwhu.dllSolibLoad.lib.load.routeplanEngine;

import com.sun.jna.*;

import cwhu.dllSolibLoad.lib.load.LibLoad;
import cwhu.dllSolibLoad.lib.model.struct.RPPlaceJNA;

/**
 * 加载动态库接口
 * 
 * @author fanpei
 *
 */
@LibLoad(linuxName = "librouteplanEngine", windowsName = "routeplanEngine")
public interface routeplanEngineLib extends Library {

    ////////////////////////////////////////////////////////////////////////////////////
/// \brief RC_Initialize:RP初始化，系统启动时调用一次
/// \return
///
    int RC_Initialize(byte[] dbPath);

///////////////////////////////////////////////////////////////////////////////////
/// \brief RC_Destroy：RP销毁，系统关闭时调用一次
/// \return
///
    int RC_Destroy();

    ///////////////////////////////////////////////////////////////////////////////////
/// \brief RP_RoutePlan_ParkingLot：路径规划到指定的停车位
/// \param vecRPPlace：第一个元素为起点位置，第二个元素为终点位置
/// \param stRPResult：车道级路径规划结果
/// \return
///
  //  RpStatus RP_RoutePlan_ParkingLot(Vector<RpPlace.ByValue> vecRpPlace, RpResult.ByReference stRpResult);
    //int RP_RoutePlan_P2P(Pointer RpPlaces, RpResult.ByReference stRpResult);
    int RP_RoutePlan_P2P(RPPlaceJNA[] RpPlaces, int placeSize);
}
