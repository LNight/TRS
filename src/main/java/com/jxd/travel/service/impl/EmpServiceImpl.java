package com.jxd.travel.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.travel.dao.IEmpDao;
import com.jxd.travel.dao.ITicketDao;
import com.jxd.travel.dao.ITravelReiDao;
import com.jxd.travel.model.Emp;
import com.jxd.travel.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private IEmpDao empDao;
    @Autowired
    private ITicketDao ticketDao;
    @Autowired
    private ITravelReiDao travelReiDao;

    @Override
    public Emp empLogin(Emp emp) {
        return empDao.empLogin(emp);
    }

    @Override
    public Map<String, Object> getAllEmpList(Map<String, String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        String ename = queryMap.get("ename");

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Emp> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Emp> pageResult = empDao.getAllEmpList(pages,ename);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
            return map;
        }
    }

    @Override
    public Boolean saveEmp(Emp emp) {
        return empDao.insertEmp(emp);
    }

    @Override
    public Boolean updateEmp(Emp emp) {
        return empDao.updateEmp(emp);
    }

    @Override
    public Boolean removeEmps(List<Integer> empnos) {
        boolean isDelEmpSuc = empDao.deleteEmps(empnos);
        return isDelEmpSuc;
    }

    @Override
    public Boolean resetPassword(int empno) {
        return empDao.resetPassword(empno);
    }

    @Override
    public String getFPassword(String ename) {
        String oldPassword = empDao.selectFPassword(ename);
//        System.out.println(oldPassword);
        return oldPassword;
    }

    @Override
    public Boolean updatePassword(String ename, String newPassword) {
        return empDao.updatePassword(ename, newPassword);
    }


}
