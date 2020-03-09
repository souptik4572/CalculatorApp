package android.example.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class convertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        Spinner spinner_from = (Spinner) findViewById(R.id.spinner_from);
        // Create an ArrayAdapter using the string array and a default spinner layout
        Spinner spinner_to = (Spinner) findViewById(R.id.spinner_to);
        ArrayAdapter<CharSequence> adapter_from = ArrayAdapter.createFromResource(this,
                R.array.number_system_from, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_from.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_from.setAdapter(adapter_from);
        ArrayAdapter<CharSequence> adapter_to = ArrayAdapter.createFromResource(this,
                R.array.number_system_to, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_to.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_to.setAdapter(adapter_to);
// Apply the adapter to the spinner
        /*String from = spinner_from.getSelectedItem().toString();
        String to = spinner_to.getSelectedItem().toString();
        if(from.equals("Decimal")){
            TextView a=(TextView) findViewById(R.id.a);
            a.setTextColor(Color.parseColor("FAFAFA"));
            TextView b=(TextView) findViewById(R.id.b);
            b.setTextColor(Color.parseColor("FAFAFA"));
            TextView c=(TextView) findViewById(R.id.c);
            c.setTextColor(Color.parseColor("FAFAFA"));
            TextView d=(TextView) findViewById(R.id.d);
            d.setTextColor(Color.parseColor("FAFAFA"));
            TextView e=(TextView) findViewById(R.id.e);
            e.setTextColor(Color.parseColor("FAFAFA"));
            TextView f=(TextView) findViewById(R.id.f);
            f.setTextColor(Color.parseColor("FAFAFA"));
        }*/
    }
    private AlphaAnimation buttonClick = new AlphaAnimation(10F, 10.5F);
    String number="";
    public void addNumber(String num){
        number=number+num;
        displayEquation(number);
    }
    public void zero(View view){
        view.startAnimation(buttonClick);
        addNumber("0");
    }
    public void one(View view){
        view.startAnimation(buttonClick);
        addNumber("1");
    }
    public int checkNumberSystem(){
        Spinner spinner_from_again = (Spinner) findViewById(R.id.spinner_from);
        String from = spinner_from_again.getSelectedItem().toString();
        String binaryNumber="Binary";
        String octalNumber="Octal";
        String hexadecimalNumber="Hexadecimal";
        if(from.equals(binaryNumber)){
            return 2;
        }
        else if(from.equals(octalNumber)){
            return 8;
        }
        else if(from.equals(hexadecimalNumber)){
            return 16;
        }
        return 10;
    }
    public void two(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==8||checkNumberSystem()==10||checkNumberSystem()==16){
            addNumber("2");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void three(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==8||checkNumberSystem()==10||checkNumberSystem()==16){
            addNumber("3");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void four(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==8||checkNumberSystem()==10||checkNumberSystem()==16){
            addNumber("4");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void five(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==8||checkNumberSystem()==10||checkNumberSystem()==16){
            addNumber("5");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void six(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==8||checkNumberSystem()==10||checkNumberSystem()==16){
            addNumber("6");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void seven(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==8||checkNumberSystem()==10||checkNumberSystem()==16){
            addNumber("7");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void eight(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==10||checkNumberSystem()==16){
            addNumber("8");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void nine(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==10||checkNumberSystem()==16){
            addNumber("9");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void a(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==16){
            addNumber("A");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void b(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==16){
            addNumber("B");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void c(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==16){
            addNumber("C");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void d(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==16){
            addNumber("D");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void e(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==16){
            addNumber("E");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void f(View view){
        view.startAnimation(buttonClick);
        if(checkNumberSystem()==16){
            addNumber("F");
        }
        else{
            Toast.makeText(convertActivity.this,"doesn't support this number",Toast.LENGTH_SHORT).show();
        }
    }
    public void point(View view){
        view.startAnimation(buttonClick);
        addNumber(".");
    }
    public void backspace(View view){
        view.startAnimation(buttonClick);
        if(number.length()==0){
            return;
        }
        String withoutLastCharacter=number.substring(0, number.length() - 1);
        number=withoutLastCharacter;
        displayEquation(number);
    }
    public void refresh(View view){
        number="";
        displayEquation(number);
        StringBuilder place= new StringBuilder();
        place.append("");
        displayAnswer(place);
    }
    public void equals(View view){
        Spinner spinner_to_again = (Spinner) findViewById(R.id.spinner_to);
        String to = spinner_to_again.getSelectedItem().toString();
        Spinner spinner_from_again = (Spinner) findViewById(R.id.spinner_from);
        String from = spinner_from_again.getSelectedItem().toString();
        if(from.equals(to)){
            Toast.makeText(this,"Please set a different output",Toast.LENGTH_SHORT).show();
            return;
        }
        if(number.length()==0){
            Toast.makeText(this,"Input is Empty",Toast.LENGTH_SHORT).show();
            return;
        }
        String decimal="Decimal";
        String binary="Binary";
        String octal="Octal";
        String hexadecimal="Hexadecimal";
        if(from.equals(decimal)) {
            if (to.equals(binary)) {
                displayAnswer(calculate_toDifferentSystem_fromDecimal(2,number));
            }
            if (to.equals(octal)) {
                displayAnswer(calculate_toDifferentSystem_fromDecimal(8,number));
            }
            if (to.equals(hexadecimal)) {
                displayAnswer(calculate_toDifferentSystem_fromDecimal(16,number));
            }
        }
        if(from.equals(binary)){
            if(to.equals(decimal)){
                displayAnswer(print_decimal(2));
            }
            if(to.equals(octal)){
                displayAnswer(print(2,8));
            }
            if(to.equals(hexadecimal)){
                displayAnswer(print(2,16));
            }
        }
        if(from.equals(octal)){
            if(to.equals(decimal)){
                displayAnswer(print_decimal(8));
            }
            if(to.equals(hexadecimal)){
                displayAnswer(print(8,16));
            }
            if(to.equals(binary)){
                displayAnswer(print(8,2));
            }
        }
        if(from.equals(hexadecimal)){
            if(to.equals(decimal)){
                displayAnswer(print_decimal(16));
            }
            if(to.equals(octal)){
                displayAnswer(print(16,8));
            }
            if(to.equals(binary)){
                displayAnswer(print(16,2));
            }
        }
    }
    public StringBuilder print_decimal(int num){
        StringBuilder reverseBinary=new StringBuilder();
        reverseBinary.append(calculate_to_decimal(num));
        return reverseBinary;
    }
    public StringBuilder print(int num1, int num2){
        String number="";
        number=number+calculate_to_decimal(num1);
        StringBuilder someNumber=new StringBuilder();
        someNumber.append(calculate_toDifferentSystem_fromDecimal(num2,number));
        return someNumber;
    }
    public long calculate_to_decimal(int num){
        char[] numbers=number.toCharArray();
        long sum=0;
        int numberLength=number.length();
        int j=0;
        for(int i=numberLength-1;i>=0;i--,j++){
            if(numbers[i]=='A'){
                sum=sum+(10*((int)Math.pow(num,j)));
            }
            else if(numbers[i]=='B'){
                sum=sum+(11*((int)Math.pow(num,j)));
            }
            else if(numbers[i]=='C'){
                sum=sum+(12*((int)Math.pow(num,j)));
            }
            else if(numbers[i]=='D'){
                sum=sum+(13*((int)Math.pow(num,j)));
            }
            else if(numbers[i]=='E'){
                sum=sum+(14*((int)Math.pow(num,j)));
            }
            else if(numbers[i]=='F'){
                sum=sum+(15*((int)Math.pow(num,j)));
            }
            else {
                sum = sum + ((long) numbers[i]-48) * ((int) Math.pow(num, j));
            }
        }
        return sum;
    }
    public StringBuilder calculate_toDifferentSystem_fromDecimal(int system,String number){
        double fraction=Float.parseFloat(number);
        long decimal= (long) fraction;
        int condition=1;
        String answer="";
        if(decimal!=fraction){
            condition=0;
            fraction=fraction-decimal;
            double fract=fraction*system;
            int n=16;
            while(n>0){
                int deci= (int) (fract);
                if(deci<10)
                    answer=answer+String.valueOf(deci);
                else if(deci==10)
                    answer=answer+"A";
                else if(deci==11)
                    answer=answer+"B";
                else if(deci==12)
                    answer=answer+"C";
                else if(deci==13)
                    answer=answer+"D";
                else if(deci==14)
                    answer=answer+"E";
                else if(deci==15)
                    answer=answer+"F";
                if(fract-(int)fract==0)
                    break;
                fract=fract-deci;
                fract=fract*system;
                n--;
            }
        }
        String differentNumber="";
        while (decimal>0){
            if(decimal%system<10)
                differentNumber = differentNumber + String.valueOf(decimal%system);
            if(decimal%system==10)
                differentNumber = differentNumber + "A";
            if(decimal%system==11)
                differentNumber = differentNumber + "B";
            if(decimal%system==12)
                differentNumber = differentNumber + "C";
            if(decimal%system==13)
                differentNumber = differentNumber + "D";
            if(decimal%system==14)
                differentNumber = differentNumber + "E";
            if(decimal%system==15)
                differentNumber = differentNumber + "F";
            decimal=decimal/system;
        }
        StringBuilder reverseBinary=new StringBuilder();
        reverseBinary.append(differentNumber);
        reverseBinary=reverseBinary.reverse();
        if(condition==0) {
            reverseBinary.append(".");
            reverseBinary.append(answer);
        }
        return reverseBinary;
    }
    public void displayAnswer(StringBuilder number){
        TextView textView=(TextView) findViewById(R.id.view_answer);
        if(number.length()==0){
            textView.setTextSize(20);
            number.append("Result/Answer");
        }
        else {
            textView.setTextSize(15);
        }
        textView.setText(number);
    }
    public void displayEquation(String number) {
        TextView textView = (TextView) findViewById(R.id.enter_number);
        if(number.length()==0){
            number="Enter Number";
            textView.setTextSize(20);
        }
        else {
            textView.setTextSize(15);
        }
        textView.setText(number);
    }
}
