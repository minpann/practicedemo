package com.mp.designpattern.factory.abstractfacotry;

import com.mp.designpattern.factory.model.*;

/**
 * Created by panmin on 16-12-22.
 */
public class BMW523Factory implements BMWAbstractFactory {
    @Override
    public Engine createEngine() {
        return new EngineB();
    }

    @Override
    public AirCondition createAirCondition() {
        return new AirConditionB();
    }
}
