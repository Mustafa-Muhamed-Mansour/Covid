package com.covid.ui.model;

import com.google.gson.annotations.SerializedName;

public class CountryModel
{

    @SerializedName("country")
    private String country;
    @SerializedName("deaths")
    private int countryDeaths;
    @SerializedName("continent")
    private String countryContinent;

    public CountryModel()
    {
    }

    public String getCountry() {
        return country;
    }

    public int getCountryDeaths() {
        return countryDeaths;
    }

    public String getCountryContinent() {
        return countryContinent;
    }
}
