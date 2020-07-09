///////////////////////////////////////////////////////
// Copyright (c) 2019, EMAPGO Technology Co., Ltd.
// All rights reserved.
// File:        RPStructAPI.h
// Version:     1.0
// Author:      Hu Cunwei
// Finish date: 2019-11-15
// Description: RP Struct API
//
// Version history
// [??????????ò????][????????????????][????????????][????????????????]

#ifndef _RP_STRUCT_API_H_
#define _RP_STRUCT_API_H_
#include <vector>
#include "routeplanengine_dllexport.h"
using namespace std;


struct RP_DLLSPEC COORD3D
{
    double dx;
    double dy;
    double dz;

};
struct RP_DLLSPEC ADAS_INFO
{
	ADAS_INFO();
	double dCurvature;
	double dSlopEV;
	double dHeading;
};
struct RP_DLLSPEC COORD3DEx : public COORD3D
{
	ADAS_INFO stAdasInfo;
};

struct RP_DLLSPEC RPPlace
{
	COORD3D crd;
    double dAngle;
};


//路径规划结果，link中的lane单元
struct RP_DLLSPEC RPLane
{
	unsigned long long iLaneID;
    vector<COORD3DEx> vecShape;
	bool bNeedChangeLane;//是否需要变道
};


//路径规划结果中的link单元
struct RP_DLLSPEC RPLink
{
	unsigned long long iLinkID;
	vector<COORD3DEx> vecShape;//link形点

	vector<RPLane> vecLane;//link包含的lane，link不存在变道时，大小为1;存在变道时，大小>1
};
//路径规划结果结构体
struct RP_DLLSPEC RPResult
{
    bool RPFlag;
    vector<RPPlace> vecRPPlace;
    vector<RPLink> vecLink;
    double dRouteLength;
};

//路径规划状态
enum RCStatus
{
	RC_SUCCESS = 0,//成功
	RC_FAIL_CANT_REACH_DEST = 1,//失败,终点不可达
	RC_FAIL_START_FAR_FROM_ROAD = 2,//起点离道路太远
	RC_FAIL_DEST_FAR_FROM_ROAD = 3,//终点离道路太远
  //  RC_FAIL_DISTANCE_TOO_SHORT = 4,//起点离终点太近
  RC_LARP_SUCCESS_HARP_FAIL = 4,//道路级路径规划成功，但是车道级规划失败
};
enum RCParkingType
{
	RCT_PARKING_P2P,
	RCT_PARKING_SECTION,
	RCT_PARKING_ALL
};
#endif