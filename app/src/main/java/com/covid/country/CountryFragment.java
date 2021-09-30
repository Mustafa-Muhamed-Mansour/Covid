package com.covid.ui.country;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.covid.databinding.CountryFragmentBinding;
import com.covid.ui.adapter.country.CountryAdapter;
import com.covid.ui.model.CountryModel;

import java.util.ArrayList;
import java.util.Locale;

public class CountryFragment extends Fragment
{

    private CountryFragmentBinding binding;
    private NavController navController;
    private CountryViewModel countryViewModel;
    private CountryAdapter countryAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        binding = CountryFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        countryViewModel = new ViewModelProvider(requireActivity()).get(CountryViewModel.class);


    }

    @Override
    public void onStart()
    {
        super.onStart();

        countryViewModel.getCountry().observe(getViewLifecycleOwner(), new Observer<ArrayList<CountryModel>>()
        {
            @Override
            public void onChanged(ArrayList<CountryModel> countryModels)
            {
                countryAdapter = new CountryAdapter(countryModels);
                binding.rV.setAdapter(countryAdapter);
                binding.rV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                binding.rV.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
            }
        });
    }
}