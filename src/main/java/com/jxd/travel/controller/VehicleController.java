package com.jxd.travel.controller;

import com.jxd.travel.model.Emp;
import com.jxd.travel.model.Vehicle;
import com.jxd.travel.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName VehicleController
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/1/29
 * @Version 1.0
 */
@RestController
public class VehicleController {
    @Autowired
    private IVehicleService vehicleService;

    @RequestMapping("/vehlist")
    public Map<String,Object> vehList(@RequestBody Map<String,String> map){
        return vehicleService.getVehicleList(map);
    }

    @RequestMapping("/getvehicle")
    public List<Vehicle> vehicle(){
        return vehicleService.getAllVehicleList();
    }

    @RequestMapping("/addVehicle")
    public String addVehicle(@RequestBody Vehicle vehicle){
        if(vehicleService.saveVehicle(vehicle)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/updateVehicle")
    public String updateVehicle(@RequestBody Vehicle vehicle){
        if(vehicleService.updateVehicle(vehicle)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/delVehicles")
    public String delVehicles(@RequestBody List<Integer> vnos){
        if(vehicleService.removeVehicles(vnos)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("getvnoinfo")
    public String getVnoinfo(String vno){
        Integer nums = vehicleService.getVnoInfo(vno);
        if(nums != 0){
            return "success,"+nums;
        }else{
            return "error";
        }
    }
}
