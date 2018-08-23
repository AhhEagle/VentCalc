package com.example.mypc.ventcalc;
        import android.os.Build;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.SeekBar;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText  editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText10,editText14;
    TextView tv_answer;
    Button button;
    double input, input1,input2,input3,input4,input5,input6,input7,input8,input9,b,air_density, answer2, a,  Perimeter, Area;
    SeekBar seekBar;
    Spinner spinnerAnimal, spinnerAverage, spinnerBuilding;
    String animalAverage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =  findViewById(R.id.button);
        tv_answer = (EditText) findViewById(R.id.tv_answer);
        editText1 =  findViewById(R.id.editText1);
        editText2 =  findViewById(R.id.editText2);
        editText3 =  findViewById(R.id.editText3);
        editText4 =  findViewById(R.id.editText4);
        editText5 =  findViewById(R.id.editText5);
        editText6 =  findViewById(R.id.editText6);
        editText7 =  findViewById(R.id.editText7);
        editText8 =  findViewById(R.id.editText8);
        editText8 =  findViewById(R.id.editText8);
        editText10 = findViewById(R.id.editText10);
        editText14 = findViewById(R.id.editText14);
        spinnerAnimal =  findViewById(R.id.spinnerAnimal);
        spinnerAverage = findViewById(R.id.spinnerAverage);
        spinnerBuilding = findViewById(R.id.spinnerBuilding);
        spinnerAnimal.setOnItemSelectedListener(this);

        //  views
        seekBar= findViewById(R.id.seekBar);
        // perform seek bar change listener event used for getting the progress value
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                editText8.setText (progress +"");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View. OnClickListener()  {
            @Override
            public void  onClick(View v) {
                    if(editText1 .getText().toString().isEmpty()& editText2 .getText().toString().isEmpty()& editText3 .getText().toString().isEmpty()& editText4 .getText().toString().isEmpty()&
                editText5 .getText().toString().isEmpty()& editText6 .getText().toString().isEmpty()& editText7 .getText().toString().isEmpty()& editText10 .getText().toString().isEmpty()&
                            editText14 .getText().toString().isEmpty()){
                        Toast.makeText(MainActivity.this, "You must fill all", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        input = Double.parseDouble(editText1.getText().toString());
                        input1 = Double.parseDouble(editText2.getText().toString());
                        input2 = Double.parseDouble(editText3.getText().toString());
                        input3 = Double.parseDouble(editText4.getText().toString());
                        input4 = Double.parseDouble(editText5.getText().toString());
                        input5 = Double.parseDouble(editText6.getText().toString());
                        input6 = Double.parseDouble(editText7.getText().toString());
                        input7 = Double.parseDouble(editText8.getText().toString());
                        input8 = Double.parseDouble(editText10.getText().toString());
                        input9 = Double.parseDouble(editText14.getText().toString());

                        a= 101325-(input7*11.67);
                        b= 611*Math.pow(10,(7.5*input4)/(input4+237.3));
                        air_density= (0.0034848/(input4+273.15))*(a-0.0037960*b*input6);
                        Perimeter= 2*(input+input3);
                        Area=2*((input*input2)+(input2*input3)+(input*input3));

                        tv_answer.setText(answer2 + "m3/min");
                    }
                }

            });}

        @Override
        public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
                                   long arg3) {
            parent.getItemAtPosition(pos);
            if (pos == 0) {
                ArrayAdapter<CharSequence> adapter = ArrayAdapter
                        .createFromResource(this, R.array.swine_average,
                                android.R.layout.simple_spinner_item);
                spinnerAverage.setAdapter(adapter);
               // spinnerAverage.getSelectedItem().equals("")

            } else if (pos == 1) {

                ArrayAdapter<CharSequence> adapter = ArrayAdapter
                        .createFromResource(this, R.array.layingHen_average,
                                android.R.layout.simple_spinner_item);
                spinnerAverage.setAdapter(adapter);
            } else if (pos == 2) {

                ArrayAdapter<CharSequence> adapter = ArrayAdapter
                        .createFromResource(this, R.array.broilers_average,
                                android.R.layout.simple_spinner_item);
                spinnerAverage.setAdapter(adapter);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    }
