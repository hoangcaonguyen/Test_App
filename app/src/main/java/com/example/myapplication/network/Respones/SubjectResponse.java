package com.example.myapplication.network.Respones;

import com.google.gson.annotations.SerializedName;

public class SubjectResponse {

    public SubjectResponse(int id, String question, String ans_a, String ans_b, String asn_c, String ans_d, String result, String level) {
        this.id = id;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.asn_c = asn_c;
        this.ans_d = ans_d;
        this.result = result;
        this.level = level;
    }

    @SerializedName("id")
    private int id;
    @SerializedName("question")
    private String question;
    @SerializedName("ans_a")
    private String ans_a;
    @SerializedName("ans_b")
    private String ans_b;
    @SerializedName("ans_c")
    private String asn_c;
    @SerializedName("ans_d")
    private String ans_d;
    @SerializedName("result")
    private String result;
    @SerializedName("level")
    private String level;

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

}
