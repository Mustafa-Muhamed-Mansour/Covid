package com.covid.ui.splash;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.covid.R;
import com.covid.databinding.FragmentSplashBinding;
import com.covid.ui.adapter.onboarding.OnBoardingAapter;
import com.covid.ui.model.OnBoardingModel;

import java.util.ArrayList;
import java.util.List;

public class SplashFragment extends Fragment
{

    private FragmentSplashBinding binding;
    private NavController navController;
    private List<OnBoardingModel> onBoardingModels;
    private OnBoardingAapter onBoardingAapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentSplashBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        //Definition of NavController
        initialNavController(view);

        //Initial Views (List, adapter)
        initialViews();

        //Definition of Indicator LinearLayout (Next, Next and start page Home or other)
        indicatorLinearLayout();

        //Change Indicator LinearLayout
        setCurrentOnBoardingIndicator(0);

        //Change ViewPager2
        changeViewPager2();

        //Clicked Views (Button or other)
        clickedViews();


    }

    private void initialNavController(View view)
    {
        navController = Navigation.findNavController(view);
    }

    private void initialViews()
    {
        onBoardingModels = new ArrayList<>();
//        onBoardingModels.add(new OnBoardingModel(R.drawable., "Enjoy alone", "You can enjoy Movie X by alone"));
//        onBoardingModels.add(new OnBoardingModel(R.drawable., "watch with the one you love", "You can watch the movie X with the one you love"));
//        onBoardingModels.add(new OnBoardingModel(R.drawable., "search for a film", "You can search for x movie you want to watch"));
        onBoardingAapter = new OnBoardingAapter(onBoardingModels);
        binding.viewPagerOnboarding.setAdapter(onBoardingAapter);
    }

    private void indicatorLinearLayout()
    {
        ImageView[] indicators = new ImageView[onBoardingAapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 10, 10, 10);
        for (int i = 0; i < indicators.length; i++)
        {
            indicators[i] = new ImageView(getActivity());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.onboarding_indicator_inactive));
            indicators[i].setLayoutParams(layoutParams);
            binding.linearOnboardingIndicator.addView(indicators[i]);
        }
    }

    private void setCurrentOnBoardingIndicator(int index)
    {
        int childCount = binding.linearOnboardingIndicator.getChildCount();
        for (int i = 0; i < childCount; i++)
        {
            ImageView imageView = (ImageView) binding.linearOnboardingIndicator.getChildAt(i);
            if (i == index)
            {
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.onboarding_indicator_active));
            }
            else
            {
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.onboarding_indicator_inactive));
            }
        }
        if (index == onBoardingAapter.getItemCount() - 1)
        {
            binding.btnActionOnboarding.setText("Start");
        }
        else
        {
            binding.btnActionOnboarding.setText("Next");
        }
        binding.btnActionOnboarding.setTextColor(Color.BLACK);
    }

    private void changeViewPager2()
    {
        binding.viewPagerOnboarding.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback()
        {
            @Override
            public void onPageSelected(int position)
            {
                super.onPageSelected(position);
                setCurrentOnBoardingIndicator(position);
            }
        });
    }

    private void clickedViews()
    {
        binding.btnActionOnboarding.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (binding.viewPagerOnboarding.getCurrentItem() + 1 < onBoardingAapter.getItemCount())
                {
                    binding.viewPagerOnboarding.setCurrentItem(binding.viewPagerOnboarding.getCurrentItem() + 1);
                }
                else
                {
                    navController.navigate(R.id.action_splashFragment_to_countryFragment);
                }
            }
        });
    }
}