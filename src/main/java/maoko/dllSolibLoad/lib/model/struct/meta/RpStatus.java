package maoko.dllSolibLoad.lib.model.struct.meta;


/****
 * 路径规划状态
 * @author cwhu2
 */
public enum RpStatus {
    /**
     * //成功
     */
    RC_SUCCESS ,
    /**
     * 失败,终点不可达
     */
    RC_FAIL_CANT_REACH_DEST,

    /**
     * 起点离道路太远
     */
    RC_FAIL_START_FAR_FROM_ROAD ,

    /**
     * 终点离道路太远
     */
    RC_FAIL_DEST_FAR_FROM_ROAD3,

    /**
     * 道路级路径规划成功，但是车道级规划失败
     */
    RC_LARP_SUCCESS_HARP_FAIL,
}
