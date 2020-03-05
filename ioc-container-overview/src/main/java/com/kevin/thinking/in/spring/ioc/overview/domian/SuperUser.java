package com.kevin.thinking.in.spring.ioc.overview.domian;

import com.kevin.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * @Author kevin
 * @Description
 * @Date Created on 2020/3/4 11:34
 */

@Super
public class SuperUser extends User{

    private String addr;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "addr='" + addr + '\'' +
                "} " + super.toString();
    }
}
