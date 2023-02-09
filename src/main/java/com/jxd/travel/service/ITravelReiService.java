package com.jxd.travel.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ITravelReiService
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/1/31
 * @Version 1.0
 */
public interface ITravelReiService {

    Map<String, Object> getTravelReiList(Map<String,Object> map);
    Map<String, Object> getTravelReiHistoryList(Map<String,Object> map);

    Integer getTravelReiInfo(String empno);
    Integer addTravelRei(Map<String,Object> map);

    Boolean updateTravelRei(Map<String,Object> map);

    Boolean submitTravelRei(String tno,String state);

    Boolean removeTravelReis(List<Integer> tnos);

    Map<String,Object> getApprovalList(Map<String,Object> map);

    Boolean updateTravelReiState(String tno,String state,String rejectreason,String process);

    Boolean updateAllTravelReiState(List<Map<String,String>> list);
}
