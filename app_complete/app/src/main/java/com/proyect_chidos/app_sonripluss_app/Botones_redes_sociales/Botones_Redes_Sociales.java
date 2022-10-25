package com.proyect_chidos.app_sonripluss_app.Botones_redes_sociales;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.proyect_chidos.app_sonripluss_app.MainActivity;
import com.proyect_chidos.app_sonripluss_app.MenuActivity;
import com.proyect_chidos.app_sonripluss_app.R;
import com.proyect_chidos.app_sonripluss_app.utils.Constants;

public class Botones_Redes_Sociales extends AppCompatActivity{

    Button Bto_link_Face;
    Button Bto_link_Insta;
    Button Bto_link_Whatsapp;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_menu);


        Bto_link_Face=findViewById(R.id.Boton_Facebook);
        Bto_link_Insta=findViewById(R.id.Boton_Instagram);
        Bto_link_Whatsapp=findViewById(R.id.Boton_whatsapp);

        Bto_link_Face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse(Constants.BASE_URL_Facebook);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });


    }
}
