package com.mp.designpattern.factory.simplefactory;

import com.mp.designpattern.factory.model.BMW;
import com.mp.designpattern.factory.model.BMW520;
import com.mp.designpattern.factory.model.BMW532;

/**
 * Created by panmin on 16-12-22.
 */
public class BMW520Factory implements SimpleFactory {
    @Override
    public BMW createBMW() {
        return new BMW520();
    }
}
