package com.covid.ui.country;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.covid.ui.repositories.CountryRespository;
import com.covid.ui.responses.CountryResponse;

public class CountryViewModel extends ViewModel
{

    private CountryRespository countryRespository;

    public CountryViewModel()
    {
        countryRespository = new CountryRespository();
    }

    public LiveData<CountryResponse> getCountry()
    {
        return countryRespository.getCountry();
    }
}