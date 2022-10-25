package com.proyect_chidos.app_sonripluss_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.proyect_chidos.app_sonripluss_app.interfaces.Producto_API_Emple;
import com.proyect_chidos.app_sonripluss_app.model.Empleado;
import com.proyect_chidos.app_sonripluss_app.retrofic_funtion.Retrofic_class;
import com.proyect_chidos.app_sonripluss_app.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Empleado>empleados;
    EditText EditUser;
    EditText Edipassword;
    Producto_API_Emple ProductoAPI;
    List <String>EmailAddress =new ArrayList<>();
    List <String> Password =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditUser=findViewById(R.id.EmailAddress);
        Edipassword=findViewById(R.id.Password);
        getAll();
        Button button1=findViewById(R.id.Log_In);
        Button button2=findViewById(R.id.Sign_Up);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int r=0;r<EmailAddress.size();r++){
                    if(EmailAddress.get(r).equals(EditUser.getText().toString())&&Password.get(r).equals(Edipassword.getText().toString())) {


                        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }
                }}});
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Sign_up.class);
                startActivity(intent);
            }});
    }




    private void getAll(){
        ProductoAPI= Retrofic_class.getClient(Constants.BASE_URL).create(Producto_API_Emple.class);
        Call<List<Empleado>> call=ProductoAPI.getAll();
        call.enqueue(new Callback<List<Empleado>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Empleado>> call, Response<List<Empleado>> response) {
                if(!response.isSuccessful()){
                    Toast toast=Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG);
                    toast.show();
                    Log.e("Response err: ",response.message());
                    return;
                }
                empleados=response.body();
                empleados.forEach(p -> {
                    int i = Log.i("Prods: ", p.getEmail());
                    EmailAddress.add(p.getEmail());
                });
                empleados.forEach(p -> {
                    int i = Log.i("Prods: ", p.getPassword());
                    Password.add(p.getPassword());
                });
                Log.i("prueba", String.valueOf(EmailAddress));
                Log.i("prueba", String.valueOf(Password));
            }
            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t) {
                Toast toast=Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG);
                toast.show();
                Log.e("Throw err: ",t.getMessage());
            }
        });
    }
}