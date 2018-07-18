package com.mp.designpattern.factory.simplefactory;

import com.mp.designpattern.factory.vo.BMW;
import com.mp.designpattern.factory.vo.BMW320;
import com.mp.designpattern.factory.vo.BMW520;

/**
 * Created by panmin on 16-12-22.
 */
public class SimpleFactory {
    public BMW createBMW(int type) {
        switch (type) {

            case 320:
                return new BMW320();

            case 523:
                return new BMW520();

            default:
                break;
        }
        return null;
    }
}
