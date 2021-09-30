package com.covid.ui.adapter.country;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.covid.R;
import com.covid.ui.model.CountryModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>
{

    private ArrayList<CountryModel> countryModels;

    public CountryAdapter(ArrayList<CountryModel> countryModels)
    {
        this.countryModels = countryModels;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position)
    {
       CountryModel model = countryModels.get(position);
       holder.textName.setText(model.getCountry());
       holder.textDeath.setText(String.valueOf(model.getCountryDeaths()));
       holder.textContinent.setText(model.getCountryContinent());
       Glide
               .with(holder.itemView.getContext())
               .load(model.getCountryInfo().getCountryFlag())
               .into(holder.imageCountry);
    }

    @Override
    public int getItemCount()
    {
        return countryModels.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder
    {
        private CircleImageView imageCountry;
        private TextView textName, textDeath, textContinent;

        public CountryViewHolder(@NonNull View itemView)
        {
            super(itemView);

            imageCountry = itemView.findViewById(R.id.item_img_country);
            textName = itemView.findViewById(R.id.item_name_country);
            textDeath = itemView.findViewById(R.id.item_deaths_country);
            textContinent = itemView.findViewById(R.id.item_continent_country);
        }
    }
}
