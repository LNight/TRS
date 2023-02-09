package com.jxd.travel.controller;

import com.jxd.travel.dto.TicketDTO;
import com.jxd.travel.model.Ticket;
import com.jxd.travel.service.ITicketService;
import com.jxd.travel.util.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName TicketController
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/2/1
 * @Version 1.0
 */
@RestController
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    @RequestMapping("/getticketlist")
    public Map<String,Object> list(@RequestBody Map<String,Object> map){
        return ticketService.getAllTicketList(map);
    }

    @RequestMapping("/getticketlists")
    public Map<String,Object> getTicketListlist(@RequestBody Map<String,Object> map){
        return ticketService.getTicketList(map);
    }


    @RequestMapping("/getselectticketlist")
    public List<TicketDTO> getSelectTicketList(@RequestBody Map<String,Object> map){
        return ticketService.getSelectTicketList(map);
    }

    @RequestMapping("/gettype")
    public String getType(@RequestBody Map<String,String> empno){
        return ticketService.getType(empno);
    }

    @RequestMapping("/addticket")
    public String addTicket(@RequestBody Map<String,Object> ticketData){
        if(ticketService.addTicket(ticketData)){
            return "success";
        }else{
            return "error";
        }
    }
    @RequestMapping("/delticket")
    public String delTicket(@RequestBody List<Integer> tids){
        if(ticketService.removeTickets(tids)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/resetTicketTno")
    public String resetTicketTno(Integer tno){
        if(ticketService.resetTicketTno(tno)){
            return "success";
        }else{
            return "error";
        }
    }
    /**
     * 返回图片上传后存储的地址
     * @param multipartFile
     * @return
     */
    @PostMapping("uploadimage")
    public String uploadImage(@RequestParam(value = "file") MultipartFile multipartFile){
        if (multipartFile.isEmpty()){
            return "文件有误！";
        }
        return UploadUtils.uploadImage(multipartFile);
    }

}
