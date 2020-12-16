package com.dev.calsci;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Calculator extends AppCompatActivity implements SaveCalculationDialog.SaveCalculationDialogListener {
    public static final String TO_SAVE="TO_SAVE";
    private static int count=1;
    private static String previousResult = "";
    private  static int openParanCount=0;
    private static String evalExpression;
   private static String resultString;
   private MediaPlayer mediaPlayer;
   private static boolean powerIsOpen = false;
   private String exponent="";
   Button btnViewSaved;
   Button btnOpenParan;
   Button btnThree;
   Button btnTwo;
   Button btnFour;
   Button btnFive;
   Button btnSix;
   Button btnOne;
   Button btnSeven;
   Button btnEight;
   Button btnNine;
   Button btnZero;
   Button btnDecimal;
   Button btnEqual;
   Button btnAdd;
   Button btnSubstract;
   Button btnDivide;
   Button btnMultiply;
   Button btnReset;
   Button btnPower;
   Button btnEValue;
   Button btnDelete;
   Button btnCloseParan;
   Button btnSave;
   TextView tvDisplay;

   private static boolean equalPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        resultString = "";
        evalExpression = "";
        mediaPlayer = MediaPlayer.create(this,R.raw.buttonclickfinal);

        setUpUI();
        setUpEventListener();
    }
    private void getResult(){


        Object[] params = new Object[] { "javaScriptParam" };
        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);
        try{
            Scriptable scope = rhino.initStandardObjects();
            System.out.println(evalExpression);
            // Note the forth argument is 1, which means the JavaScript source has
            // been compressed to only one line using something like YUI
            if(evalExpression.length()==0){
                return;
            }
            previousResult="";
            previousResult += resultString;
            btnSave.setVisibility(View.VISIBLE);
            String s = rhino.evaluateString(scope,evalExpression,"JavaScript",1,null).toString();
            previousResult+=" :\n"+s+"\n";
            tvDisplay.setText(s);
            // Get the functionName defined in JavaScriptCode
            //bject obj = scope.get(functionNameInJavaScriptCode, scope);
           System.out.println(s);
            if(tvDisplay.getText().toString().indexOf('.')!=-1){
                double resultValue =  Double.parseDouble(tvDisplay.getText().toString());
                resultString=""+resultValue;
                evalExpression=""+resultValue;
                updateDisplay();
            }
            else{
                int resultValue = Integer.parseInt(tvDisplay.getText().toString());
                resultString = ""+resultValue;
                evalExpression=""+resultValue;
                updateDisplay();
            }
        }
        catch(Exception e){
            Toast.makeText(this, "INVALID MATHEMATICAL OPERATION", Toast.LENGTH_SHORT).show();
        };
    }
    private void setUpEventListener() {
            btnViewSaved.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Calculator.this,ViewSaves.class);
                    intent.putExtra(TO_SAVE,"");
                    startActivity(intent);
                }
            });
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDialog();
                }
            });
            btnCloseParan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(openParanCount==0){
                        return;
                    }
                    else{
                        openParanCount--;
                        resultString+=")";
                        evalExpression+=")";
                        updateDisplay();
                    }
                }
            });
            btnReset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resultString = "";
                    evalExpression = "";
                    tvDisplay.setText("");
                }
            });
            btnOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View e) {
                    btnSave.setVisibility(View.INVISIBLE);
                    mediaPlayer.start();
                    if(equalPressed==true){
                        resultString = "";
                        evalExpression = "";
                        equalPressed = false;
                    }

                    resultString += "1";
                    evalExpression+= "1";
                    Calculator.this.updateDisplay();
                }
            });
            btnTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View e) {
                    btnSave.setVisibility(View.INVISIBLE);
                    mediaPlayer.start();
                    if(equalPressed==true){
                        resultString = "";
                        evalExpression = "";
                        equalPressed = false;
                    }
                    resultString += "2";
                    evalExpression +="2";
                    Calculator.this.updateDisplay();
                }
            });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(equalPressed==true){
                    resultString = "";
                    evalExpression = "";
                    equalPressed = false;
                }
                resultString += "3";
                evalExpression +="3";
                Calculator.this.updateDisplay();
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(equalPressed==true){
                    resultString = "";
                    evalExpression = "";
                    equalPressed = false;
                }
                resultString += "4";
                evalExpression +="4";
                Calculator.this.updateDisplay();
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(equalPressed==true){
                    resultString = "";
                    evalExpression = "";
                    equalPressed = false;
                }
                resultString += "5";
                evalExpression +="5";
                Calculator.this.updateDisplay();
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(equalPressed==true){
                    resultString = "";
                    evalExpression = "";
                    equalPressed = false;
                }
                resultString += "6";
                evalExpression +="6";
                Calculator.this.updateDisplay();
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(equalPressed==true){
                    resultString = "";
                    evalExpression = "";
                    equalPressed = false;
                }
                resultString += "7";
                evalExpression +="7";
                Calculator.this.updateDisplay();
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                mediaPlayer.start();
                if(equalPressed==true){
                    resultString = "";
                    evalExpression = "";
                    equalPressed = false;
                }
                resultString += "8";
                evalExpression +="8";
                Calculator.this.updateDisplay();
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(equalPressed==true){
                    resultString = "";
                    evalExpression = "";
                    equalPressed = false;
                }
                resultString += "9";
                evalExpression +="9";
                Calculator.this.updateDisplay();
            }
        });
        btnEValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                if(equalPressed==true){
                    resultString = "";
                    evalExpression = "";
                    equalPressed = false;
                }
                evalExpression +="Math.exp(1)";
                resultString += "e";

                Calculator.this.updateDisplay();
            }

        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(equalPressed==true){
                    resultString = "";
                    equalPressed = false;
                }
                resultString += "0";
                evalExpression +="0";
                Calculator.this.updateDisplay();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View e) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(powerIsOpen){
                    evalExpression+=")";
                    powerIsOpen=false;
                }
                if(equalPressed){
                    resultString += " + ";
                    evalExpression +=" + ";
                    equalPressed =false;
                    updateDisplay();
                    return;
                }
                if(resultString.length()==0){
                    return;
                }
                if (resultString.charAt(resultString.length() - 1) == ' ') {
                    Toast.makeText(Calculator.this, "THAT WAS AN INVALID MATHEMATICAL MOVE", Toast.LENGTH_SHORT).show();
                } else {
                    resultString += " + ";
                    evalExpression += " + ";
                    Calculator.this.updateDisplay();
                }
            }
        });
        btnPower.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View e) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(resultString.length()==0){
                    return;
                }
                if(powerIsOpen){
                    evalExpression+=")";
                    powerIsOpen=false;
                }
                if(equalPressed){
                    powerIsOpen = true;
                    String base = "";
                    String current = "";
                    int end = evalExpression.length()-1;
                    int start;
                    int i = 1;
                    while(true){
                        if(current.equals(" ") || i> evalExpression.length()){
                            start = evalExpression.length()-i+1;
                            break;
                        }
                        else{
                            current="";
                            current= ""+ evalExpression.charAt(evalExpression.length()-i);
                            base=""+current+base;
                            i++;
                        }
                    }
                    if(start!=0) {
                        evalExpression = evalExpression.substring(0, start);
                    }
                    else{
                        evalExpression="";
                    }
                    evalExpression+="Math.pow("+base+",";
                    resultString += " ^ ";

                    equalPressed =false;
                    updateDisplay();
                    return;
                }

                if (resultString.charAt(resultString.length() - 1) == ' ') {
                    Toast.makeText(Calculator.this, "THAT WAS AN INVALID MATHEMATICAL MOVE", Toast.LENGTH_SHORT).show();
                }
                else if(resultString.charAt(resultString.length()-1)==')'){
                    powerIsOpen = true;
                    String base = "";
                    String current = "";
                    int start;
                    int i = 1;
                    while(true){
                        if(current.equals("(") || i> evalExpression.length()){
                            start = evalExpression.length()+1-i;
                            break;
                        }
                        else{
                            current="";
                            current= ""+ evalExpression.charAt(evalExpression.length()-i);
                            base=""+current+base;
                            i++;
                        }
                    }
                    if(start!=0) {
                        evalExpression = evalExpression.substring(0, start);
                    }
                    else{
                        evalExpression="";
                    }
                    evalExpression+="Math.pow("+base+",";
                    resultString += " ^ ";

                    equalPressed =false;
                    updateDisplay();

                }
                else {
                    powerIsOpen = true;
                    String base = "";
                    String current = "";

                    int start;
                    int i = 1;
                    while(true){
                        if(current.equals(" ") || i> evalExpression.length()){
                            start = evalExpression.length()+1-i;
                            break;
                        }
                        else{
                            current="";
                            current= ""+ evalExpression.charAt(evalExpression.length()-i);
                            base=""+current+base;
                            i++;
                        }
                    }
                    if(start!=0) {
                        evalExpression = evalExpression.substring(0, start);
                    }
                    else{
                        evalExpression="";
                    }
                    evalExpression+="Math.pow("+base+",";
                    resultString += " ^ ";

                    equalPressed =false;
                    updateDisplay();
                }
            }
        });
        btnSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(powerIsOpen){
                    evalExpression+=")";
                    powerIsOpen=false;
                }
                if(equalPressed){

                    resultString += " - ";
                    evalExpression += " - ";
                    equalPressed =false;
                    updateDisplay();
                    return;
                }
                resultString += " - ";
                evalExpression += " - ";
                Calculator.this.updateDisplay();


            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(powerIsOpen){
                    evalExpression+=")";
                    powerIsOpen=false;
                }
                if(equalPressed){
                    resultString += " x ";
                    evalExpression += " * ";
                    equalPressed =false;
                    updateDisplay();
                    return;
                }
                if(resultString.length()==0){
                    return;
                }
                if (resultString.charAt(resultString.length() - 1) == ' ') {
                    Toast.makeText(Calculator.this, "THAT WAS AN INVALID MATHEMATICAL MOVE", Toast.LENGTH_SHORT).show();
                } else {
                    resultString += " x ";
                    evalExpression += " * ";
                    Calculator.this.updateDisplay();
                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View e) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(equalPressed){
                    resultString += " / ";
                    evalExpression = resultString;
                    equalPressed =false;
                    updateDisplay();
                    return;
                }
                if(resultString.length()==0){
                    return;
                }
                if (resultString.charAt(resultString.length() - 1) == ' ') {
                    Toast.makeText(Calculator.this, "THAT WAS AN INVALID MATHEMATICAL MOVE", Toast.LENGTH_SHORT).show();
                } else {
                    resultString += " / ";
                    evalExpression += " / ";
                    Calculator.this.updateDisplay();
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                if(powerIsOpen){
                    evalExpression +=")";
                    powerIsOpen =false;
                }
                getResult();
                equalPressed = true;
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(resultString.length()==0){
                    return;
                }
                if (resultString.charAt(resultString.length() - 1) == ' ') {
                    String tempResultString;
                    tempResultString = resultString;
                    resultString = resultString.substring(0,resultString.length()-3);
                    if(tempResultString.charAt(tempResultString.length() - 2) == '^'){
                        System.out.println(evalExpression);
                        String base = evalExpression.substring(evalExpression.lastIndexOf("(")+1,evalExpression.lastIndexOf(","));
                        evalExpression = evalExpression.substring(0,evalExpression.lastIndexOf("M"));
                        evalExpression+=base;
                        System.out.println(evalExpression);
                        powerIsOpen=false;
                        updateDisplay();
                        return;
                    }
                    System.out.println(evalExpression);
                    evalExpression = evalExpression.substring(0,evalExpression.length()-3);
                    updateDisplay();
                }
                else{
                    resultString = resultString.substring(0,resultString.length()-1);
                    evalExpression = evalExpression.substring(0,evalExpression.length()-1);
                    updateDisplay();
                }
            }
        });
        btnOpenParan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSave.setVisibility(View.INVISIBLE);
                resultString+="(";
                evalExpression+="(";
                openParanCount +=1;
                updateDisplay();
            }
        });
        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSave.setVisibility(View.INVISIBLE);
                mediaPlayer.start();
                if(resultString.length()==0){
                    resultString = "0.";
                    evalExpression = "0.";
                    updateDisplay();
                }
                else if(resultString.charAt(resultString.length()-1)==' '){
                    resultString+="0.";
                    evalExpression+="0.";
                    updateDisplay();
                }
                else{
                    resultString+=".";
                    evalExpression+=".";
                    updateDisplay();
                }
            }
        });
    }
    private void openDialog() {
        SaveCalculationDialog saveCalculationDialog = new SaveCalculationDialog();
        saveCalculationDialog.show(getSupportFragmentManager(),"save");
    }
    private void updateDisplay() {
        tvDisplay.setText(resultString);

    }
    private void setUpUI() {
        btnViewSaved = (Button)findViewById(R.id.btnViewSaved);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnOpenParan = (Button)findViewById(R.id.btnOpenParan);
        btnCloseParan = (Button)findViewById(R.id.btnCloseParan);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSubstract = (Button)findViewById(R.id.btnSubtract);
        btnDivide = (Button)findViewById(R.id.btnDivide);
        btnMultiply = (Button)findViewById(R.id.btnMultiply);
        btnOne = (Button)findViewById(R.id.btn1);
        btnTwo = (Button)findViewById(R.id.btn2);
        btnThree = (Button)findViewById(R.id.btn3);
        btnFour = (Button)findViewById(R.id.btn4);
        btnFive = (Button)findViewById(R.id.btn5);
        btnSix = (Button)findViewById(R.id.btn6);
        btnSeven = (Button)findViewById(R.id.btn7);
        btnEight = (Button)findViewById(R.id.btn8);
        btnNine = (Button)findViewById(R.id.btn9);
        btnZero = (Button)findViewById(R.id.btn0);
        btnDecimal = (Button)findViewById(R.id.btnDecimal);
        btnPower = (Button)findViewById(R.id.btnPower);
        btnEValue = (Button)findViewById(R.id.btnE);
        btnEqual = (Button)findViewById(R.id.btnEqual);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnReset = (Button)findViewById(R.id.btnReset);
        tvDisplay = (TextView)findViewById(R.id.tvDisplay);
        tvDisplay.setMovementMethod(new ScrollingMovementMethod());


        //Setting Shadows
        tvDisplay.setShadowLayer(20,2,0, Color.BLACK);
    }
    @Override
    public void saveCalculation(String title) {
        Intent intent = new Intent(this,ViewSaves.class);
        intent.putExtra("title",title);
        intent.putExtra("calculationString",previousResult);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
