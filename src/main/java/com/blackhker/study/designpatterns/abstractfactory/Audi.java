package com.blackhker.study.designpatterns.abstractfactory;

/**
 * @Author BLACKHKER
 * @Date 2023/4/18 16:10
 * @ClassName: Audi
 * @Description: 具体产品类：奥迪实体类
 * @Version 1.0
 */
public class Audi implements Car {

    /**
     * 实现启动汽车接口
     */
    @Override
    public void drive() {
        System.out.println("生产奥迪车...");
    }
}
