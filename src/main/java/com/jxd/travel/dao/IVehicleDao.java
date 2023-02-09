package com.jxd.travel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.travel.model.Emp;
import com.jxd.travel.model.Vehicle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName IVehicleDao
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/1/29
 * @Version 1.0
 */
public interface IVehicleDao extends BaseMapper<Vehicle> {
    IPage<Vehicle> getVehicleList(IPage<Vehicle> page, @Param("vname") String vname);

    List<Vehicle> getAllVehicleList();

    Boolean insertVehicle(Vehicle vehicle);

    Boolean updateVehicle(Vehicle vehicle);

    Boolean deleteVehicles(List<Integer> vnos);

}
