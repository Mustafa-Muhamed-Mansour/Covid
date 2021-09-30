package com.covid.ui.network;

import com.covid.ui.model.CountryModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService
{
    @GET("countries")
    Call<ArrayList<CountryModel>> getCountry();

}
