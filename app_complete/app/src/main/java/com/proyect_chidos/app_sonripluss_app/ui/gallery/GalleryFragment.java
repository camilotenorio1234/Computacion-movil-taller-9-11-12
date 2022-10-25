package com.proyect_chidos.app_sonripluss_app.ui.gallery;

import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.proyect_chidos.app_sonripluss_app.R;
import com.proyect_chidos.app_sonripluss_app.databinding.FragmentViewHistoriaBinding;
import com.proyect_chidos.app_sonripluss_app.interfaces.Producto_API_Client;
import com.proyect_chidos.app_sonripluss_app.interfaces.Producto_API_Emple;
import com.proyect_chidos.app_sonripluss_app.model.Client;
import com.proyect_chidos.app_sonripluss_app.model.Empleado;
import com.proyect_chidos.app_sonripluss_app.retrofic_funtion.Retrofic_class;
import com.proyect_chidos.app_sonripluss_app.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment {

    private FragmentViewHistoriaBinding binding;
    List<Client>client;
    Producto_API_Client ProductoAPI;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentViewHistoriaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}