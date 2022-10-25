package com.proyect_chidos.app_sonripluss_app.interfaces;
import com.proyect_chidos.app_sonripluss_app.dto.Empleado_New;
import com.proyect_chidos.app_sonripluss_app.model.Empleado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
public interface Producto_API_Emple {
    @GET("/consultar/{id}")
    Call<List<Empleado>>getOne(@Path("id")long id);
    @GET("/consultarAll")
    Call<List<Empleado>>getAll();
    @POST("/guardar")
    Call<Empleado> createEmployee(@Body Empleado_New empleado_new);

}
