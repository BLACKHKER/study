package com.blackhker.study.designpatterns.abstractfactory;

/**
 * @Author BLACKHKER
 * @Date 2023/4/18 16:14
 * @ClassName: BenziFactory
 * @Description: 具体工厂类：奔驰工厂类
 * @Version 1.0
 */
public class BenziFactory implements CarFactory {

    /**
     * 具体工厂实现生产汽车接口，返回自己的产品：奔驰
     *
     * @return Benzi
     */
    @Override
    public Car creatCar() {
        return new Benzi();
    }
}
