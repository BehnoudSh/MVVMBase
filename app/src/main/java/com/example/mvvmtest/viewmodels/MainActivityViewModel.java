package com.example.mvvmtest.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmtest.models.NicePlace;
import com.example.mvvmtest.repositories.NicePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlaces;

    public void init() {

        if (mNicePlaces == null) {
            NicePlaceRepository mRepo = NicePlaceRepository.getInstance();
            mNicePlaces = mRepo.getNicePlaces();
        }


    }

    public LiveData<List<NicePlace>> getNicePlaces() {
        return mNicePlaces;
    }

    public void addNicePlace(NicePlace input) {

        List<NicePlace> currentPlaces = mNicePlaces.getValue();
        currentPlaces.add(input);
        mNicePlaces.postValue(currentPlaces);


    }


}
