package com.jxd.travel.model;

/**
 * @ClassName Vehicle
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/1/29
 * @Version 1.0
 */
public class Vehicle {
    private Integer vno;
    private String vname;

    public Vehicle(Integer vno, String vname) {
        this.vno = vno;
        this.vname = vname;
    }

    public Vehicle() {
    }

    public Integer getVno() {
        return vno;
    }

    public void setVno(Integer vno) {
        this.vno = vno;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }
}
