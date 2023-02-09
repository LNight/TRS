package com.jxd.travel.dto;

/**
 * @ClassName TicketDTO
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/2/1
 * @Version 1.0
 */
public class TicketDTO {
    private Integer tid;
    private String type;
    private String startposition;
    private String endposition;
    private String startTime;
    private String endTime;
    private String vname;
    private Integer money;
    private String travelinfo;
    private Integer tno;
    private Integer empno;
    private String image;

    public TicketDTO(Integer tid, String type, String startposition, String endposition, String startTime, String endTime, String vname, Integer money, String travelinfo, Integer tno, Integer empno, String image) {
        this.tid = tid;
        this.type = type;
        this.startposition = startposition;
        this.endposition = endposition;
        this.startTime = startTime;
        this.endTime = endTime;
        this.vname = vname;
        this.money = money;
        this.travelinfo = travelinfo;
        this.tno = tno;
        this.empno = empno;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public TicketDTO() {
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartposition() {
        return startposition;
    }

    public void setStartposition(String startposition) {
        this.startposition = startposition;
    }

    public String getEndposition() {
        return endposition;
    }

    public void setEndposition(String endposition) {
        this.endposition = endposition;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getTravelinfo() {
        return travelinfo;
    }

    public void setTravelinfo(String travelinfo) {
        this.travelinfo = travelinfo;
    }

    public Integer getTno() {
        return tno;
    }

    public void setTno(Integer tno) {
        this.tno = tno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }
}
