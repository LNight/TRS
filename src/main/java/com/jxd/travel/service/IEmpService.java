package com.jxd.travel.service;

import com.jxd.travel.model.Emp;

import java.util.List;
import java.util.Map;

public interface IEmpService {
    Emp empLogin(Emp emp);

    Map<String, Object> getAllEmpList(Map<String,String> map);

    Boolean saveEmp(Emp emp);

    Boolean updateEmp(Emp emp);

    Boolean removeEmps(List<Integer> empnos);

    Boolean resetPassword(int empno);

    String getFPassword(String ename);

    Boolean updatePassword(String ename,String newPassword);
}
