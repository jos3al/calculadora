package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private EditText numero1;
    private EditText numero2;
    private TextView numero_resul;
    private Button boton1,boton2,boton3,boton4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero1=findViewById(R.id.edtext1);
        numero2=findViewById(R.id.edtext2);
        numero_resul = findViewById(R.id.resultado);
        boton1=findViewById(R.id.btn1);
        boton2=findViewById(R.id.btn2);
        boton3=findViewById(R.id.btn3);
        boton4=findViewById(R.id.btn4);
    }

    public void sumar(View view){
        if(!numero1.getText().toString().isEmpty() && !numero2.getText().toString().isEmpty() ){
        double numresul= Double.parseDouble(numero1.getText().toString())+Double.parseDouble(numero2.getText().toString());
        if(numresul==(int)numresul){
            numero_resul.setText("Resultado: "+ (int)numresul ) ;
            registrar(boton1.getText().toString(),numero1.getText().toString(),numero2.getText().toString(),String.valueOf((int)numresul));
        }else{
        numero_resul.setText("Resultado: "+ numresul ) ;
            registrar(boton1.getText().toString(),numero1.getText().toString(),numero2.getText().toString(),String.valueOf(numresul));
        }
        InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(),0);

    }
    else{
            mensaje();
        }
    }
    public void resta(View view){
        if(!numero1.getText().toString().isEmpty() && !numero2.getText().toString().isEmpty() ){
        double numresul= Double.parseDouble(numero1.getText().toString())-Double.parseDouble(numero2.getText().toString());
        if(numresul==(int)numresul){
            numero_resul.setText("Resultado: "+ (int)numresul ) ;
            registrar(boton2.getText().toString(),numero1.getText().toString(),numero2.getText().toString(),String.valueOf((int)numresul));
        }else{
            numero_resul.setText("Resultado: "+ numresul ) ;
            registrar(boton1.getText().toString(),numero1.getText().toString(),numero2.getText().toString(),String.valueOf(numresul));
        }
        InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }else {
           mensaje();
        }

    }

    public void multi(View view){
        if(!numero1.getText().toString().isEmpty() && !numero2.getText().toString().isEmpty()){
        double numresul= Double.parseDouble(numero1.getText().toString())*Double.parseDouble(numero2.getText().toString());
        if(numresul==(int)numresul){
            numero_resul.setText("Resultado: "+ (int)numresul ) ;
            registrar(boton3.getText().toString(),numero1.getText().toString(),numero2.getText().toString(),String.valueOf((int)numresul));
        }else{
            numero_resul.setText("Resultado: "+ numresul ) ;
            registrar(boton3.getText().toString(),numero1.getText().toString(),numero2.getText().toString(),String.valueOf(numresul));
        }
        InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
        else{
            mensaje();
        }

    }
    public void div(View view){
        if(!numero1.getText().toString().isEmpty() && !numero2.getText().toString().isEmpty()){
        double numresul= Double.parseDouble(numero1.getText().toString())/Double.parseDouble(numero2.getText().toString());
        if(numresul==(int)numresul){
            numero_resul.setText("Resultado: "+ (int)numresul ) ;
            registrar(boton4.getText().toString(),numero1.getText().toString(),numero2.getText().toString(),String.valueOf((int)numresul));
        }else{
            numero_resul.setText("Resultado: "+ numresul ) ;
            registrar(boton4.getText().toString(),numero1.getText().toString(),numero2.getText().toString(),String.valueOf(numresul));
        }
        InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
     else{
         mensaje();
        }
    }

    public void mensaje(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        alerta dialogo = new alerta();
        dialogo.show(fragmentManager, "tagAlerta");

    }

    public void segundo(View view){
        Intent siguiente =new Intent(this, Resultados.class);
         startActivity(siguiente);
    }
    public void registrar(String boton, String num, String num2, String resultados){
        sqlite conn=new sqlite(this,"db_resultados",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(utilidades.CAMPO_RESULTADO,num+boton+num2+"="+resultados);
        long idresultalte=db.insert(utilidades.CAMPO_TABLA,utilidades.CAMPO_ID,values);
        Toast.makeText(getApplicationContext(),"resultado registrado", Toast.LENGTH_SHORT).show();
    }
}