package com.mp.designpattern.factory.simplefactory;

import com.mp.designpattern.factory.vo.BMW;
import com.mp.designpattern.factory.vo.BMW320;
import com.mp.designpattern.factory.vo.BMW520;
import org.junit.Test;

/**
 * Created by panmin on 16-12-22.
 */
public class SimpleFactoryTest {
    @Test
    public void Customer(){
        SimpleFactory factory = new SimpleFactory();
        BMW bmw320 = new BMW320();
        BMW bmw520 = new BMW520();
    }
}
