package com.murugan.durai.logindesignwednesday.VIEW;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.murugan.durai.logindesignwednesday.ADAPTER.MyAdapter;
import com.murugan.durai.logindesignwednesday.API_INTERFACE.ApiCall;
import com.murugan.durai.logindesignwednesday.GetPosition;
import com.murugan.durai.logindesignwednesday.MODEL.ModelClass;
import com.murugan.durai.logindesignwednesday.R;
import com.murugan.durai.logindesignwednesday.REPOSITORY.Repository;
import com.murugan.durai.logindesignwednesday.VIEWMODEL.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity implements GetPosition {
    MyAdapter myAdapter;
    ArrayList<ModelClass> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        myAdapter = new MyAdapter(list, Main2Activity.this);



        MainViewModel mainViewModel= ViewModelProviders.of(Main2Activity.this).get(MainViewModel.class);
        mainViewModel.getRepository().observe(this, new Observer<ModelClass>() {
            @Override
            public void onChanged(@Nullable ModelClass modelClass) {
                Log.i("TAG", "onChanged from data: "+modelClass.getImgurl());
                list.add(modelClass);
                myAdapter.update(list);
                recyclerView.setAdapter(myAdapter);
                myAdapter.setGetPosition(Main2Activity.this);
            }
        });



            }




    @Override
    public void getD(int pos) {
        Log.i("TAG", "getD: " + pos);
    }
}
