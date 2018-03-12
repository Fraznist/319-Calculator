package com.example.emre.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    enum Operation {ADD, SUB, MUL, DIV, NONE};
    Operation op = Operation.NONE;

    boolean isDecimal = false;

    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button num0;
    private Button add;
    private Button sub;
    private Button div;
    private Button mult;
    private Button clear;
    private Button equal;
    private Button back;
    private Button dec;
    private TextView field;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        field = findViewById(R.id.field);
        result = findViewById(R.id.result);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);
        num0 = findViewById(R.id.num0);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        div = findViewById(R.id.div);
        mult = findViewById(R.id.mult);
        clear = findViewById(R.id.clear);
        equal = findViewById(R.id.equal);
        back = findViewById(R.id.back);
        dec = findViewById(R.id.dec);

        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        num0.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        div.setOnClickListener(this);
        mult.setOnClickListener(this);
        clear.setOnClickListener(this);
        equal.setOnClickListener(this);
        back.setOnClickListener(this);
        dec.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.num0)
            field.setText(field.getText() + "0");
        if (view.getId() == R.id.num1)
            field.setText(field.getText() + "1");
        if (view.getId() == R.id.num2)
            field.setText(field.getText() + "2");
        if (view.getId() == R.id.num3)
            field.setText(field.getText() + "3");
        if (view.getId() == R.id.num4)
            field.setText(field.getText() + "4");
        if (view.getId() == R.id.num5)
            field.setText(field.getText() + "5");
        if (view.getId() == R.id.num6)
            field.setText(field.getText() + "6");
        if (view.getId() == R.id.num7)
            field.setText(field.getText() + "7");
        if (view.getId() == R.id.num8)
            field.setText(field.getText() + "8");
        if (view.getId() == R.id.num9)
            field.setText(field.getText() + "9");
        if (view.getId() == R.id.clear) {
            clearField();
            result.setText("");
        }
        if (view.getId() == R.id.back) {
            CharSequence seq = field.getText();
            if (seq.length() > 0) {
                if (seq.charAt(seq.length() - 1) == '.')
                    isDecimal = false;
                field.setText(seq.subSequence(0, seq.length() - 1));
            }
        }
        if (view.getId() == R.id.dec) {
            if (!isDecimal) {
                field.setText(field.getText()+".");
                isDecimal = true;
            }
        }
        if (view.getId() == R.id.add)
            opPressed(Operation.ADD);
        if (view.getId() == R.id.sub)
            opPressed(Operation.SUB);
        if (view.getId() == R.id.mult)
            opPressed(Operation.MUL);
        if (view.getId() == R.id.div)
            opPressed(Operation.DIV);
        if (view.getId() == R.id.equal) {
            if (isFieldEmpty() || isResultEmpty());
            else {
                double x = Double.parseDouble(result.getText().toString());
                double y = Double.parseDouble(field.getText().toString());
                switch (op) {
                    case ADD:
                        x += y;
                        break;
                    case SUB:
                        x -= y;
                        break;
                    case MUL:
                        x *= y;
                        break;
                    case DIV:
                        x /= y;
                        break;
                }
                result.setText(x + "");
                clearField();
                op = Operation.NONE;
            }

        }

    }

    private void opPressed(Operation opie) {
        if (isFieldEmpty())      // No second operand, do nothing
            return;
        if (isResultEmpty()) {   // No first operand
            result.setText(field.getText());
            clearField();
        }
        else {
            double x = Double.parseDouble(result.getText().toString());
            double y = Double.parseDouble(field.getText().toString());
            switch (op) {
                case ADD:
                    x += y;
                    break;
                case SUB:
                    x -= y;
                    break;
                case MUL:
                    x *= y;
                    break;
                case DIV:
                    x /= y;
                    break;
                default:
                    x = y;
                    break;
            }
            result.setText(x + "");
            clearField();
        }
        op = opie;
    }

    private void clearField() {
        field.setText("");
        isDecimal = false;
    }

    private boolean isFieldEmpty() {
        if (field.getText().length() == 0)
            return true;
        else return false;
    }

    private boolean isResultEmpty() {
        if (result.getText().length() == 0)
            return true;
        else return false;
    }
}
