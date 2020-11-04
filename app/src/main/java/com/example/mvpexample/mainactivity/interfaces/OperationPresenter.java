package com.example.mvpexample.mainactivity.interfaces;

/**
 * Esta interfaz es el intermediario entre el
 * interactor y la vista
 */
public interface OperationPresenter {
    void showResult(String result);
    void invalidOperation();
    void add(int num1, int num2);
    void substract(int num1, int num2);
    void multiply(int num1, int num2);
    void divide(int num1, int num2);
}
