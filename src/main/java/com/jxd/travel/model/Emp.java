package com.jxd.travel.model;

/**
 * @ClassName Emp
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/1/28
 * @Version 1.0
 */
public class Emp {
    private Integer empno;
    private String ename;
    private String password;
    private String sex;
    private String phone;
    private Integer permissions;

    public Emp() {
    }

    public Emp(Integer empno, String ename, String password, String sex, String phone, Integer permissions) {
        this.empno = empno;
        this.ename = ename;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.permissions = permissions;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPermissions() {
        return permissions;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }
}
