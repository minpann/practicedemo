package com.mp.designpattern.factory.abstractfacotry;

import com.mp.designpattern.factory.model.AirCondition;
import com.mp.designpattern.factory.model.AirConditionA;
import com.mp.designpattern.factory.model.Engine;
import com.mp.designpattern.factory.model.EngineA;

/**
 * Created by panmin on 16-12-22.
 */
public class BMW520Factory implements BMWAbstractFactory {
    @Override
    public Engine createEngine() {
        return new EngineA();
    }

    @Override
    public AirCondition createAirCondition() {
        return new AirConditionA();
    }
}
