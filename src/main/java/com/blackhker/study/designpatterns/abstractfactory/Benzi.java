package com.blackhker.study.designpatterns.abstractfactory;

/**
 * @Author BLACKHKER
 * @Date 2023/4/18 16:09
 * @ClassName: Benzi
 * @Description: 具体产品类：奔驰实体类
 * @Version 1.0
 */
public class Benzi implements Car {

    /**
     * 实现启动汽车接口
     */
    @Override
    public void drive() {
        System.out.println("生产奔驰车...");
    }
}
