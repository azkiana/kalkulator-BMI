package com.titi.bmi;

import android.app.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
    private EditText tinggi;
    private EditText berat;
    private EditText usia;
    private RadioGroup rgGender;
    private RadioButton rbGender;
    int tampilBerat;
    int tampilTinggi;
    int tampilUsia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tinggi = (EditText) findViewById(R.id.input_Tinggi);
        berat = (EditText) findViewById(R.id.input_Berat);
        usia = (EditText) findViewById(R.id.input_Usia);
        rgGender = (RadioGroup) findViewById(R.id.pilihGenger);
        Integer pilihGender = rgGender.getCheckedRadioButtonId();
        rbGender = (RadioButton) findViewById(pilihGender);
    }
        private void displayBerat(int number) {
            EditText input_Berat = (EditText) findViewById(R.id.input_Berat);
            input_Berat.setText(" " + number);
        }
        private void displayTinggi(int number) {
            EditText input_Tinggi = (EditText) findViewById(R.id.input_Tinggi);
            input_Tinggi.setText("" + number);
        }
            private void displayUsia(int number){
            EditText input_Usia = (EditText) findViewById(R.id.input_Usia);
            input_Usia.setText(""+number);
        }

    public void krgBerat(View view){
        tampilBerat = tampilBerat-1;
        displayBerat(tampilBerat);
    }
    public void tmbBerat(View view){
        tampilBerat = tampilBerat+1;
        displayBerat(tampilBerat);
    }
    public void krgTinggi(View view){
        tampilTinggi = tampilTinggi-1;
        displayTinggi(tampilTinggi);
    }
    public void tmbTinggi(View view){
        tampilTinggi = tampilTinggi+1;
        displayTinggi(tampilTinggi);
    }
    public void krgUsia(View view){
        tampilUsia = tampilUsia-1;
        displayUsia(tampilUsia);
    }
    public void tmbUsia(View view){
        tampilUsia = tampilUsia+1;
        displayUsia(tampilUsia);
    }

    public void calculatorBMI (View view){
        String tinggiStr = tinggi.getText().toString();
        String beratStr = berat.getText().toString();

        if (tinggiStr != null && !"".equals(tinggiStr)
                && beratStr !=null && !"".equals(beratStr)){
            float tinggiValue = Float.parseFloat(tinggiStr)/100;
            float beratValue = Float.parseFloat(beratStr);
            float bmi=beratValue/(tinggiValue*tinggiValue);
            displayBMI (bmi);
        }
    }
    private void displayBMI(float bmi){
        String bmiLabel = "";
        String infoUsia = usia.getText().toString();

        bmiLabel = "Jenis Kelamin:" + rbGender.getText() +"\n\n"+"Hasil Perhitungan BMI"+"..."+"Kategori:"+"("+bmiLabel+")"+"\n\n"+"Usia:"+infoUsia;
        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.terlalu_sangat_kurus);
        }else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.sangat_kurus);
        }else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18f) <= 0) {
            bmiLabel = getString(R.string.kurus);
        }else if (Float.compare(bmi, 18f) > 0 && Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
        }else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.gemuk);
        }else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.cukup_gemuk);
        }else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 340) <= 0) {
            bmiLabel = getString(R.string.sangat_gemuk);
        }else{
       bmiLabel = getString(R.string.terlalu_sangat_gemuk);
        }

        AlertDialog.Builder tampilBMI  = new AlertDialog.Builder(this);
        tampilBMI.setTitle("Hasil Perhitungan BMI");
        tampilBMI.setMessage(bmiLabel).setNeutralButton("Tutup", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog=tampilBMI.create();
        alertDialog.show();
    }
}
