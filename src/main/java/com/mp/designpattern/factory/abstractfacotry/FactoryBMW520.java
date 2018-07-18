package com.mp.designpattern.factory.abstractfacotry;

import com.mp.designpattern.factory.vo.BMW520;

/**
 * Created by panmin on 16-12-22.
 */
public class FactoryBMW520 implements FactoryBMW{
    @Override
    public BMW520 createBMW() {
        return new BMW520();
    }
}
