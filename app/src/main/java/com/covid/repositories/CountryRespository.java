package com.covid.ui.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.covid.ui.model.CountryModel;
import com.covid.ui.network.ApiClient;
import com.covid.ui.network.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryRespository
{

    private ApiService apiService;
    private MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();

    public CountryRespository()
    {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<ArrayList<CountryModel>> getCountry()
    {
        MutableLiveData<ArrayList<CountryModel>> countryModelMutableLiveData = new MutableLiveData<>();

        apiService
                .getCountry()
                .enqueue(new Callback<ArrayList<CountryModel>>()
                {
                    @Override
                    public void onResponse(Call<ArrayList<CountryModel>> call, Response<ArrayList<CountryModel>> response)
                    {
                        countryModelMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<ArrayList<CountryModel>> call, Throwable t)
                    {
                        stringMutableLiveData.setValue(t.getMessage());
                    }
                });

        return countryModelMutableLiveData;
    }

}
