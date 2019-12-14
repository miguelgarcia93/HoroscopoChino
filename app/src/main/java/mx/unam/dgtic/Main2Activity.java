package mx.unam.dgtic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private static final String LOGTAG = "DEPURACION";

    TextView tvSaludo, tvEdad, tvAnimal;
    ImageView imgAnimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        tvSaludo = findViewById(R.id.tvSaludo);
        tvEdad = findViewById(R.id.tvEdad);
        tvAnimal = findViewById(R.id.tvAnimal);
        imgAnimal = findViewById(R.id.imgAnimal);

        ////////////////   Recuperanco información
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();

        String nombre = bundle.getString("NOMBRE", "Sin info");
        String apellido = bundle.getString("APELLIDO", "Sin info");
        int edad = bundle.getInt("EDAD");
        String signo = bundle.getString("SIGNO","Sin info");


        Log.d(LOGTAG,"El nombre que llegó al Activity 2 es: "+ nombre);
        Log.d(LOGTAG,"El apellido que llegó al Activity 2 es: "+ apellido);
        Log.d(LOGTAG,"La edad que llegó al Activity 2 es: "+ edad);
        Log.d(LOGTAG,"El signo que llegó al Activity 2 es: "+ signo);
        ///////////////////////

        switch(signo) {
            case "Rata":
                tvAnimal.setText(getString(R.string.text_Rata));
                imgAnimal.setImageResource(R.drawable.rata);
                break;
            case "Buey":
                tvAnimal.setText(getString(R.string.text_Buey));
                imgAnimal.setImageResource(R.drawable.buey);
                break;
            case "Tigre":
                tvAnimal.setText(getString(R.string.text_Tigre));
                imgAnimal.setImageResource(R.drawable.tigre);
                break;
            case "Conejo":
                tvAnimal.setText(getString(R.string.text_Conejo));
                imgAnimal.setImageResource(R.drawable.conejo);
                break;
            case "Dragon":
                tvAnimal.setText(getString(R.string.text_Dragon));
                imgAnimal.setImageResource(R.drawable.dragon);
                break;
            case "Serpiente":
                tvAnimal.setText(getString(R.string.text_Serpiente));
                imgAnimal.setImageResource(R.drawable.serpiente);
                break;
            case "Caballo":
                tvAnimal.setText(getString(R.string.text_Caballo));
                imgAnimal.setImageResource(R.drawable.caballo);
                break;
            case "Cabra":
                tvAnimal.setText(getString(R.string.text_Cabra));
                imgAnimal.setImageResource(R.drawable.cabra);
                break;
            case "Mono":
                tvAnimal.setText(getString(R.string.text_Mono));
                imgAnimal.setImageResource(R.drawable.mono);
                break;
            case "Gallo":
                tvAnimal.setText(getString(R.string.text_Gallo));
                imgAnimal.setImageResource(R.drawable.gallo);
                break;
            case "Perro":
                tvAnimal.setText(getString(R.string.text_Perro));
                imgAnimal.setImageResource(R.drawable.perro);
                break;
            case "Cerdo":
                tvAnimal.setText(getString(R.string.text_Cerdo));
                imgAnimal.setImageResource(R.drawable.cerdo);
                break;
        }

        tvSaludo.setText(getString(R.string.text_Saludo)+nombre+" "+apellido);
        tvEdad.setText(getString(R.string.text_Edad)+edad+getString(R.string.text_Anios));

    }
}
