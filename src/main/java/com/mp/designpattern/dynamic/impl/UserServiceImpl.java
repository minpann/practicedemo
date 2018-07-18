package com.mp.designpattern.dynamic.impl;

import com.mp.designpattern.dynamic.UserService;

/**
 * Created by panmin on 16-12-22.
 */
public class UserServiceImpl implements UserService {

    @Override
    public String getName() {
        System.out.println("-------get Name: 动态代理-------");
        return "动态代理";
    }

    @Override
    public String getAddress() {
        System.out.println("-------get Address: 北京朝阳-------");
        return "北京朝阳";
    }
}
