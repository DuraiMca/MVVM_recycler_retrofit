package com.murugan.durai.logindesignwednesday.REPOSITORY;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.murugan.durai.logindesignwednesday.API_INTERFACE.ApiCall;
import com.murugan.durai.logindesignwednesday.MODEL.ModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    Application application;
    Repository repository;





    MutableLiveData<ModelClass> mutableLiveData;
    Retrofit retrofit = null;

    public Repository(Application application) {

    }

    public Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public MutableLiveData<ModelClass> getMutableLiveData() {
        if(mutableLiveData==null){
            mutableLiveData=new MutableLiveData<>();
        }
        repository=new Repository(application);
        ApiCall apiCall = repository.getRetrofit().create(ApiCall.class);
apiCall.getdata().enqueue(new Callback<List<ModelClass>>() {
    @Override
    public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
        for (int i = 0; i < response.body().size(); i++) {

            Log.i("TAG", "onResponsefromlivedata: " + response.body().get(i).getImgurl());
            ModelClass modelClass=new ModelClass(response.body().get(i).getImgurl());
            mutableLiveData.setValue(modelClass);
        }
    }

    @Override
    public void onFailure(Call<List<ModelClass>> call, Throwable t) {

    }
});

        return mutableLiveData;
    }
}
