package com.blackhker.study.javaee.designpatterns.factory.functionfactory;

/**
 * @Author BLACKHKER
 * @Date 2023/4/24 11:26
 * @ClassName: FunctionFactory
 * @Description: 工厂方法模式：与简单工厂的区别在于工厂有一个公共的接口、被生产对象的公共接口
 * @Version 1.0
 */

import org.junit.Test;

/**
 * 被生产对象的公共接口
 */
interface Transportation {
    void run();
}

/**
 * 抽象的被生产的对象：让被生产的对象可以有差异化
 */
abstract class AbstractTransportation implements Transportation {

    public String name;

    public AbstractTransportation(String name) {
        this.name = name;
    }
}

/**
 * 具体的产品
 */
class Bike extends AbstractTransportation {

    public Bike(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("run");
    }
}

class Plane extends AbstractTransportation {

    public Plane(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("fly");
    }
}

class Ship extends AbstractTransportation {

    public Ship(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("lang");
    }
}

/**
 * 工厂的公共接口
 */
interface ITransportationFactory {

    int TYPE_BIKE = 1;
    int TYPE_PLANE = 2;
    int TYPE_SHIP = 3;

    Transportation create(int type);
}

/**
 * 具体的工厂
 */
class TransportationFactory implements ITransportationFactory {

    @Override
    public Transportation create(int type) {
        if (type == 1) {
            return new Bike("捷安特");
        } else if (type == 2) {
            return new Plane("MH370");
        } else if (type == 3) {
            return new Ship("航母");
        }
        return null;
    }
}

public class FunctionFactory {

    @Test
    public void Test() {
        ITransportationFactory factory = new TransportationFactory();

        Transportation transportation = factory.create(ITransportationFactory.TYPE_PLANE);

        System.out.println(transportation);
    }
}