package com.jxd.travel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.travel.model.Vehicle;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IVehicleService
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/1/29
 * @Version 1.0
 */
public interface IVehicleService {
    Map<String, Object> getVehicleList(Map<String,String> map);

    List<Vehicle> getAllVehicleList();

    Boolean saveVehicle(Vehicle vehicle);

    Boolean updateVehicle(Vehicle vehicle);

    Boolean removeVehicles(List<Integer> vnos);

    Integer getVnoInfo(String vno);
}
