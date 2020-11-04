package com.example.mvpexample.mainactivity.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.LinearGradient;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpexample.R;
import com.example.mvpexample.mainactivity.interfaces.OperationPresenter;
import com.example.mvpexample.mainactivity.interfaces.OperationView;
import com.example.mvpexample.mainactivity.presenters.OperationPresenterImpl;

public class MainActivity extends AppCompatActivity implements OperationView {

    private EditText number1;
    private EditText number2;
    private TextView tvResult;
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;


    private OperationPresenter presenter;

    private int num1;
    private int num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();
        presenter = new OperationPresenterImpl(this);
    }

    private void setUp(){
        this.number1 = findViewById(R.id.txtNumber1);
        this.number2 = findViewById(R.id.txtNumber2);
        this.tvResult = findViewById(R.id.txtResult);
        this.button = findViewById(R.id.button);
        this.button2 = findViewById(R.id.button2);
        this.button3 = findViewById(R.id.button3);
        this.button4 = findViewById(R.id.button4);
        this.button.setOnClickListener(evtClick);
        this.button2.setOnClickListener(evtClick);
        this.button3.setOnClickListener(evtClick);
        this.button4.setOnClickListener(evtClick);
    }

    private View.OnClickListener evtClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                switch (v.getId()){
                    case R.id.button:
                        //Sumamos
                        add();
                        break;
                    case R.id.button2:
                        //Restamos
                        substract();
                        break;
                    case R.id.button3:
                        //Multiplicamos
                        multiply();
                        break;
                    case R.id.button4:
                        //Dividimos
                        divide();
                        break;
                    default:
                        break;
                }
            }catch (NumberFormatException e){
                invalidOperation();
                System.out.println(e.getMessage());
            }
        }
    };

    private void add(){
        num1 = Integer.parseInt(this.number1.getText().toString());
        num2 = Integer.parseInt(this.number2.getText().toString());
        presenter.add(num1,num2);
    }

    private void substract(){
        num1 = Integer.parseInt(this.number1.getText().toString());
        num2 = Integer.parseInt(this.number2.getText().toString());
        presenter.substract(num1,num2);
    }

    private void multiply(){
        num1 = Integer.parseInt(this.number1.getText().toString());
        num2 = Integer.parseInt(this.number2.getText().toString());
        presenter.multiply(num1,num2);
    }

    private void divide(){
        num1 = Integer.parseInt(this.number1.getText().toString());
        num2 = Integer.parseInt(this.number2.getText().toString());
        presenter.divide(num1,num2);
    }

    @Override
    public void showResult(String result) {
        tvResult.setText(result);
    }

    @Override
    public void invalidOperation() {
        Toast.makeText(this, "Operación inválida", Toast.LENGTH_LONG).show();
    }
}