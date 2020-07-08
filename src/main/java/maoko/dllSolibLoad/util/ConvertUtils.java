package maoko.dllSolibLoad.util;

/**
 * @NAME: ConvertUtils
 * @DESCRIPTION:
 * @USER: cwhu2
 * @DATE: 2020/7/5 10:05
 */
public class ConvertUtils {


    /**
     * 将字符串转为byte数据赋值给目标
     *
     * @param target 目标数组
     * @param source 原字符串
     */
    public static void fillByteArray(byte[] target, String source) {
        byte[] temp = source.getBytes();
        for (int i = 0; i < temp.length; i++) {
            target[i] = temp[i];
        }
        target[temp.length] = 0;
    }
}
