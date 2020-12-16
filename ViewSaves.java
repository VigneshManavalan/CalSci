package com.dev.calsci;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ViewSaves extends AppCompatActivity {
   ArrayList<Calculation> calculations = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_saves);
        Intent intent = getIntent();
        Bundle calculation = intent.getExtras();
        calculations = getCalculations();
        String title = calculation.getString("title");
        if(title == null && calculations.isEmpty() ){
            CalculationAdapter adapter = new CalculationAdapter(this,R.layout.calc_item,calculations);
            ListView lv = findViewById(R.id.lvSaved);
            lv.setAdapter(adapter);
            saveCalculations();
        }
        else{

        if(title!=null ) title = title.toUpperCase();
        String calculationString = calculation.getString("calculationString");


        Calculation calc = new Calculation(title,calculationString);
        if(title!=null) calculations.add(calc);
        CalculationAdapter adapter = new CalculationAdapter(this,R.layout.calc_item,calculations);
        ListView lv = findViewById(R.id.lvSaved);
        lv.setAdapter(adapter);
        saveCalculations();

    }}
    private void saveCalculations() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = getSharedPreferences("calsciData",MODE_PRIVATE);
        String json = gson.toJson(this.calculations);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("savedCalculations",json);
        editor.commit();

    }
    private ArrayList<Calculation> getCalculations() {

        SharedPreferences sharedPreferences = getSharedPreferences("calsciData",MODE_PRIVATE);
        String json = sharedPreferences.getString("savedCalculations","");
        if(json.isEmpty()){
            return new ArrayList<Calculation>();
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Calculation>>(){}.getType();
        ArrayList<Calculation> calc = gson.fromJson(json,type);
        if(calc==null){
            return new ArrayList<Calculation>();
        }
        return calc;
    }
    
    
    @Override
    protected void onStop() {
        saveCalculations();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        saveCalculations();
        super.onDestroy();
    }
}
