package com.covid.ui.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.covid.ui.network.ApiClient;
import com.covid.ui.network.ApiService;
import com.covid.ui.responses.CountryResponse;

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

    public LiveData<CountryResponse> getCountry()
    {
        MutableLiveData<CountryResponse> countryResponseMutableLiveData = new MutableLiveData<>();

        apiService
                .getCountry()
                .enqueue(new Callback<CountryResponse>()
                {
                    @Override
                    public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response)
                    {
                        countryResponseMutableLiveData.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<CountryResponse> call, Throwable t)
                    {
                        stringMutableLiveData.setValue(t.getMessage());
                    }
                });

        return countryResponseMutableLiveData;
    }

}
