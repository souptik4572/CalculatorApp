package com.example.basiccalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private final AlphaAnimation buttonClick = new AlphaAnimation(10F, 10.5F);
    String firstNumber = "";
    String secondNumber = "";
    String totalExpression = "";
    String sampleExpression = "";
    boolean addOperator = false;
    boolean subtractOperator = false;
    boolean multiplyOperator = false;
    boolean divideOperator = false;
    boolean squareRootOperator = false;
    boolean equals = false;

    private boolean isOperatorEnabled() {
        return addOperator || subtractOperator || multiplyOperator || divideOperator || squareRootOperator;
    }

    private void addNumber(String character) {
        equals = false;
        if (isOperatorEnabled()) {
            secondNumber = secondNumber + character;
            totalExpression = sampleExpression + secondNumber;
        } else if (equals) {
            firstNumber = "";
            firstNumber = firstNumber + character;
            totalExpression = firstNumber;
            equals = false;
        } else {
            firstNumber = firstNumber + character;
            totalExpression = firstNumber;
        }
        if (firstNumber.length() != 0 && secondNumber.length() == 0) {
            displayanswer(firstNumber);
        } else if (firstNumber.length() == 0 && secondNumber.length() != 0)
            calculate();
        else if (firstNumber.length() != 0 && secondNumber.length() != 0) {
            calculate();
        }
        displayEquation(totalExpression);
    }

    private void calculate() {
        float answering = 0;
        if (addOperator) {
            answering = Float.parseFloat(firstNumber) + Float.parseFloat(secondNumber);
        }
        if (subtractOperator) {
            answering = Float.parseFloat(firstNumber) - Float.parseFloat(secondNumber);
        }
        if (multiplyOperator) {
            answering = Float.parseFloat(firstNumber) * Float.parseFloat(secondNumber);
        }
        if (divideOperator) {
            if (Float.parseFloat(secondNumber) != 0) {
                answering = Float.parseFloat(firstNumber) / Float.parseFloat(secondNumber);
            } else {
                Toast.makeText(this, "Can't divide by Zero", Toast.LENGTH_LONG).show();
            }
        }
        if (squareRootOperator) {
            if (firstNumber.length() == 0 && secondNumber.length() != 0) {
                answering = (float) Math.sqrt(Double.parseDouble(secondNumber));
            } else if (firstNumber.length() != 0 && secondNumber.length() != 0) {
                answering = (float) (Double.parseDouble(firstNumber) * Math.sqrt(Double.parseDouble(secondNumber)));
            }
        }
        if (answering == Math.floor(answering)) {
            displayanswer(String.valueOf((int) answering));
        } else {
            displayanswer(String.valueOf(answering));
        }
    }

    private void performBackspaceOperation() {
        String withoutLastCharacter;
        if (totalExpression.length() == 1) {
            totalExpression = "0";
            sampleExpression = "";
            firstNumber = "";
            secondNumber = "";
        } else if (secondNumber.length() != 0) {
            withoutLastCharacter = secondNumber.substring(0, secondNumber.length() - 1);
            secondNumber = withoutLastCharacter;
            totalExpression = sampleExpression + secondNumber;
        } else if (addOperator || subtractOperator || multiplyOperator || divideOperator || squareRootOperator) {
            withoutLastCharacter = totalExpression.substring(0, totalExpression.length() - 1);
            totalExpression = withoutLastCharacter;
            addOperator = subtractOperator = multiplyOperator = divideOperator = squareRootOperator = false;
        } else {
            withoutLastCharacter = firstNumber.substring(0, firstNumber.length() - 1);
            firstNumber = withoutLastCharacter;
            totalExpression = firstNumber;
        }
        displayEquation(totalExpression);
        if (secondNumber.length() != 0)
            calculate();
        else
            displayanswer(firstNumber);
    }

    public void ac(View view) {
        view.startAnimation(buttonClick);
        firstNumber = "";
        secondNumber = "";
        totalExpression = "0";
        equals = false;
        addOperator = subtractOperator = divideOperator = multiplyOperator = squareRootOperator = false;
        displayEquation(totalExpression);
        displayanswer("");
    }

    public void seven(View view) {
        view.startAnimation(buttonClick);
        addNumber("7");
    }

    public void eight(View view) {
        view.startAnimation(buttonClick);
        addNumber("8");
    }

    public void nine(View view) {
        view.startAnimation(buttonClick);
        addNumber("9");
    }

    public void four(View view) {
        view.startAnimation(buttonClick);
        addNumber("4");
    }

    public void five(View view) {
        view.startAnimation(buttonClick);
        addNumber("5");
    }

    public void six(View view) {
        view.startAnimation(buttonClick);
        addNumber("6");
    }

    public void one(View view) {
        view.startAnimation(buttonClick);
        addNumber("1");
    }

    public void two(View view) {
        view.startAnimation(buttonClick);
        addNumber("2");
    }

    public void three(View view) {
        view.startAnimation(buttonClick);
        addNumber("3");
    }

    public void zero(View view) {
        view.startAnimation(buttonClick);
        addNumber("0");
    }

    public void point(View view) {
        view.startAnimation(buttonClick);
        addNumber(".");
    }

    public void backspace(View view) {
        view.startAnimation(buttonClick);
        performBackspaceOperation();
    }

    public void add(View view) {
        view.startAnimation(buttonClick);
        performOperatorOperation("+");
    }

    public void subtract(View view) {
        view.startAnimation(buttonClick);
        performOperatorOperation("-");
    }

    public void multiply(View view) {
        view.startAnimation(buttonClick);
        performOperatorOperation("*");
    }

    public void division(View view) {
        view.startAnimation(buttonClick);
        performOperatorOperation("/");
    }

    private void generateAndDisplayExpression(String operator) {
        totalExpression += operator;
        sampleExpression = totalExpression;
        displayEquation(totalExpression);
        switch (operator) {
            case "+":
                addOperator = true;
                break;
            case "-":
                subtractOperator = true;
                break;
            case "*":
                multiplyOperator = true;
                break;
            case "/":
                divideOperator = true;
                break;
            default:
                Toast.makeText(this, "Wrong Operator has been used", Toast.LENGTH_SHORT).show();
        }
    }

    private void performOperatorOperation(String operator) {
        equals = false;
        displayanswer(firstNumber);
        if (isOperatorEnabled()) {
            Toast.makeText(this, "Wrong Expression", Toast.LENGTH_SHORT).show();
            return;
        }
        if (firstNumber.length() == 0) {
            Toast.makeText(this, "Wrong Expression", Toast.LENGTH_SHORT).show();
            return;
        }
        generateAndDisplayExpression(operator);
    }

    public void equalsTo(View view) {
        view.startAnimation(buttonClick);
        equals = true;
        if (!squareRootOperator && (firstNumber.length() == 0 || secondNumber.length() == 0)) {
//            Toast.makeText(this, "Input is wrong", Toast.LENGTH_SHORT).show();
            return;
        }
        if (addOperator || subtractOperator || multiplyOperator) {
            float answering = 0;
            if (addOperator) {
                answering = Float.parseFloat(firstNumber) + Float.parseFloat(secondNumber);
            }
            if (subtractOperator) {
                answering = Float.parseFloat(firstNumber) - Float.parseFloat(secondNumber);
            }
            if (multiplyOperator) {
                answering = Float.parseFloat(firstNumber) * Float.parseFloat(secondNumber);
            }
            if (answering == Math.floor(answering)) {
                displayanswer(String.valueOf((int) answering));
                firstNumber = String.valueOf((int) answering);
            } else {
                displayanswer(String.valueOf(answering));
                firstNumber = String.valueOf(answering);
            }
            //display(String.valueOf(answering));
            addOperator = subtractOperator = multiplyOperator = false;
            //firstNumber = String.valueOf(answering);
        } else if (squareRootOperator) {
            double answering = 0;
            if (firstNumber.length() == 0 && secondNumber.length() != 0) {
                answering = Double.parseDouble(secondNumber);
                answering = Math.sqrt(answering);
            } else if (secondNumber.length() != 0 && firstNumber.length() != 0) {
                answering = Double.parseDouble(secondNumber);
                answering = Math.sqrt(answering);
                answering = answering * Double.parseDouble(firstNumber);
            }
            if (answering == Math.floor(answering)) {
                displayanswer(String.valueOf((int) answering));
                firstNumber = String.valueOf((int) answering);
            } else {
                displayanswer(String.valueOf((float) answering));
                firstNumber = String.valueOf((float) answering);
            }
            squareRootOperator = false;
        } else {
            float answer = 0;
            if (Float.parseFloat(secondNumber) != 0) {
                answer = Float.parseFloat(firstNumber) / Float.parseFloat(secondNumber);
            } else {
                Toast.makeText(this, "Can't Divide by zero", Toast.LENGTH_SHORT).show();
            }
            if (answer == Math.floor(answer)) {
                displayanswer(String.valueOf((int) answer));
                firstNumber = String.valueOf((int) answer);
            } else {
                displayanswer(String.valueOf(answer));
                firstNumber = String.valueOf(answer);
            }
            divideOperator = false;
        }
        secondNumber = "";
        totalExpression = firstNumber;
    }

    public void squareroot(View view) {
        view.startAnimation(buttonClick);
        if (firstNumber.length() == 0)
            displayanswer("=");
        else {
            equals = false;
            displayanswer(firstNumber);
        }
        if (isOperatorEnabled()) {
            Toast.makeText(this, "Wrong Expression", Toast.LENGTH_SHORT).show();
            return;
        } else if (firstNumber.length() == 0) {
            totalExpression = "√";
        } else {
            totalExpression = totalExpression + "√";
        }
        sampleExpression = totalExpression;
        squareRootOperator = true;
        displayEquation(totalExpression);
    }

    private void displayEquation(String number) {
        TextView textView = findViewById(R.id.textcalc);
        textView.setText(number);
    }

    private void displayanswer(String number) {
        TextView textView = findViewById(R.id.textanswer);
        if (equals) {
            textView.setTextSize(50);
            textView.setTextColor(Color.parseColor("#FFFFFF"));
            textView.setText("= " + number);
        } else if (firstNumber.length() == 0 && secondNumber.length() == 0) {
            textView.setTextSize(30);
            textView.setTextColor(Color.parseColor("#E0E0E0"));
            textView.setText(number);
        } else {
            textView.setTextSize(30);
            textView.setTextColor(Color.parseColor("#E0E0E0"));
            textView.setText("= " + number);
        }
    }
}