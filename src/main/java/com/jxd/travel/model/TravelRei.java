package com.jxd.travel.model;

/**
 * @ClassName TravelRei
 * @Description TODO
 * @Auther liuzhiyong
 * @Date 2023/1/30
 * @Version 1.0
 */
public class TravelRei {
    private Integer tno;
    private Integer empno;
    private String startdate;
    private String enddate;
    private Integer tdays;
    private String travelinfo;
    private String reidate;
    private Integer subsidy;
    private Integer totalrei;
    private Integer state;
    private String rejectreason;
    private String process;

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public TravelRei(Integer tno, Integer empno, String startdate, String enddate, Integer tdays, String travelinfo, String reidate, Integer subsidy, Integer totalrei, Integer state, String rejectreason, String process) {
        this.tno = tno;
        this.empno = empno;
        this.startdate = startdate;
        this.enddate = enddate;
        this.tdays = tdays;
        this.travelinfo = travelinfo;
        this.reidate = reidate;
        this.subsidy = subsidy;
        this.totalrei = totalrei;
        this.state = state;
        this.rejectreason = rejectreason;
        this.process = process;
    }

    public String getRejectreason() {
        return rejectreason;
    }

    public void setRejectreason(String rejectreason) {
        this.rejectreason = rejectreason;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public TravelRei() {
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

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Integer getTdays() {
        return tdays;
    }

    public void setTdays(Integer tdays) {
        this.tdays = tdays;
    }

    public String getTravelinfo() {
        return travelinfo;
    }

    public void setTravelinfo(String travelinfo) {
        this.travelinfo = travelinfo;
    }

    public String getReidate() {
        return reidate;
    }

    public void setReidate(String reidate) {
        this.reidate = reidate;
    }

    public Integer getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(Integer subsidy) {
        this.subsidy = subsidy;
    }

    public Integer getTotalrei() {
        return totalrei;
    }

    public void setTotalrei(Integer totalrei) {
        this.totalrei = totalrei;
    }
}
