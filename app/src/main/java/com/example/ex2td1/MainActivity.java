package com.example.ex2td1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView t;
    EditText e;
    RadioButton r1, r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);

    }

    public void Calculer(View view) {
        AlertDialog.Builder alerte = new AlertDialog.Builder(MainActivity.this);
        alerte.setTitle("Champ_vide");
        alerte.setMessage("veuillez saisir une valeur de temperature");
        alerte.setPositiveButton("oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alerte.setNegativeButton("non", null );
        alerte.show();

        LinearLayout l1 = (LinearLayout) findViewById(R.id.linear);
        t = findViewById(R.id.textView);
        e = findViewById(R.id.editTextTextPersonName);
//get value fromedittext box and convertinto double
        double a = Double.parseDouble(String.valueOf(e.getText()));
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton3);
//check which radio buttonischecked
        if (r1.isChecked()) {
//change background colour
            l1.setBackgroundColor(Color.YELLOW);
//display conversion
            t.setText(f2c(a) + " degree C");
//cb.setChecked(false);
            r1.setChecked(true);
        } else {
            l1.setBackgroundColor(Color.CYAN);
            t.setText(c2f(a) + " degree F");
//fb.setChecked(false);
            r2.setChecked(true);
        }
    }

    private double c2f(double a) {
        return(a*9)/5+32;
    }

    private double f2c(double a) {
        return(a-32)*5/9;
    }


}