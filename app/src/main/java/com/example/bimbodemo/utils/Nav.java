package com.example.bimbodemo.utils;

import android.os.Bundle;
import android.view.View;

import androidx.navigation.Navigation;

import javax.inject.Inject;


public class Nav {
        @Inject
        public Nav() {

        }

        public void gotoFragment(View view, int id, Bundle args){
        Navigation.findNavController(view).navigate(id,args);
        }
}
