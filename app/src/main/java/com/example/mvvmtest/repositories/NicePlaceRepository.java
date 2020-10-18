package com.example.mvvmtest.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmtest.R;
import com.example.mvvmtest.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

//singleton pattern
public class NicePlaceRepository {

    static NicePlaceRepository instance;

    private List<NicePlace> dataSet = new ArrayList<>();

    public static NicePlaceRepository getInstance() {

        if (instance == null) {
            instance = new NicePlaceRepository();
        }

        return instance;

    }

    public MutableLiveData<List<NicePlace>> getNicePlaces() {

        setNicePlaces();

        MutableLiveData<List<NicePlace>> mNicePlaces = new MutableLiveData<>();

        mNicePlaces.setValue(dataSet);

        return mNicePlaces;

    }

    void setNicePlaces() {

        dataSet.add(new NicePlace("Tehran", R.drawable.ic_launcher_background));
        dataSet.add(new NicePlace("Shiraz", R.drawable.ic_launcher_background));
        dataSet.add(new NicePlace("Isfahan", R.drawable.ic_launcher_background));
        dataSet.add(new NicePlace("Mashhad", R.drawable.ic_launcher_background));
        dataSet.add(new NicePlace("Ahvaz", R.drawable.ic_launcher_background));
        dataSet.add(new NicePlace("Yasouj", R.drawable.ic_launcher_background));

    }


}
