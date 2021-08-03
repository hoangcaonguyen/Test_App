package com.example.myapplication.network;

import com.example.myapplication.network.Respones.SubjectResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("SubjectLy/getDataTypeJson")
    Call<List<SubjectResponse>> getDuration();
    @GET("Subject/getDataTypeJson")
    Call<List<SubjectResponse>> getToan();
    @GET("SubjectHoa/getDataTypeJson")
    Call<List<SubjectResponse>> getHoa();
}
