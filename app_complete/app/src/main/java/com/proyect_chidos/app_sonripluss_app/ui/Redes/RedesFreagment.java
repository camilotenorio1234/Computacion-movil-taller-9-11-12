package com.proyect_chidos.app_sonripluss_app.ui.Redes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.proyect_chidos.app_sonripluss_app.R;
import com.proyect_chidos.app_sonripluss_app.databinding.FragmentRedesBinding;
import com.proyect_chidos.app_sonripluss_app.utils.Constants;

public class RedesFreagment extends Fragment {
    private FragmentRedesBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRedesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton Bto_link_Face=(ImageButton)view.findViewById(R.id.Boton_Facebook);
        ImageButton Bto_link_Insta=(ImageButton)view.findViewById(R.id.Boton_Instagram);
        ImageButton Bto_link_Whatsapp=(ImageButton)view.findViewById(R.id.Boton_whatsapp);


        Bto_link_Face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse(Constants.BASE_URL_Facebook);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        Bto_link_Insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse(Constants.BASE_URL_Instagram);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        Bto_link_Whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri= Uri.parse(Constants.BASE_URL_Whastapp);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
