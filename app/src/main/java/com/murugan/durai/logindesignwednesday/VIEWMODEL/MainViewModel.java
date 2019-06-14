package com.murugan.durai.logindesignwednesday.VIEWMODEL;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.murugan.durai.logindesignwednesday.MODEL.ModelClass;
import com.murugan.durai.logindesignwednesday.REPOSITORY.Repository;

public class MainViewModel extends AndroidViewModel {
    Repository repository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
    }

    public MutableLiveData<ModelClass> getRepository() {
        return repository.getMutableLiveData();
    }
}
