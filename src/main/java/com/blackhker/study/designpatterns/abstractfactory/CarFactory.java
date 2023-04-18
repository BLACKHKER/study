package com.blackhker.study.designpatterns.abstractfactory;

/**
 * @Author BLACKHKER
 * @Date 2023/4/18 16:11
 * @ClassName: CarFactory
 * @Description: 抽象工厂接口，由各个厂商的工厂类实现
 * @Version 1.0
 */
public interface CarFactory {

    // 生产汽车接口，返回父类Car
    Car creatCar();
}
