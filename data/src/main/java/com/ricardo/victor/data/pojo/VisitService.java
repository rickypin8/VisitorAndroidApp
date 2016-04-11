package com.ricardo.victor.data.pojo;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class VisitService {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("visit")
    @Expose
    private List<Visit> visit = new ArrayList<Visit>();

    /**
     *
     * @return
     * The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The visit
     */
    public List<Visit> getVisit() {
        return visit;
    }

    /**
     *
     * @param visit
     * The visit
     */
    public void setVisit(List<Visit> visit) {
        this.visit = visit;
    }

}