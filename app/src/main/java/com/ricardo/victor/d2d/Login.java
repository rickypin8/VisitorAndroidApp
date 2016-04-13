package com.ricardo.victor.d2d;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//pojo class
import com.ricardo.victor.data.GuardService;
import com.ricardo.victor.data.pojo.Usuarios;
import com.ricardo.victor.data.pojo.UsuariosService;

//retrofit imports
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    EditText username;
    EditText password;
    Button btnLogin;
    String user;
    String pass;
    private ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText) findViewById(R.id.editUser);
        password=(EditText) findViewById(R.id.editPass);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pd=new ProgressDialog(Login.this);
                pd.setMessage("Iniciando sesion..");
                pd.setCancelable(false);
                pd.show();
                if (!username.getText().toString().equals("") && !password.getText().toString().equals("")) {

                    try {
                        pass = password.getText().toString();
                        user = username.getText().toString();

                    } catch(NumberFormatException e){
                        pd.dismiss();
                        Toast.makeText(Login.this, "Usuario y/o pin invalido",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Retrofit retrofit=new Retrofit.Builder()
                            .baseUrl("http://172.16.11.250:8080")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    GuardService service=retrofit.create(GuardService.class);
                    Call<UsuariosService> call=service.logIn(user,pass);
                    call.enqueue(new Callback<UsuariosService>() {
                        @Override
                        public void onResponse(Call<UsuariosService> call, Response<UsuariosService> response) {
                            try{
                                if(response.body().getStatus()==0){
                                    Intent i =new Intent(Login.this,Main.class);
                                    Usuarios usr=response.body().getUsuario();
                                    i.putExtra("usr", usr);
                                    pd.dismiss();
                                    startActivity(i);
                                    finish();
                                }else {
                                    pd.dismiss();
                                    Toast.makeText(Login.this, "Usuario y/o contraseña invalido", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }catch (Exception e){
                                pd.dismiss();
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<UsuariosService> call, Throwable t) {
                            pd.dismiss();
                            Toast.makeText(Login.this, "Sin conexión al servidor", Toast.LENGTH_LONG).show();
                        }
                    });
                }else {
                    pd.dismiss();
                    if(username.getText().toString().equals(""))
                        Toast.makeText(Login.this, "Favor de ingresar su usuario", Toast.LENGTH_LONG).show();
                        else if (password.getText().toString().equals(""))
                            Toast.makeText(Login.this, "Favor de ingresar su pin", Toast.LENGTH_LONG).show();
                        return;

                }
            }
        });
    }
}

