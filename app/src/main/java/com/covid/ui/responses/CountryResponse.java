package com.covid.ui.responses;

import com.covid.ui.model.CountryModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CountryResponse
{

    @SerializedName("countryInfo")
    private String countryInfo;
    @SerializedName("flag")
    private String countryFlag;

    private ArrayList<CountryModel> countryModels;

    public CountryResponse()
    {
    }

    public String getCountryInfo() {
        return countryInfo;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public ArrayList<CountryModel> getCountryModels() {
        return countryModels;
    }
}
