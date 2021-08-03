package com.example.myapplication.Fragment;

public class Contact {
    private String mNumberExam;
    private String diem;
    private int idDe;

    public Contact(String mNumberExam, String diem, int idDe) {
        this.mNumberExam = mNumberExam;
        this.diem = diem;
        this.idDe = idDe;
    }

    public String getmNumberExam() {
        return mNumberExam;
    }

    public void setmNumberExam(String mNumberExam) {
        this.mNumberExam = mNumberExam;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }

    public int getIdDe() {
        return idDe;
    }

    public void setIdDe(int idDe) {
        this.idDe = idDe;
    }
}
