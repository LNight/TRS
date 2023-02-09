package com.jxd.travel.service;

import com.jxd.travel.dto.TicketDTO;
import com.jxd.travel.model.Ticket;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ITicketService
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/2/1
 * @Version 1.0
 */
public interface ITicketService {
    Map<String, Object> getAllTicketList(Map<String,Object> map);

    Map<String, Object> getTicketList(Map<String,Object> map);

    List<TicketDTO> getSelectTicketList(Map<String,Object> map);

    String getType(Map<String,String> map);

    Boolean addTicket(Map<String,Object> ticketData);

    Boolean removeTickets(List<Integer> tids);

    Boolean resetTicketTno(Integer tno);
}
