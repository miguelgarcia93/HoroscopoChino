package mx.unam.dgtic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etApellido,etDia,etMes,etAnio;
    Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etDia = findViewById(R.id.etDia);
        etMes = findViewById(R.id.etMes);
        etAnio = findViewById(R.id.etAnio);

        btnCalcular = findViewById(R.id.btnClacular);

        String r = getString(R.string.toastNombre);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validaText(etNombre, getString(R.string.toastNombre)) && validaText(etApellido,getString(R.string.toastApellido ))  && validaFecha() ){

                    //////// Calcular fecha actual
                    Calendar fechaActual = Calendar.getInstance();
                    int anioActual = fechaActual.get(Calendar.YEAR);
                    int mesActual = fechaActual.get(Calendar.MONTH) + 1;
                    int diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);

                    /////// Calcular edad
                    int anioUsuario = Integer.valueOf(etAnio.getText().toString());
                    int mesUsuario = Integer.valueOf(etMes.getText().toString());
                    int diaUsuario = Integer.valueOf(etDia.getText().toString());

                    int edad = anioActual-anioUsuario;
                    if(mesActual<=mesUsuario) {
                        if (diaActual < diaUsuario)
                            edad -= 1;
                    }

                    ////// Signo chino

                    int ajuste = anioUsuario-1900;
                    int residuo = ajuste%12;
                    String signo = "";

                    switch(residuo) {
                        case 0: signo="Rata";
                            break;
                        case 1: signo="Buey";
                            break;
                        case 2: signo="Tigre";
                            break;
                        case 3: signo="Conejo";
                            break;
                        case 4: signo="Dragon";
                            break;
                        case 5: signo="Serpiente";
                            break;
                        case 6: signo="Caballo";
                            break;
                        case 7: signo="Cabra";
                            break;
                        case 8: signo="Mono";
                            break;
                        case 9: signo="Gallo";
                            break;
                        case 10: signo="Perro";
                            break;
                        case 11: signo="Cerdo";
                            break;
                    }
                    
                    /////// Enviar parametros
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    Bundle bundle = new Bundle();

                    bundle.putString("NOMBRE", etNombre.getText().toString());
                    bundle.putString("APELLIDO", etApellido.getText().toString());
                    bundle.putInt("EDAD", edad);
                    bundle.putString("SIGNO", signo);

                    intent.putExtras(bundle);
                    startActivity(intent);


                }
            }
        });
    }

    private boolean validaText(EditText text, String v){
        if(text.length()==0){
            Toast.makeText(MainActivity.this,getString(R.string.toastValidaNombre)+v,Toast.LENGTH_LONG).show();
            text.setError(getString(R.string.errorRequerido));
            return false;
        }
        return true;
    }

    private boolean validaFecha(){

        int dia, mes, anio;
        short dias_mes[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


        ///////  Valida Mes
        if(etMes.length()!=0){
            mes = Integer.valueOf(etMes.getText().toString());
            if( mes==0 || mes>12) {
                Toast.makeText(MainActivity.this, getString(R.string.toastValidaMes), Toast.LENGTH_LONG).show();
                return false;
            }
        }else{
            etMes.setError(getString(R.string.errorRequerido));
            Toast.makeText(MainActivity.this, getString(R.string.toastIngresaMes), Toast.LENGTH_LONG).show();
            return false;
        }

        //// Valida Dia
        if (etDia.length()!=0){
            dia = Integer.valueOf(etDia.getText().toString());
            if( dia==0 || dia>31) {
                Toast.makeText(MainActivity.this, getString(R.string.toastValidaDia), Toast.LENGTH_LONG).show();
                return false;
            }
        }else{
            etDia.setError(getString(R.string.errorRequerido));
            Toast.makeText(MainActivity.this, getString(R.string.toastIngresaDia), Toast.LENGTH_LONG).show();
            return false;
        }


        ////// Valida año
        if(etAnio.length()!=0){
            anio = Integer.valueOf(etAnio.getText().toString());
        }else{
            etAnio.setError(getString(R.string.errorRequerido));
            Toast.makeText(MainActivity.this, getString(R.string.toastIngresaAnio), Toast.LENGTH_LONG).show();
            return false;
        }

        if ( (mes!=2) || (!bisiesto(anio)) )
            return (dia<=dias_mes[mes-1]);
        else
            return (dia<=dias_mes[1]+1);
    }


    private boolean bisiesto(int anio)
    {
        return (anio%4==0) && ( (anio%100!=0) || (anio%400==0) );
    }
}
