package com.example.bimbodemo.presentation.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.bimbodemo.databinding.FragmentDescriptionBinding;
import com.example.bimbodemo.domain.model.BeerDomain;
import com.example.bimbodemo.presentation.viewmodel.ListViewModel;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class DescriptionFragment extends Fragment {
    private FragmentDescriptionBinding binding;
    private Long beerId;

    ListViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            beerId = Long.valueOf(getArguments().get("obj").toString());
        }
        viewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);
        viewModel.getBeer(beerId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDescriptionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getBeerLiveData.observe(getViewLifecycleOwner(), this::setData);

    }


    private void setData(BeerDomain s){
        Glide.with(binding.ivLogo).load(s.imageUrl).into(binding.ivLogo);
        binding.tvName.setText(s.name);
        binding.tvTagline.setText(s.tagline);
        binding.tvDescrition.setText(s.description);
    }
}