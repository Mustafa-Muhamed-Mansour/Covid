package com.covid.ui.country;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.covid.databinding.CountryFragmentBinding;
import com.covid.ui.adapter.country.CountryAdapter;
import com.covid.ui.model.CountryModel;
import com.covid.ui.responses.CountryResponse;

import java.util.ArrayList;

public class CountryFragment extends Fragment
{

    private CountryFragmentBinding binding;
    private NavController navController;
    private CountryViewModel countryViewModel;
    private ArrayList<CountryModel> countryModels;
    private CountryAdapter countryAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        binding = CountryFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        countryViewModel = new ViewModelProvider(requireActivity()).get(CountryViewModel.class);

        countryModels = new ArrayList<>();
        countryAdapter = new CountryAdapter(countryModels);
        binding.rV.setAdapter(countryAdapter);
        binding.rV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        countryViewModel.getCountry().observe(getViewLifecycleOwner(), new Observer<CountryResponse>()
        {
            @Override
            public void onChanged(CountryResponse countryResponse)
            {
                if (countryResponse != null)
                {
                    if (countryResponse.getCountryFlag() != null)
                    {
                        Toast.makeText(getActivity(), countryResponse.getCountryFlag(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}