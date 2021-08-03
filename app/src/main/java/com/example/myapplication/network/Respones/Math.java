package com.example.myapplication.network.Respones;

public class Math {
    private int id;
    private int id_qs;
    private String question;
    private String ans_a;
    private String ans_b;
    private String asn_c;
    private String ans_d;
    private String result;
    private String level;
    private String number;

    public int getId_qs() {
        return id_qs;
    }

    public void setId_qs(int id_qs) {
        this.id_qs = id_qs;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Math(int id, int id_qs, String question, String ans_a, String ans_b, String asn_c, String ans_d, String result, String level, String number) {
        this.id = id;
        this.id_qs = id_qs;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.asn_c = asn_c;
        this.ans_d = ans_d;
        this.result = result;
        this.level = level;
        this.number = number;
    }

    public Math(int id_qs, String question, String ans_a, String ans_b, String asn_c, String ans_d, String result, String level) {
        this.id_qs = id_qs;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.asn_c = asn_c;
        this.ans_d = ans_d;
        this.result = result;
        this.level = level;

    }
}
