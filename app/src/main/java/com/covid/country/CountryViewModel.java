package com.covid.ui.country;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.covid.ui.model.CountryModel;
import com.covid.ui.repositories.CountryRespository;

import java.util.ArrayList;

public class CountryViewModel extends ViewModel
{

    private CountryRespository countryRespository;

    public CountryViewModel()
    {
        countryRespository = new CountryRespository();
    }

    public LiveData<ArrayList<CountryModel>> getCountry()
    {
        return countryRespository.getCountry();
    }
}