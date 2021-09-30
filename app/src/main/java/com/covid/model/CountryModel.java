package com.covid.ui.model;

import com.covid.ui.responses.CountryInformationResponse;
import com.google.gson.annotations.SerializedName;

public class CountryModel
{

    @SerializedName("country")
    private String country;
    @SerializedName("deaths")
    private int countryDeaths;
    @SerializedName("continent")
    private String countryContinent;
    @SerializedName("countryInfo")
    private CountryInformationResponse countryInformationResponse;

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

    public CountryInformationResponse getCountryInfo() {
        return countryInformationResponse;
    }
}
