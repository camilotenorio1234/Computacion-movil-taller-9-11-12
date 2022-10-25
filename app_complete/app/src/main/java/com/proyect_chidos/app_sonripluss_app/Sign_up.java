package com.proyect_chidos.app_sonripluss_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.proyect_chidos.app_sonripluss_app.dto.Empleado_New;
import com.proyect_chidos.app_sonripluss_app.interfaces.Producto_API_Emple;
import com.proyect_chidos.app_sonripluss_app.model.Empleado;
import com.proyect_chidos.app_sonripluss_app.retrofic_funtion.Retrofic_class;
import com.proyect_chidos.app_sonripluss_app.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Sign_up extends AppCompatActivity {
    EditText EditName;
    EditText EditLastName;
    EditText EditC_C;
    EditText EditPhone_number;
    EditText Edit_EmailAddress;
    EditText EditPassword;
    EditText Edit_Confirm_Password;
    Producto_API_Emple productoAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button button1=findViewById(R.id.Sign_Up);
        EditName=findViewById(R.id.Name);
        EditLastName=findViewById(R.id.Lastname);
        EditC_C=findViewById(R.id.C_C);
        EditPhone_number=findViewById(R.id.Phone_number);
        Edit_EmailAddress=findViewById(R.id.EmailAddress);
        EditPassword=findViewById(R.id.Password);
        Edit_Confirm_Password=findViewById(R.id.Confirm_Password);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Empleado_New Emple_new =new Empleado_New(EditName.getText().toString()
                        ,EditLastName.getText().toString()
                        ,Long.valueOf(EditC_C.getText().toString())
                        ,Long.valueOf(EditPhone_number.getText().toString())
                        ,Edit_EmailAddress.getText().toString()
                        ,EditPassword.getText().toString());
                Create_empleado(Emple_new);

            }
        });
    }

    private void Create_empleado(Empleado_New dto){
        productoAPI= Retrofic_class.getClient(Constants.BASE_URL).create(Producto_API_Emple.class);
        Call<Empleado> call=productoAPI.createEmployee(dto);
        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if(!response.isSuccessful()){
                    Toast toast=Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG);
                    toast.show();
                    Log.e("Response err: ",response.message());
                    return;
                }
                Empleado empleado=response.body();
                Toast toast=Toast.makeText(getApplicationContext(),empleado.getNombre()+" created!!",Toast.LENGTH_LONG);
                toast.show();
                callMain();
            }
            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Toast toast=Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG);
                toast.show();
                Log.e("Throw err: ",t.getMessage());
            }
        });

    }
    private void callMain() {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}