package com.proyect_chidos.app_sonripluss_app.ui.slideshow;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.proyect_chidos.app_sonripluss_app.ui.slideshow.tab_fragment.Antecedentess;
import com.proyect_chidos.app_sonripluss_app.ui.slideshow.tab_fragment.Examen_Estoma;
import com.proyect_chidos.app_sonripluss_app.ui.slideshow.tab_fragment.Odontograma;
import com.proyect_chidos.app_sonripluss_app.ui.slideshow.tab_fragment.add_datos;

public class VPAdapter extends FragmentStateAdapter {

    public VPAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new add_datos();
            case 1:
                return new Antecedentess();
            case 2:
                return new Examen_Estoma();
            case 3:
                return new Odontograma();
            default:
                return new add_datos();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
