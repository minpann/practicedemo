package com.mp.designpattern.factory.simplefactory;

import com.mp.designpattern.factory.model.BMW;
import org.junit.Test;

/**
 * Created by panmin on 16-12-22.
 */
public class SimpleFactoryTest {
    @Test
    public void Customer(){
        SimpleFactory factory = new BMW520Factory();
        BMW bmw520 = factory.createBMW();
        factory = new BMW523Factory();
        BMW bmw532 = factory.createBMW();
    }
}
