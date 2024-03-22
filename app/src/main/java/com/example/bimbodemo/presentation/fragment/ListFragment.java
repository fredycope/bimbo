package com.example.bimbodemo.presentation.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bimbodemo.R;
import com.example.bimbodemo.data.database.dbmodel.Beer;
import com.example.bimbodemo.databinding.FragmentListBinding;
import com.example.bimbodemo.databinding.FragmentLoginBinding;
import com.example.bimbodemo.domain.model.Results;
import com.example.bimbodemo.presentation.adapters.ListAdapter;
import com.example.bimbodemo.presentation.viewmodel.ListViewModel;
import com.example.bimbodemo.utils.Nav;
import com.example.bimbodemo.utils.OnClickList;
import com.example.bimbodemo.utils.Preferences;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class ListFragment extends Fragment implements OnClickList {
    private FragmentListBinding binding;
    private ListAdapter adapter;
    @Inject
    Nav navigation;

    //@Inject
    ListViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        viewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);
        adapter = new ListAdapter(this);
        /*Beer beer = new Beer();
        beer.name = "Punk IPA 2007 - 2024";
        beer.tagline = "Post Modern Classic. Spiky. Tropical. Hoppy.";
        beer.description = "Our flagship beer that kick started the craft beer revolution. This is James and Martin's original take on an American IPA, subverted with punchy New Zealand hops. Layered with new world hops to create an all-out riot of grapefruit, pineapple and lychee before a spiky, mouth-puckering bitter finish.";
        beer.imageUrl = "https://images.punkapi.com/v2/192.png";

        viewModel.saveBeers(beer);*/

        viewModel.fetchBeers();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        binding.rvBeer.setLayoutManager(new GridLayoutManager(requireContext(),2));
        binding.rvBeer.setAdapter(adapter);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        viewModel.resultsLiveData.observe(getViewLifecycleOwner(), s-> {
            adapter.addData(s);
        });

        viewModel.errorLiveData.observe(getViewLifecycleOwner(), s-> {
            Toast.makeText(requireContext(), "Error "+s, Toast.LENGTH_SHORT).show();
        });

        viewModel.beerLiveData.observe(getViewLifecycleOwner(), s->{
            if(s.isEmpty()){
                viewModel.getBeers();
            } else {
                adapter.addData(s);
            }
        });
    }

    @Override
    public void goToFragment(Object result, View view) {
        Bundle bundle = new Bundle();
        bundle.putLong("obj", (Long) result);
        navigation.gotoFragment(view, R.id.action_listFragment_to_descriptionFragment, bundle);
    }
}