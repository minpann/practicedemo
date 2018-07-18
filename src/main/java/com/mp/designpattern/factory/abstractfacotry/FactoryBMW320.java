package com.mp.designpattern.factory.abstractfacotry;

import com.mp.designpattern.factory.vo.BMW320;

/**
 * Created by panmin on 16-12-22.
 */
public class FactoryBMW320 implements FactoryBMW{
    @Override
    public BMW320 createBMW() {
        return new BMW320();
    }
}
