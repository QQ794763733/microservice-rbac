package cn.microservice.www.utils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.Map;
import java.util.SortedMap;

/**
 * @Author: MachineGeek
 * @Description: 微信支付工具类
 * @Date: 2020/10/1
 */
public class WeChatPayUtil {
    /** @Author: MachineGeek
    * @Description: 微信支付MD5签名算法
    * @Date: 2020/10/1
     * @param map
     * @param apiKey
    * @Return java.lang.String
    */
    public static String weChatPaySign(SortedMap<Object, Object> map, String apiKey) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Object, Object> m : map.entrySet()) {
            if ("".equals(m.getValue()) || null == m.getValue()) {
                continue;
            }
            sb.append(m.getKey()).append("=").append(m.getValue()).append("&");
        }
        sb.append("key=" + apiKey);
        String md5Str = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(sb.toString().getBytes());

            int i;
            StringBuffer buf = new StringBuffer("");

            for(int offset=0; offset<digest.length; offset++){
                i = digest[offset];
                if(i<0){
                    i+=256;
                }
                if(i<16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            md5Str = buf.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5Str;
    }

    /** @Author: MachineGeek
    * @Description: 转换BigDecimal为分为单位
    * @Date: 2020/10/1
     * @param yuan
     * @param toInt
    * @Return java.lang.Object
    */
    public static Object convertToPenny(BigDecimal yuan, Boolean toInt) {
        BigDecimal bigDecimal = yuan.multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_HALF_UP);
        return toInt ? bigDecimal.intValue() : bigDecimal;
    }

    /** @Author: MachineGeek
    * @Description: 转换分为BigDecimal为单位
    * @Date: 2020/10/1
     * @param price
    * @Return java.lang.String
    */
    public static String convertToYuan(int price) {
        return BigDecimal.valueOf(Long.valueOf(price)).divide(new BigDecimal(100)).toString();
    }
}
