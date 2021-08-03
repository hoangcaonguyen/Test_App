package com.example.myapplication.Question;

import java.io.Serializable;

public class Question implements Serializable {
    private int id;
    private String question;
    private String ans_a;
    private String ans_b;
    private String asn_c;
    private String ans_d;
    private String result;
    private int number_exam;
    private String img;
    private String subject;
    private String cautraloi = "";
    public int checkID = -1;
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Question(int id, String question, String ans_a, String ans_b, String asn_c, String ans_d, String result, String level) {
        this.id = id;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.asn_c = asn_c;
        this.ans_d = ans_d;
        this.result = result;
        this.level = level;
    }

    public String getCautraloi() {
        return cautraloi;
    }

    public void setCautraloi(String cautraloi) {
        this.cautraloi = cautraloi;
    }

    public Question(int id, String question, String ans_a, String ans_b, String asn_c, String ans_d, String result, int number_exam, String img, String subject, String cautraloi) {
        this.id = id;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.asn_c = asn_c;
        this.ans_d = ans_d;
        this.result = result;
        this.number_exam = number_exam;
        this.img = img;
        this.subject = subject;
        this.cautraloi = cautraloi;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns_a() {
        return ans_a;
    }

    public void setAns_a(String ans_a) {
        this.ans_a = ans_a;
    }

    public String getAns_b() {
        return ans_b;
    }

    public void setAns_b(String ans_b) {
        this.ans_b = ans_b;
    }

    public String getAsn_c() {
        return asn_c;
    }

    public void setAsn_c(String asn_c) {
        this.asn_c = asn_c;
    }

    public String getAns_d() {
        return ans_d;
    }

    public void setAns_d(String ans_d) {
        this.ans_d = ans_d;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getNumber_exam() {
        return number_exam;
    }

    public void setNumber_exam(int number_exam) {
        this.number_exam = number_exam;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}