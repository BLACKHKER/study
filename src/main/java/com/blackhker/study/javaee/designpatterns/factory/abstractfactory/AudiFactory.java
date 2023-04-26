package com.blackhker.study.javaee.designpatterns.factory.abstractfactory;

/**
 * @Author BLACKHKER
 * @Date 2023/4/18 16:16
 * @ClassName: AudiFactory
 * @Description: TODO
 * @Version 1.0
 */
public class AudiFactory implements CarFactory {

    /**
     * 具体工厂实现生产汽车接口，返回自己的产品：奔驰
     *
     * @return Audi
     */
    @Override
    public Car creatCar() {
        return new Audi();
    }
}
