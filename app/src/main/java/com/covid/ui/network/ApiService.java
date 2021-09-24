package com.covid.ui.network;

import com.covid.ui.responses.CountryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService
{
    @GET("countries")
    Call<CountryResponse> getCountry();


}
