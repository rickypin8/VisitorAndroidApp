package com.ricardo.victor.data;

import com.ricardo.victor.data.pojo.UsuariosService;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GuardService {
    @Headers("Content-Type: application/json")
    @POST("/guard/gettoken.php")
    Call<UsuariosService> logIn(@Header("user") String user,@Header("password") String password);
}
