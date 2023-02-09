package com.jxd.travel.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.travel.dao.ITicketDao;
import com.jxd.travel.dao.IVehicleDao;
import com.jxd.travel.model.Emp;
import com.jxd.travel.model.Vehicle;
import com.jxd.travel.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName VehicleServiceImpl
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/1/29
 * @Version 1.0
 */
@Service
public class VehicleServiceImpl implements IVehicleService {
    @Autowired
    private IVehicleDao vehicleDao;

    @Autowired
    private ITicketDao ticketDao;

    @Override
    public Map<String, Object> getVehicleList(Map<String, String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        String vname = queryMap.get("vname");

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Vehicle> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Vehicle> pageResult = vehicleDao.getVehicleList(pages,vname);
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
    public List<Vehicle> getAllVehicleList() {
        return vehicleDao.getAllVehicleList();
    }

    @Override
    public Boolean saveVehicle(Vehicle vehicle) {
        return vehicleDao.insertVehicle(vehicle);
    }

    @Override
    public Boolean updateVehicle(Vehicle vehicle) {
        return vehicleDao.updateVehicle(vehicle);
    }

    @Override
    public Boolean removeVehicles(List<Integer> vnos) {
        return vehicleDao.deleteVehicles(vnos);
    }

    @Override
    public Integer getVnoInfo(String vno) {
        List<Integer> nums = ticketDao.getVnoInfo(vno);
        return nums.size();
    }
}
