#pragma once


#ifdef	ROUTEPLANENGINE_EXPORTS

/*------------------------- 动态链接库导出使用 ----------------------------***/
/**/#ifdef __cplusplus
/**/#define RP_DLLSPEC __declspec (dllexport)
/**/#else // __cplusplus
/**/#define RP_DLLSPEC 
/**/#endif // __cplusplus

/*****************************************************************************/
#if _MSC_VER<1400
typedef unsigned long ULONG_PTR, *PULONG_PTR;
#endif
/*****************************************************************************/

#else
/*------------------------- 动态链接库导入使用 ----------------------------***/

/**/#ifdef _DEBUG
/**/#pragma comment( lib, "routeplanEngine_d" )
/**/#else // _DEBUG
/**/#pragma comment( lib, "routeplanEngine" )
/**/#endif // _DEBUG

/**/#ifdef __cplusplus
/**/#define RP_DLLSPEC __declspec (dllimport)
/**/#else // __cplusplus
/**/#define RP_DLLSPEC 
/**/#endif // __cplusplus
#include "routeplanengine.h"
#include "RPStructAPI.h"
#undef DLLSPEC

#endif // DATAACCESS_EXPORTS
