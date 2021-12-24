package com.mp.designpattern.factory.abstractfacotry;

import com.mp.designpattern.factory.model.AirCondition;
import com.mp.designpattern.factory.model.Engine;

/**
 * Created by panmin on 16-12-22.
 */
public interface BMWAbstractFactory {
    Engine createEngine();
    AirCondition createAirCondition();
}
