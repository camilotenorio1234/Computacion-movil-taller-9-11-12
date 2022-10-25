package com.proyect_chidos.app_sonripluss_app.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.proyect_chidos.app_sonripluss_app.R;
import com.proyect_chidos.app_sonripluss_app.databinding.FragmentAddHistoriaBinding;

public class SlideshowFragment extends Fragment {

    private FragmentAddHistoriaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddHistoriaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    final NavController navController=Navigation.findNavController(view);
        Button button1=view.findViewById(R.id.Boton_Datos_personales);
        Button button2=view.findViewById(R.id.Boton_Antecedentes);
        Button button3=view.findViewById(R.id.Boton_Tabla_Articulacion);
        Button button4=view.findViewById(R.id.Boton_Examen_Estomo);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              navController.navigate(R.id.action_nav_añadir_to_anadir);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_añadir_to_antecedentes);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_añadir_to_odontograma);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_añadir_to_examen_Estama);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}