package com.jxd.travel.controller;

import com.jxd.travel.model.Emp;
import com.jxd.travel.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpController
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/1/28
 * @Version 1.0
 */
@RestController
public class EmpController {
    @Autowired
    private IEmpService empService;

    @RequestMapping("/login")
    public String login(@RequestBody Emp emp) {
        Emp user = empService.empLogin(emp);
        if (user == null) {
            return "error";
        }
        String ename = user.getEname();
        String empno = user.getEmpno()+"";
        Integer permission = user.getPermissions();
        return permission + "," + ename + "," + empno;
    }

    /**
     *
     * @param map 四个参数  limit  page  ename  deptno
     * @return  返回数据中包括 data:所有列表数据， count总条数
     */
    @RequestMapping("/list")
    public Map<String,Object> list(@RequestBody Map<String,String> map){
        return empService.getAllEmpList(map);
    }

    @RequestMapping("/addEmp")
    public String addEmp(@RequestBody Emp emp){
        if(empService.saveEmp(emp)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/updateEmp")
    public String updateEmp(@RequestBody Emp emp){
        if(empService.updateEmp(emp)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/delbatch")
    public String delEmp(@RequestBody List<Integer> empnos){
        if(empService.removeEmps(empnos)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/reset")
    public String resetPassword(int empno){
        if(empService.resetPassword(empno)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/updPassword")
    public String updatePassword(@RequestBody Map<String,String> map){
        String oldPassword = empService.getFPassword(map.get("ename"));
        String newPassword = map.get("spassword");
        if (map.get("fpassword").equals(oldPassword)) {
            if(empService.updatePassword(map.get("ename"), newPassword)){
                return "success";
            }
            else{
                return "error";
            }
        }
        else{
            return "oldPasswordError";
        }
    }
}
