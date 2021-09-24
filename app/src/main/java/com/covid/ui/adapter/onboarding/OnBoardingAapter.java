package com.covid.ui.adapter.onboarding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.covid.R;
import com.covid.databinding.ItemOnboardingBinding;
import com.covid.ui.model.OnBoardingModel;

import java.util.List;

public class OnBoardingAapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    private List<OnBoardingModel> onBoardingModels;

    public OnBoardingAapter(List<OnBoardingModel> onBoardingModels)
    {
        this.onBoardingModels = onBoardingModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        OnBoardingModel model = onBoardingModels.get(position);
        OnBoardingViewHolder onBoardingViewHolder = (OnBoardingViewHolder) holder;
        onBoardingViewHolder.binding.itemImgOnboarding.setImageResource(model.getImageOnBoarding());
        onBoardingViewHolder.binding.itemTxtTitle.setText(model.getTitleOnBoarding());
        onBoardingViewHolder.binding.itemTxtDescription.setText(model.getDescriptionOnBoarding());
    }

    @Override
    public int getItemCount()
    {
        return onBoardingModels.size();
    }


    public class OnBoardingViewHolder extends RecyclerView.ViewHolder
    {

        private ItemOnboardingBinding binding;

        public OnBoardingViewHolder(@NonNull ItemOnboardingBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
