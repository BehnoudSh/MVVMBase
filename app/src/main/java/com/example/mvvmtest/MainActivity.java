package com.example.mvvmtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmtest.adapters.RecyclerAdapter;
import com.example.mvvmtest.models.NicePlace;
import com.example.mvvmtest.viewmodels.MainActivityViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_citylist)
    RecyclerView rv_cityList;

    @BindView(R.id.btn_addCity)
    Button btn_addCity;

    RecyclerAdapter mAdapter;

    MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getNicePlaces().observe(this, nicePlaces -> mAdapter.notifyDataSetChanged());
        initRecyclerView();

        btn_addCity.setOnClickListener(view -> mMainActivityViewModel.addNicePlace(new NicePlace("Amsterdam", R.drawable.ic_launcher_background)));
    }

    void initRecyclerView() {
        mAdapter = new RecyclerAdapter(mMainActivityViewModel.getNicePlaces().getValue(), MainActivity.this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_cityList.setLayoutManager(linearLayoutManager);
        rv_cityList.setAdapter(mAdapter);
    }
}
