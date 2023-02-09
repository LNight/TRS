package com.jxd.travel.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.travel.dao.ITicketDao;
import com.jxd.travel.dao.ITravelReiDao;
import com.jxd.travel.dto.ApprovalDTO;
import com.jxd.travel.model.Emp;
import com.jxd.travel.model.TravelRei;
import com.jxd.travel.service.ITravelReiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TravelReiService
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/1/31
 * @Version 1.0
 */
@Service
public class TravelReiService implements ITravelReiService {

    @Autowired
    private ITravelReiDao travelReiDao;

    @Autowired
    private ITicketDao ticketDao;
    @Override
    public Map<String, Object> getTravelReiList(Map<String, Object> queryMap) {
        String page = queryMap.get("page").toString();
        String limit = queryMap.get("limit").toString();
        String startDate = "";
        String endDate = "";
        if(!"".equals(queryMap.get("value")) && queryMap.get("value") != null){
            List<String> date = (List<String>) queryMap.get("value");
            startDate = date.get(0);
            endDate = date.get(1);
        }
        String empno = queryMap.get("empno").toString();

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<TravelRei> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<TravelRei> pageResult = travelReiDao.getTravelReiList(pages,startDate,endDate,empno);
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
    public Map<String, Object> getTravelReiHistoryList(Map<String, Object> queryMap) {
        String page = queryMap.get("page").toString();
        String limit = queryMap.get("limit").toString();
        String startDate = "";
        String endDate = "";
        if(!"".equals(queryMap.get("value")) && queryMap.get("value") != null){
            List<String> date = (List<String>) queryMap.get("value");
            startDate = date.get(0);
            endDate = date.get(1);
        }
        String empno = queryMap.get("empno").toString();

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<TravelRei> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<TravelRei> pageResult = travelReiDao.getTravelReiHistoryList(pages,startDate,endDate,empno);
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
    public Integer getTravelReiInfo(String empno) {
        List<Integer> nums = travelReiDao.getTravelReiInfo(empno);
        return nums.size();
    }

    @Transactional
    @Override
    public Integer addTravelRei(Map<String, Object> map) {
        boolean isAddSuc = travelReiDao.insertTravelRei(map);
        List<Integer> tids = (List<Integer>) map.get("tid");
        Integer tno = (Integer) map.get("tno");
        String travelinfo = (String) map.get("travelinfo");
        boolean isUpdSuc = ticketDao.updateTicket(tids,travelinfo,tno);

        return tno;
    }

    @Override
    public Boolean updateTravelRei(Map<String, Object> map) {
        boolean isUpdSuc = travelReiDao.updateTravelRei(map);
        List<Integer> tids = (List<Integer>) map.get("tid");
        Integer tno = (Integer) map.get("tno");
        String travelinfo = (String) map.get("travelinfo");
        boolean isUpdSuc2 = ticketDao.updateTicket(tids,travelinfo,tno);

        return isUpdSuc&&isUpdSuc2;
    }

    @Override
    public Boolean submitTravelRei(String tno,String state) {
        return travelReiDao.updateState(tno,state);
    }

    @Override
    public Boolean removeTravelReis(List<Integer> tnos) {
        boolean isUpdSuc = true;
        for (Integer tno : tnos) {
            if (ticketDao.updateTicketTno(tno))  {
            }else {
                isUpdSuc = false;
            }
        }
        boolean isSuc = travelReiDao.deleteTravelReis(tnos);
        return isUpdSuc&&isSuc;
    }

    @Override
    public Map<String,Object> getApprovalList(Map<String, Object> queryMap) {
        String page = queryMap.get("page").toString();
        String limit = queryMap.get("limit").toString();
        String ename = queryMap.get("ename").toString();
        String state = queryMap.get("state").toString();

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<TravelRei> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<ApprovalDTO> pageResult = travelReiDao.getApprovalList(pages,ename,state);
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
    public Boolean updateTravelReiState(String tno, String state, String rejectreason, String process) {
        return travelReiDao.updateTravelReiState(tno, state, rejectreason, process);
    }

    @Override
    public Boolean updateAllTravelReiState(List<Map<String,String>> list) {
        boolean isSuc = true;
        String[] tnos = new String[list.size()];
        String[] state = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tnos[i] = list.get(i).get("tno");
            state[i] = list.get(i).get("state");
        }
        for(String tno : tnos){
            isSuc = travelReiDao.updateTravelReiState(tno, state[0], "", "");
        }
        return isSuc;
    }
}
