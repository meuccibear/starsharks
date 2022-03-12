package io.renren.business;

/**
 * @program: HNTD
 * @ClassName NumUtils
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-02-22 13:25
 * @Version 1.0
 **/
public class NumUtils {


    public static int intervalRandom(int endNum) {
        return (int) (Math.random() * endNum);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println(intervalRandom(2));;
        }
    }
}
