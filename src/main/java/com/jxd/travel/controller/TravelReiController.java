package com.jxd.travel.controller;

import com.jxd.travel.service.ITravelReiService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TravelReiController
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/1/30
 * @Version 1.0
 */
@RestController
public class TravelReiController {

    @Autowired
    private ITravelReiService travelReiService;

    @RequestMapping("/travelreilist")
    public Map<String,Object> list(@RequestBody Map<String,Object> map){
        return travelReiService.getTravelReiList(map);
    }
    @RequestMapping("gettravelreiinfo")
    public String getTravelReiInfo(String empno){
        Integer nums = travelReiService.getTravelReiInfo(empno);
        if(nums != 0){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/historylist")
    public Map<String,Object> historyList(@RequestBody Map<String,Object> map){
        return travelReiService.getTravelReiHistoryList(map);
    }

    @RequestMapping("/addtravelrei")
    public String addTravelRei(@RequestBody Map<String,Object> travelReiData){
        Integer tno = travelReiService.addTravelRei(travelReiData);
        if(tno != null){
            return "success,"+tno;
        }else{
            return "error";
        }
    }

    @RequestMapping("/updatetravelrei")
    public String updateTravelRei(@RequestBody Map<String,Object> travelReiData){
        Boolean isSuc = travelReiService.updateTravelRei(travelReiData);
        if(isSuc){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/submittravel")
    public String submitTravelrei(@Param("tno") String tno,@Param("state") String state){
        if(travelReiService.submitTravelRei(tno,state)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/deltravelrei")
    public String delTravelRei(@RequestBody List<Integer> tids){
        if(travelReiService.removeTravelReis(tids)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/getapprovallist")
    public Map<String,Object> getApprovalList(@RequestBody Map<String,Object> map) {
        return travelReiService.getApprovalList(map);
    }

    @RequestMapping("/passapproval")
    public String passApproval(@Param("tno") String tno,@Param("state") String state,@Param("rejectreason") String rejectreason,@Param("process") String process){
        if(travelReiService.updateTravelReiState(tno,state,rejectreason,process)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/passallapproval")
    public String passAllApproval(@RequestBody List<Map<String,String>> list){
        if(travelReiService.updateAllTravelReiState(list)){
            return "success";
        }else{
            return "error";
        }
    }
}
