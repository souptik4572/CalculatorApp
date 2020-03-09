package android.example.calculatorapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*if (id == R.id.nav_home) {
            Intent numbersIntent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(numbersIntent);

        } else */if (id == R.id.nav_gallery) {
            Intent numbersIntent = new Intent(MainActivity.this, convertActivity.class);
            startActivity(numbersIntent);
        } /*else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        }*/else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private AlphaAnimation buttonClick = new AlphaAnimation(10F, 10.5F);
    String firstNumber="";
    String secondNumber="";
    String totalExpression="";
    String sampleExpression="";
    boolean plusSign=false,minusSign=false,multiplySign=false,divisionSign=false,squarerootSign=false;
    int count=0;
    boolean equals=false;
    public void addNumber(String character){
        equals=false;
        if(plusSign||minusSign||multiplySign||divisionSign||squarerootSign) {
            secondNumber = secondNumber + character;
            totalExpression = sampleExpression + secondNumber;
        }
        else if(equals){
            firstNumber="";
            firstNumber=firstNumber+character;
            totalExpression=firstNumber;
            equals=false;
        }
        else {
            firstNumber = firstNumber + character;
            totalExpression = firstNumber;
        }
        if(firstNumber.length()!=0&&secondNumber.length()==0){
            displayanswer(firstNumber);
        }
        else if(firstNumber.length()==0&&secondNumber.length()!=0)
            calculate();
        else if(firstNumber.length()!=0&&secondNumber.length()!=0){
            calculate();
        }
        displayEquation(totalExpression);
    }
    public void calculate(){
        float answering = 0;
        if (plusSign) {
            answering = Float.parseFloat(firstNumber) + Float.parseFloat(secondNumber);
        }
        if (minusSign) {
            answering = Float.parseFloat(firstNumber) - Float.parseFloat(secondNumber);
        }
        if (multiplySign) {
            answering = Float.parseFloat(firstNumber) * Float.parseFloat(secondNumber);
        }
        else if(divisionSign){
            if(Float.parseFloat(secondNumber) != 0) {
                answering = Float.parseFloat(firstNumber) / Float.parseFloat(secondNumber);
            }
            else {
                Toast.makeText(this, "Can't divide by Zero", Toast.LENGTH_LONG).show();
            }
        }
        else if(squarerootSign){
            if(firstNumber.length()==0&&secondNumber.length()!=0){
                answering=(float)Math.sqrt(Double.parseDouble(secondNumber));
            }
            else if(firstNumber.length()!=0&&secondNumber.length()!=0){
                answering=(float)(Double.parseDouble(firstNumber)*Math.sqrt(Double.parseDouble(secondNumber)));
            }
        }
        if(answering==Math.floor(answering)) {
            displayanswer(String.valueOf((int)answering));
        }
        else {
            displayanswer(String.valueOf(answering));
        }
    }
    public void ac(View view){
        view.startAnimation(buttonClick);
        firstNumber="";
        secondNumber="";
        totalExpression="0";
        equals=false;
        plusSign=minusSign=divisionSign=multiplySign=squarerootSign=false;
        displayEquation(totalExpression);
        displayanswer("");
    }
    public void seven(View view){

        view.startAnimation(buttonClick);
        addNumber("7");
    }
    public void eight(View view){
        view.startAnimation(buttonClick);
        addNumber("8");
    }
    public void nine(View view){
        view.startAnimation(buttonClick);
        addNumber("9");
    }
    public void four(View view){
        view.startAnimation(buttonClick);
        addNumber("4");
    }
    public void five(View view){
        view.startAnimation(buttonClick);
        addNumber("5");
    }
    public void six(View view){
        view.startAnimation(buttonClick);
        addNumber("6");
    }
    public void one(View view){
        view.startAnimation(buttonClick);
        addNumber("1");
    }
    public void two(View view){
        view.startAnimation(buttonClick);
        addNumber("2");
    }
    public void three(View view){
        view.startAnimation(buttonClick);
        addNumber("3");
    }
    public void zero(View view){
        view.startAnimation(buttonClick);
        addNumber("0");
    }
    public void point(View view){
        view.startAnimation(buttonClick);
        addNumber(".");
    }
    public void backspace(View view){
        view.startAnimation(buttonClick);
        String withoutLastCharacter;
        if(totalExpression.length()==1){
            totalExpression="0";
            sampleExpression="";
            firstNumber="";
            secondNumber="";
        }
        else if(secondNumber.length()!=0){
            withoutLastCharacter = secondNumber.substring(0, secondNumber.length() - 1);
            secondNumber=withoutLastCharacter;
            totalExpression=sampleExpression+secondNumber;
        }
        else if(plusSign||minusSign||multiplySign||divisionSign||squarerootSign){
            withoutLastCharacter=totalExpression.substring(0, totalExpression.length() - 1);
            totalExpression=withoutLastCharacter;
            plusSign=minusSign=multiplySign=divisionSign=squarerootSign=false;
        }
        else {
            withoutLastCharacter= firstNumber.substring(0, firstNumber.length() - 1);
            firstNumber=withoutLastCharacter;
            totalExpression=firstNumber;
        }
        displayEquation(totalExpression);
        if(secondNumber.length()!=0)
            calculate();
        else
            displayanswer(firstNumber);
    }
    public void add(View view){
        view.startAnimation(buttonClick);
        equals=false;
        displayanswer(firstNumber);
        if(plusSign||minusSign||multiplySign||divisionSign||squarerootSign){
            Toast.makeText(this,"Wrong Expression",Toast.LENGTH_SHORT).show();
        }
        else if(firstNumber.length()==0){
            Toast.makeText(this,"Wrong Expression",Toast.LENGTH_SHORT).show();
        }
        else {
            totalExpression = totalExpression + "+";
            sampleExpression=totalExpression;
            plusSign=true;
            displayEquation(totalExpression);
        }
    }
    public void subtract(View view){
        view.startAnimation(buttonClick);
        equals=false;
        displayanswer(firstNumber);
        if(plusSign||minusSign||multiplySign||divisionSign||squarerootSign){
            Toast.makeText(this,"Wrong Expression",Toast.LENGTH_SHORT).show();
        }
        else if(firstNumber.length()==0){
            Toast.makeText(this,"Wrong Expression",Toast.LENGTH_SHORT).show();
        }
        else {
            totalExpression = totalExpression + "-";
            sampleExpression=totalExpression;
            minusSign=true;
            displayEquation(totalExpression);
        }
    }
    public void multiply(View view){
        view.startAnimation(buttonClick);
        equals=false;
        displayanswer(firstNumber);
        if(plusSign||minusSign||multiplySign||divisionSign||squarerootSign){
            Toast.makeText(this,"Wrong Expression",Toast.LENGTH_SHORT).show();
        }
        else if(firstNumber.length()==0){
            Toast.makeText(this,"Wrong Expression",Toast.LENGTH_SHORT).show();
        }
        else {
            totalExpression = totalExpression + "X";
            sampleExpression=totalExpression;
            multiplySign=true;
            displayEquation(totalExpression);
        }
    }
    public void division(View view){
        view.startAnimation(buttonClick);
        equals=false;
        displayanswer(firstNumber);
        if(plusSign||minusSign||multiplySign||divisionSign||squarerootSign){
            Toast.makeText(this,"Wrong Expression",Toast.LENGTH_SHORT).show();
        }
        else if(firstNumber.length()==0){
            Toast.makeText(this,"Wrong Expression",Toast.LENGTH_SHORT).show();
        }
        else {
            totalExpression = totalExpression + "/";
            sampleExpression=totalExpression;
            divisionSign=true;
            displayEquation(totalExpression);
        }
    }
    public void equalsTo(View view){
        view.startAnimation(buttonClick);
        equals=true;
        if(!squarerootSign&&(firstNumber.length()==0||secondNumber.length()==0)){
            //Toast.makeText(this, "Input is wrong", Toast.LENGTH_SHORT).show();
            return;
        }
        if(plusSign||minusSign||multiplySign) {
            float answering = 0;
            if (plusSign) {
                answering = Float.parseFloat(firstNumber) + Float.parseFloat(secondNumber);
            }
            if (minusSign) {
                answering = Float.parseFloat(firstNumber) - Float.parseFloat(secondNumber);
            }
            if (multiplySign) {
                answering = Float.parseFloat(firstNumber) * Float.parseFloat(secondNumber);
            }
            if(answering==Math.floor(answering)) {
                displayanswer(String.valueOf((int)answering));
                firstNumber = String.valueOf((int)answering);
            }
            else {
                displayanswer(String.valueOf(answering));
                firstNumber = String.valueOf(answering);
            }
            //display(String.valueOf(answering));
            plusSign = minusSign = multiplySign = false;
            //firstNumber = String.valueOf(answering);
        }
        else if(squarerootSign){
            double answering=0;
            if(firstNumber.length()==0&&secondNumber.length()!=0){
                answering=Double.parseDouble(secondNumber);
                answering=Math.sqrt(answering);
            }
            else if(secondNumber.length()!=0&&firstNumber.length()!=0){
                answering=Double.parseDouble(secondNumber);
                answering=Math.sqrt(answering);
                answering=answering*Double.parseDouble(firstNumber);
            }
            if(answering==Math.floor(answering)) {
                displayanswer(String.valueOf((int)answering));
                firstNumber = String.valueOf((int)answering);
            }
            else {
                displayanswer(String.valueOf((float)answering));
                firstNumber = String.valueOf((float)answering);
            }
            squarerootSign=false;
        }
        else {
            float answer=0;
            if(Float.parseFloat(secondNumber) != 0) {
                answer = Float.parseFloat(firstNumber) / Float.parseFloat(secondNumber);
            }
            else {
                Toast.makeText(this, "Can't Divide by zero", Toast.LENGTH_SHORT).show();
            }
            if(answer==Math.floor(answer)) {
                displayanswer(String.valueOf((int)answer));
                firstNumber = String.valueOf((int)answer);
            }
            else {
                displayanswer(String.valueOf(answer));
                firstNumber = String.valueOf(answer);
            }
            divisionSign = false;
        }
        secondNumber ="";
        totalExpression = firstNumber;
    }
    public void squareroot(View view){
        view.startAnimation(buttonClick);
        if(firstNumber.length()==0)
            displayanswer("=");
        else {
            equals = false;
            displayanswer(firstNumber);
        }
        if(plusSign||minusSign||multiplySign||divisionSign||squarerootSign){
            Toast.makeText(this,"Wrong Expression",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(firstNumber.length()==0){
            totalExpression="√";
        }
        else {
            totalExpression = totalExpression + "√";
        }
        sampleExpression=totalExpression;
        squarerootSign=true;
        displayEquation(totalExpression);
    }
    public void displayEquation(String number){
        TextView textView=(TextView) findViewById(R.id.textcalc);
        textView.setText(number);
    }
    public void displayanswer(String number){
        TextView textView=(TextView) findViewById(R.id.textanswer);
        if(equals){
            textView.setTextSize(50);
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setText("= " + number);
            return;
        }
        else if(firstNumber.length()==0&&secondNumber.length()==0){
            textView.setTextSize(30);
            textView.setTextColor(Color.parseColor("#E0E0E0"));
            textView.setText(number);
            return;
        }
        else {
            textView.setTextSize(30);
            textView.setTextColor(Color.parseColor("#E0E0E0"));
            textView.setText("= " + number);
            return;
        }
    }
}
