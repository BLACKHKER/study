package com.blackhker.study.javaee.designpatterns.factory.abstractfactory;

/**
 * @Author BLACKHKER
 * @Date 2023/4/18 16:18
 * @ClassName: AbstractFactoryTest
 * @Description: 抽象工厂测试
 * @Version 1.0
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        // 创建奔驰工厂实例
        CarFactory benziFactory = new BenziFactory();

        // 创建奔驰车实例
        Car benchi = benziFactory.creatCar();

        // 生产奔驰车
        benchi.drive();

        /**=====================奥迪版本========================*/
        CarFactory audiFactory = new AudiFactory();
        Car audi = audiFactory.creatCar();
        audi.drive();
    }
}
