package com.example.sudipta.smit;

public class Marks_det {
    private String subject,code;
    private String sessional1=null,sessional2=null,quiz1=null,quiz2=null,atttendence=null,assignment=null,endsem=null,internal=null;

    public Marks_det(String subject, String code, String sessional1, String sessional2, String quiz1, String quiz2, String atttendence, String assignment, String endsem, String internal) {
        this.subject = subject;
        this.code = code;
        this.sessional1 = sessional1;
        this.sessional2 = sessional2;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.atttendence = atttendence;
        this.assignment = assignment;
        this.endsem = endsem;
        this.internal = internal;
    }

    public String getSubject() {
        return subject;
    }

    public String getCode() {
        return code;
    }

    public String getSessional1() {
        return sessional1;
    }

    public String getSessional2() {
        return sessional2;
    }

    public String getQuiz1() {
        return quiz1;
    }

    public String getQuiz2() {
        return quiz2;
    }

    public String getAtttendence() {
        return atttendence;
    }

    public String getAssignment() {
        return assignment;
    }

    public String getEndsem() {
        return endsem;
    }

    public String getInternal() {
        return internal;
    }
}

