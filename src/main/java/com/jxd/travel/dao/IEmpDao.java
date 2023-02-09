package com.jxd.travel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.travel.model.Emp;
import com.jxd.travel.model.Vehicle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmpDao extends BaseMapper<Emp> {
    Emp empLogin(Emp emp);

    IPage<Emp> getAllEmpList(IPage<Emp> page, @Param("ename") String ename);

    Boolean insertEmp(Emp emp);

    Boolean updateEmp(Emp emp);

    Boolean deleteEmps(List<Integer> empnos);

    Boolean resetPassword(@Param("empno") int empno);

    String selectFPassword(@Param("ename") String ename);

    Boolean updatePassword(@Param("ename") String ename,@Param("newPassword") String newPassword);
}
