package com.polymer.db.base;

import java.util.Random;

/**
字符生产输出类，包含
    线程安全方法
    线程不安全方法
 @since 2022年7月16日
 @author polymer
 */
public class CharProducer {

    // 创建的random对象
    private static   final  Random random=new Random();
    // 创建临时对象builder
    private static StringBuilder builder =null;
    /**
     * 获得一个范围内的随机数字
     * 安全机制:
     *      1. 线程安全生产，保证不被打扰
     *      2.synchronized由JVM统一管理，可靠性高
     *
     * @param min   范围数字的初始值，可以是有符号数字
     * @param max   最大值，包含本身,必须大于min
     * @return   min与max之间的任意一个数字
     */
    private synchronized int randomInt(int min,int max){
        if (min>=max)return 0;
        int len = Math.abs(max-min);//带符号数字的绝对值差,等于元素个数
        int[] m = new int[len];
        for (int t=0;t<len;t++){
            m[t]=min;
            min++;
        }
        return m[random.nextInt(len)];
    }

    /**
     * 随机生产一个int数字
     * @return 返回8位随机数字
     */
    private synchronized int randomInt(){
        return Integer.parseInt((Long.toString(System.currentTimeMillis())).substring(5));
    }

    /**
     * 生产一个字符
     * @see IConstant
     * @return IConstant中定义的任意一个字符
     */
    public static char randomChar(){
        builder=new StringBuilder();
        builder.append(IConstant.LOWER_ABC_STR);
        builder.append(IConstant.UPPER_ABC_STR);
        builder.append(IConstant.NUMBER_STR);
        return builder.charAt(random.nextInt(builder.length()));
    }

    /**
     * 获取指定长度的随机字符串
     * @param length    长度定义
     * @return 字符串
     */
    public static String getRandomChar(int length){
        if(length>0){
            builder=new StringBuilder();
            builder.append(IConstant.LOWER_ABC_STR);
            builder.append(IConstant.UPPER_ABC_STR);
            builder.append(IConstant.NUMBER_STR);
            int num = 0;
            StringBuffer b = new StringBuffer();
            while (true){
                if(num>=length){
                    break;
                }
                b.append(builder.charAt(random.nextInt(builder.length())));
                num++;
            }
            return b.toString();
        }
        return IConstant.STR_EMPTY_VALUE;
    }

    /**
     * 生产一个字定义字符串的随机字符，控制长度
     * @param sourceStr 字符串
     * @param length 长度
     * @return 2056以内长度的字符串
     */
    public  static  String getRandomChar(String sourceStr,int length){
        builder=new StringBuilder();
        for (int t=0;t<length;t++){
            builder.append(sourceStr.charAt(random.nextInt(sourceStr.length())));
        }
        return builder.toString();
    }
}
