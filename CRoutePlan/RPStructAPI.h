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
// [??????????��????][????????????????][????????????][????????????????]

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


//·���滮�����link�е�lane��Ԫ
struct RP_DLLSPEC RPLane
{
	unsigned long long iLaneID;
    vector<COORD3DEx> vecShape;
	bool bNeedChangeLane;//�Ƿ���Ҫ���
};


//·���滮����е�link��Ԫ
struct RP_DLLSPEC RPLink
{
	unsigned long long iLinkID;
	vector<COORD3DEx> vecShape;//link�ε�

	vector<RPLane> vecLane;//link������lane��link�����ڱ��ʱ����СΪ1;���ڱ��ʱ����С>1
};
//·���滮����ṹ��
struct RP_DLLSPEC RPResult
{
    bool RPFlag;
    vector<RPPlace> vecRPPlace;
    vector<RPLink> vecLink;
    double dRouteLength;
};

//·���滮״̬
enum RCStatus
{
	RC_SUCCESS = 0,//�ɹ�
	RC_FAIL_CANT_REACH_DEST = 1,//ʧ��,�յ㲻�ɴ�
	RC_FAIL_START_FAR_FROM_ROAD = 2,//������·̫Զ
	RC_FAIL_DEST_FAR_FROM_ROAD = 3,//�յ����·̫Զ
  //  RC_FAIL_DISTANCE_TOO_SHORT = 4,//������յ�̫��
  RC_LARP_SUCCESS_HARP_FAIL = 4,//��·��·���滮�ɹ������ǳ������滮ʧ��
};
enum RCParkingType
{
	RCT_PARKING_P2P,
	RCT_PARKING_SECTION,
	RCT_PARKING_ALL
};
#endif