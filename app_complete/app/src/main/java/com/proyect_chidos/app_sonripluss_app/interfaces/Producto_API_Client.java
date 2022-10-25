package com.proyect_chidos.app_sonripluss_app.interfaces;

import com.proyect_chidos.app_sonripluss_app.dto.Client_New;
import com.proyect_chidos.app_sonripluss_app.dto.Empleado_New;
import com.proyect_chidos.app_sonripluss_app.model.Client;
import com.proyect_chidos.app_sonripluss_app.model.Empleado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
public interface Producto_API_Client {
    @GET("/consultar_client/{id}")
    Call<List<Client>>getOne_client(@Path("id")long id);
    @GET("/consultarAll_client")
    Call<List<Client>>getAll_Client();
    @POST("/guardar_client")
    Call<Client> create_Client(@Body Client_New client_New);
}
