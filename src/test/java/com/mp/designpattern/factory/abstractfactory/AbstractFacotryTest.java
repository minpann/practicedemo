package com.mp.designpattern.factory.abstractfactory;

import com.mp.designpattern.factory.abstractfacotry.BMW520Factory;
import com.mp.designpattern.factory.abstractfacotry.BMW523Factory;
import com.mp.designpattern.factory.abstractfacotry.BMWAbstractFactory;
import com.mp.designpattern.factory.model.AirCondition;
import com.mp.designpattern.factory.model.BMW532;
import com.mp.designpattern.factory.model.BMW520;
import com.mp.designpattern.factory.model.Engine;
import org.junit.Test;

/**
 * Created by panmin on 16-12-22.
 */
public class AbstractFacotryTest {
    @Test
    public void Customer() {
        BMWAbstractFactory factoryBMW520 = new BMW520Factory();
        Engine engineA = factoryBMW520.createEngine();
        AirCondition airConditionA = factoryBMW520.createAirCondition();

        BMWAbstractFactory factoryBMW523 = new BMW523Factory();
        Engine engineB = factoryBMW523.createEngine();
        AirCondition airConditionB = factoryBMW523.createAirCondition();
    }
}
