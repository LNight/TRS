package com.jxd.travel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.travel.dto.TicketDTO;
import com.jxd.travel.model.Ticket;
import com.jxd.travel.model.TravelRei;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ITicketDao
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/2/1
 * @Version 1.0
 */
public interface ITicketDao extends BaseMapper<Ticket> {

    IPage<TicketDTO> getAllTicketList(IPage<Ticket> page, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("empno") String empno);

    IPage<TicketDTO> getTicketList(IPage<Ticket> page, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("empno") String empno);

    List<TicketDTO> getSelectTicketList(@Param("tno") Integer tno);

    String getType(@Param("empno") String empno);

    Boolean addTicket(Map<String,Object> map);

    Boolean deleteTickets(List<Integer> tids);

    Boolean updateTicket(@Param("list") List<Integer> tids,@Param("travelinfo") String travelinfo,@Param("tno") Integer tno);

    Boolean updateTicketTno(@Param("tno") Integer tno);

    List<Integer> getVnoInfo(@Param("vno") String vno);
}
