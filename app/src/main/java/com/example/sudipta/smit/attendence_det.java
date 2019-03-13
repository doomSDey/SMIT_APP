package com.example.sudipta.smit;

public class attendence_det {
    private String subject,code,teacher,lastUpdated;
    private String total=null,attended=null,missed=null;
    private double per;

    public attendence_det(String subject, String code, String teacher, String lastUpdated, String total, String attended, String missed, double per) {
        this.subject = subject;
        this.code = code;
        this.teacher = teacher;
        this.lastUpdated = lastUpdated;
        this.total = total;
        this.attended = attended;
        this.missed = missed;
        this.per = per;
    }

    public String getSubject() {
        return subject;
    }

    public String getCode() {
        return code;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getTotal() {
        return total;
    }

    public String getAttended() {
        return attended;
    }

    public String getMissed() {
        return missed;
    }

    public double getPer() {
        return per;
    }
}

