package com.example.demo.list;


import sun.misc.LRUCache;

import java.time.LocalDate;
import java.util.*;

public class MapTest {
    private static Map<String,Map<String,String>> cacheCodeMap = new HashMap<>();
    protected static final String REDIS_COUPON_JAVA_CODE = "couponJavaCode";
    static int i = 0;
    public static void main(String[] args) {

        for (int i = 0;i < 5000000;i++){
            generateCode();
        }
        Map<String,String> hash = cacheCodeMap.get(REDIS_COUPON_JAVA_CODE);
        System.out.println("qqqqqqqqqqqqqqq");
//        LinkedHashMap<String,String> map = new LinkedHashMap<>(7,(float) 0.75,true);
//        map.put("1","2");
//        map.put("2","2");
//        map.put("3","2");
//        map.put("4","2");
//        map.put("5","2");
//        map.put("11","2");
//        map.put("21","2");
//        map.put("31","2");
//        map.put("41","2");
//        map.put("51","2");
//        map.get("3");
//        map.get("2");
////        for (Iterator it =  map.keySet().iterator();it.hasNext();){
////            Object key = it.next()  ;
////            System.out.println( key+"="+ map.get(key));
////        }
//
//        for(Iterator iterator = map.entrySet().iterator();iterator.hasNext();){
//            Map.Entry<String,String> a  = (Map.Entry<String,String>)iterator.next();
//            System.out.println(a.getKey() + '-' + a.getValue());
//        }
//        Map<String,String> linkMap = new LinkedHashMap<>();

//        WeakHashMap<String,Integer> map = new WeakHashMap<>();
//        map.put(new String("1"),1);
//        map.put(new String("2"),2);
//        String key = null;
//        for(String s : map.keySet()){
//            if(s.equals("1")){
//                key = s;
//            }
//        }
//        System.gc();
//        System.out.println(map);
    }
    /**
     * 生成优惠码
     *
     * @return 可使用优惠码
     */
    public static String generateCode() {
        String code = getRandomNum(8);
        while(checkCode(code)){
            System.out.println("=============================重复"+i++);
            code = getRandomNum(8);
        }
        setCouponJavaCode(code);
        return code;
    }

    /**
     * 加载优惠券code
     */
    public static Map<String, Map<String,String>> setCouponJavaCode(String code){
        Map<String,String> couponCodeList = cacheCodeMap.get(REDIS_COUPON_JAVA_CODE);
        if(couponCodeList == null){
            couponCodeList = new HashMap<>();
        }
        couponCodeList.put(code,code);
        cacheCodeMap.put(REDIS_COUPON_JAVA_CODE,couponCodeList);
        return cacheCodeMap;
    }

    /**
     * 获取优惠券code
     */
    public static Map<String,String> getCouponJavaCode(){
        return cacheCodeMap.get(REDIS_COUPON_JAVA_CODE);
    }
    /**
     * 获取缓存优惠券
     */
    public static Boolean checkCode(String code){
        System.currentTimeMillis();
        Map<String,String> couponCodeList = getCouponJavaCode();
        if(couponCodeList == null || couponCodeList.size() == 0){
            return false;
        }
        if(!couponCodeList.containsKey(code)){
            return false;
        }
        return true;
    }
    private static String getRandomNum(Integer num) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        base += "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
