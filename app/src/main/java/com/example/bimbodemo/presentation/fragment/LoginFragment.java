package com.example.bimbodemo.presentation.fragment;



import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bimbodemo.R;
import com.example.bimbodemo.databinding.FragmentLoginBinding;
import com.example.bimbodemo.utils.Nav;
import com.example.bimbodemo.utils.Preferences;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    @Inject
    Nav navigation;

    @Inject
    Preferences preferences;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.etUsername.setText(preferences.readPreference(requireActivity()));

        setListener();
    }

    private void setListener(){
        binding.btContinue.setOnClickListener(view -> {
            if(binding.etUsername.getText().toString().isEmpty()) {
                Toast.makeText(requireContext(), "Campo Vacio", Toast.LENGTH_SHORT).show();
            } else {
                preferences.savePreference(requireActivity(), binding.etUsername.getText().toString());
                navigation.gotoFragment(view, R.id.action_loginFragment_to_listFragment, null);
            }
        });
    }

}