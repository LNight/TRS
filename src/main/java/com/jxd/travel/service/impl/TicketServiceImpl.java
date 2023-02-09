package com.jxd.travel.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.travel.dao.ITicketDao;
import com.jxd.travel.dto.TicketDTO;
import com.jxd.travel.model.Ticket;
import com.jxd.travel.model.TravelRei;
import com.jxd.travel.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TicketServiceImpl
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/2/1
 * @Version 1.0
 */
@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    private ITicketDao ticketDao;

    @Override
    public Map<String, Object> getAllTicketList(Map<String, Object> queryMap) {
        String page = queryMap.get("page").toString();
        String limit = queryMap.get("limit").toString();
        String startTime = "";
        String endTime = "";
        if(!"".equals(queryMap.get("value")) && queryMap.get("value") != null){
            List<String> date = (List<String>) queryMap.get("value");
            startTime = date.get(0);
            endTime = date.get(1);
        }
        String empno = queryMap.get("empno").toString();

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Ticket> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<TicketDTO> pageResult = ticketDao.getAllTicketList(pages,startTime,endTime,empno);
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
    public Map<String, Object> getTicketList(Map<String, Object> queryMap) {
        String page = queryMap.get("page").toString();
        String limit = queryMap.get("limit").toString();
        String startTime = "";
        String endTime = "";
        if(!"".equals(queryMap.get("value")) && queryMap.get("value") != null){
            List<String> date = (List<String>) queryMap.get("value");
            startTime = date.get(0);
            endTime = date.get(1);
        }
        String empno = queryMap.get("empno").toString();

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Ticket> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<TicketDTO> pageResult = ticketDao.getTicketList(pages,startTime,endTime,empno);
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
    public List<TicketDTO> getSelectTicketList(Map<String, Object> map) {
        Integer tno = (Integer) map.get("tno");
        return ticketDao.getSelectTicketList(tno);
    }

    @Override
    public String getType(Map<String,String> map) {
        String type = ticketDao.getType(map.get("empno"));
        System.out.println(type);
        return type;
    }

    @Override
    public Boolean addTicket(Map<String,Object> ticketData) {
        List<String> date = (List<String>) ticketData.get("value");
        String startTime = date.get(0);
        String endTime = date.get(1);
        Map<String, Object> map = ticketData;
        map.remove("value");
        map.put("startTime",startTime);
        map.put("endTime", endTime);

        return ticketDao.addTicket(map);
    }

    @Override
    public Boolean removeTickets(List<Integer> tids) {
        return ticketDao.deleteTickets(tids);
    }

    @Override
    public Boolean resetTicketTno(Integer tno) {
        return ticketDao.updateTicketTno(tno);
    }
}
