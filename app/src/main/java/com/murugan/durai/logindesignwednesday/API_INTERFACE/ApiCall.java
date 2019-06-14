package com.murugan.durai.logindesignwednesday.API_INTERFACE;



import com.murugan.durai.logindesignwednesday.MODEL.ModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {

    @GET("users")
    Call <List<ModelClass>> getdata();

}
