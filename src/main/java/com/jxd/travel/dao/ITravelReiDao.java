package com.jxd.travel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.travel.dto.ApprovalDTO;
import com.jxd.travel.model.TravelRei;
import com.jxd.travel.model.Vehicle;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ITravelReiDao
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/1/31
 * @Version 1.0
 */
public interface ITravelReiDao extends BaseMapper<TravelRei> {
    IPage<TravelRei> getTravelReiList(IPage<TravelRei> page, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("empno") String empno);
    IPage<TravelRei> getTravelReiHistoryList(IPage<TravelRei> page, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("empno") String empno);
    Boolean insertTravelRei(Map<String,Object> map);
    Boolean updateState(@Param("tno") String tno,@Param("state") String state);
    Boolean updateTravelRei(Map<String,Object> map);
    Boolean deleteTravelReis(List<Integer> tnos);
    IPage<ApprovalDTO> getApprovalList(IPage<TravelRei> page,@Param("ename") String ename, @Param("state") String state);
    List<Integer> getTravelReiInfo(@Param("empno") String empno);
    Boolean updateTravelReiState(@Param("tno") String tno,@Param("state") String state,@Param("rejectreason") String rejectreason,@Param("process") String process);
}
