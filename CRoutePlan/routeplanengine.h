
#ifndef ROUTEPLANENGINE_H
#define ROUTEPLANENGINE_H

#include "RPStructAPI.h"
#ifndef API_FOR_FORD
#include "RCStruct.h"
#endif
#include "routeplanengine_dllexport.h"

/*********************************************************************************************/
/*! implement the routePlanEngine class                                                      */
/*********************************************************************************************/

namespace routeplanEngine {
////////////////////////////////////////////////////////////////////////////////////
/// \brief RC_Initialize:RP初始化，系统启动时调用一次
/// \return
///
RP_DLLSPEC int RC_Initialize();

///////////////////////////////////////////////////////////////////////////////////
/// \brief RC_Destroy：RP销毁，系统关闭时调用一次
/// \return
///
RP_DLLSPEC int RC_Destroy();

///////////////////////////////////////////////////////////////////////////////////
/// \brief RP_RoutePlan_ParkingLot：路径规划到指定的停车位
/// \param vecRPPlace：第一个元素为起点位置，第二个元素为终点位置
/// \param stRPResult：车道级路径规划结果
/// \return
///
RP_DLLSPEC RCStatus RP_RoutePlan_ParkingLot(const vector<RPPlace>& vecRPPlace, RPResult& stRPResult);

//////////////////////////////////////////////////////////////////////////////////
/// \brief RP_RoutePlan_Exit：路径规划到离startPlace最近的出口
/// \param startPlace：当前车辆位置
/// \param stRPResult：车道级路径规划结果
/// \return
///
RP_DLLSPEC RCStatus RP_RoutePlan_Exit(const RPPlace& startPlace, RPResult& stRPResult);

//////////////////////////////////////////////////////////////////////////////////
/// \brief RP_RoutePlan_Entrance：路径规划到离startPlace最近的ru口
/// \param startPlace：当前车辆位置
/// \param stRPResult：车道级路径规划结果
/// \return
///
RP_DLLSPEC RCStatus RP_RoutePlan_Entrance(const RPPlace& startPlace, RPResult& stRPResult);

/////////////////////////////////////////////////////////////////////////////////
/// \brief RP_RoutePlan_AllParkingLot
/// \param stStartPlace
/// \param stRPResult
/// \param vecUnAccessibleParkingLot
/// \return
///
RP_DLLSPEC RCStatus RP_RoutePlan_AllParkingLot (const RPPlace& stStartPlace,
                                 RPResult& stRPResult, vector<int>& vecUnAccessibleParkingLot);


/////////////////////////////////////////////////////////////////////////////////
/// \brief RP_RoutePlan_ParkingArea
/// \param stStartPlace
/// \param iParkingAreaID
/// \param stRPResult
/// \param vecUnAccessibleParkingLot
/// \return
///
RP_DLLSPEC RCStatus RP_RoutePlan_ParkingArea(const RPPlace& stStartPlace, const int iParkingAreaID,
                              RPResult& stRPResult, vector<int>& vecUnAccessibleParkingLot);



//////////////////////////////////////////////////////////////////////////
////设置路径规划路线形点间距
//dSpacing: 形点最大间距，单位：m
RP_DLLSPEC void RC_SetRouteShapeSpacing(double dSpacing);
////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////
RP_DLLSPEC bool RC_IsExistRoute();
//////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////
//重新路径规划
RP_DLLSPEC RCStatus RP_ReRoutePlan(RPResult& stRPResult);

/// \brief RC_DeleteRoute：删除路线
///
RP_DLLSPEC void RC_DeleteRoute();


#ifndef API_FOR_FORD
/////////////////////////////////////////////////////////////////////////////////////
/// \brief RC_PlanRoute
/// \param rcPlaces
/// \param rcCondition
/// \param rcResult
/// \return
///

RCStatus RC_PlanRoute(std::vector<RCPlace>& rcPlaces, const RCCond& rcCondition, RC_ROUT_CALCULATION_RESULT* &rcResult);

//////////////////////////////////////////////////////////////////////////////////////
/// \brief RC_RoutePlan_AllParkingLot
/// \param rcPlaces
/// \param rcCondition
/// \param rcResult
/// \return
///
RCStatus RC_RoutePlan_AllParkingLot(std::vector<RCPlace>& rcPlaces, const RCCond& rcCondition, RC_ROUT_CALCULATION_RESULT* &rcResult);

//////////////////////////////////////////////////////////////////////////////////////
/// \brief RC_RoutePlan_ParkingArea
/// \param rcPlaces
/// \param rcCondition
/// \param rcResult
/// \return
///
RCStatus RC_RoutePlan_ParkingArea(std::vector<RCPlace>& rcPlaces, const RCCond& rcCondition, RC_ROUT_CALCULATION_RESULT* &rcResult);

//////////////////////////////////////////////////////////////////////////////////////
/// \brief RC_RoutePlan_Exit
/// \param rcPlaces
/// \param rcCondition
/// \param rcResult
/// \return
///
RCStatus RC_RoutePlan_Exit(std::vector<RCPlace>& rcPlaces, const RCCond& rcCondition, RC_ROUT_CALCULATION_RESULT* &rcResult, bool bEntrance);
#endif

}
#endif // ROUTEPLANENGINE_H
