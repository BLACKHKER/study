package com.blackhker.study.foundation.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author BLACKHKER
 * @Date 2023/8/18 18:02
 * @ClassName: NumInterchange
 * @Description: 数字互换
 * @Version 1.0
 */
@Slf4j
public class NumInterchange {

    /**
     * 不使用中间变量的情况下，交换两个属性的值
     */
    @Test
    public void demo1() {

        int a = 5;
        int b = 10;

        a = a + b;  // a = 5 + 10   15
        b = a - b;  // b = 15 - 10  5
        a = a - b;  // a =

        System.out.println("交换后：" + "a:" + a + "," + "b:" + b);
    }

    /**
     * 不使用中间变量的情况下，交换两个属性的值
     */
    @Test
    public void demo2() {

        int a = 5;
        int b = 10;

        // 位运算，异或

        a = a ^ b;  // a = 5 + 10   15
        b = a ^ b;  // b = 15 - 10  5
        a = a ^ b;  // a =

        System.out.println("交换后：" + "a:" + a + "," + "b:" + b);
    }

}
