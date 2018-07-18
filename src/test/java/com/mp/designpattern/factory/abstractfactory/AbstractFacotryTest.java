package com.mp.designpattern.factory.abstractfactory;

import com.mp.designpattern.factory.abstractfacotry.FactoryBMW320;
import com.mp.designpattern.factory.abstractfacotry.FactoryBMW520;
import com.mp.designpattern.factory.vo.BMW320;
import com.mp.designpattern.factory.vo.BMW520;
import org.junit.Test;

/**
 * Created by panmin on 16-12-22.
 */
public class AbstractFacotryTest {
    @Test
    public void Customer() {
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();
        BMW320 bmw320 = factoryBMW320.createBMW();

        FactoryBMW520 factoryBMW520 = new FactoryBMW520();
        BMW520 bmw520 = factoryBMW520.createBMW();
    }
}
