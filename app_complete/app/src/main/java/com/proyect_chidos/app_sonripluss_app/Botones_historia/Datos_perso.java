package com.proyect_chidos.app_sonripluss_app.Botones_historia;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.proyect_chidos.app_sonripluss_app.R;
import com.proyect_chidos.app_sonripluss_app.dto.Client_New;
import com.proyect_chidos.app_sonripluss_app.interfaces.Producto_API_Client;
import com.proyect_chidos.app_sonripluss_app.model.Client;
import com.proyect_chidos.app_sonripluss_app.ui.slideshow.SlideshowFragment;
import com.proyect_chidos.app_sonripluss_app.retrofic_funtion.Retrofic_class;
import com.proyect_chidos.app_sonripluss_app.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Datos_perso extends AppCompatActivity {

    private RadioGroup grupo;
    private String tipo_selec;
    private String sexo_selec;
    private String Estado_selec;
    EditText id_docu;
    EditText nombres;
    EditText Primer_apellido;
    EditText Segundo_apellido;
    EditText edad_actual;
    EditText ocupacion;
    EditText Dir_residencia;
    EditText num_tel;
    EditText Lugar_de_residencia;
    EditText Motivo_consulta;
    EditText email;
    Producto_API_Client productoAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_anadir);
        id_docu=findViewById(R.id.ID);
        nombres=findViewById(R.id.Nombres);
        Primer_apellido=findViewById(R.id.Pri_Apellido);
        Segundo_apellido=findViewById(R.id.Seg_Apellido);
        edad_actual=findViewById(R.id.Edad_act);
        ocupacion=findViewById(R.id.Ocupacion);
        Dir_residencia=findViewById(R.id.Direccion);
        num_tel=findViewById(R.id.Phone_number);
        Lugar_de_residencia=findViewById(R.id.Lugar);
        Motivo_consulta=findViewById(R.id.Motivos);
        email=findViewById(R.id.EmailAddress);


        grupo = (RadioGroup) findViewById(R.id.Radiogrup1);
        Button button1=findViewById(R.id.Añadir);
        Button button2=findViewById(R.id.Cancelar);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Client_New client_New =new Client_New(tipo_selec
                        ,Long.valueOf(id_docu.getText().toString())
                        ,nombres.getText().toString()
                        ,Primer_apellido.getText().toString()
                        ,Segundo_apellido.getText().toString()
                        ,sexo_selec
                        ,Integer.valueOf(edad_actual.getText().toString())
                        ,Estado_selec
                        ,ocupacion.getText().toString()
                        ,Dir_residencia.getText().toString()
                        ,Long.valueOf(num_tel.getText().toString())
                        ,Lugar_de_residencia.getText().toString()
                        ,Motivo_consulta.getText().toString()
                        ,email.getText().toString()
                        );
                Create_Datos(client_New);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Datos_perso.this, SlideshowFragment.class);
                startActivity(intent);
            }});
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Tipo_id_1:
                if (checked)

                    tipo_selec="Registro Civil";

                    break;
            case R.id.Tipo_id_2:
                if (checked)
                    tipo_selec="Tarjeta de Identidad";

                    break;
            case R.id.Tipo_id_3:
                if (checked)
                    tipo_selec="Cedula";

                    break;
        }
    }

    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.sexo_H:
                if (checked)
                    sexo_selec="Hombre";

                break;
            case R.id.sexo_M:
                if (checked)
                    sexo_selec="Mujer";

                break;
            case R.id.sexo_O:
                if (checked)
                    sexo_selec="Otros";

                break;
        }
    }
    public void onRadioButtonClicked3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Estado_Civil1:
                if (checked)
                    Estado_selec="Casado/Casada";

                break;
            case R.id.Estado_Civil2:
                if (checked)
                    Estado_selec="Soltero/soltera";

                break;
            case R.id.Estado_Civil3:
                if (checked)
                    Estado_selec="Indefinido";

                break;
        }
    }
    private void Create_Datos(Client_New dto){
        productoAPI= Retrofic_class.getClient(Constants.BASE_URL).create(Producto_API_Client.class);
        Call<Client> call=productoAPI.create_Client(dto);
        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                if(!response.isSuccessful()){
                    Toast toast=Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG);
                    toast.show();
                    Log.e("Response err: ",response.message());
                    return;
                }
                Client client=response.body();
                Toast toast=Toast.makeText(getApplicationContext(),client.getNombres()+" created!!",Toast.LENGTH_LONG);
                toast.show();
                callMain();
            }
            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Toast toast=Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG);
                toast.show();
                Log.e("Throw err: ",t.getMessage());
            }
        });

    }
    private void callMain() {
        Intent intent=new Intent(getApplicationContext(), SlideshowFragment.class);
        startActivity(intent);
    }
}