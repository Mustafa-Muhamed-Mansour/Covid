package com.covid.ui.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CountryInfo
{

    @SerializedName("flag")
    private String countryFlag;

    public CountryInfo()
    {
    }

    public String getCountryFlag() {
        return countryFlag;
    }


}
