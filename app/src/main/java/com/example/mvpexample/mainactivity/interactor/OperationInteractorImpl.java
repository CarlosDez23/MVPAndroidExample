package com.example.mvpexample.mainactivity.interactor;

import com.example.mvpexample.mainactivity.interfaces.OperationInteractor;
import com.example.mvpexample.mainactivity.interfaces.OperationPresenter;

/**
 * Esta es la clase modelo o interactor, utilizamos
 * un interactors siguiendo arquitectura clean
 */
public class OperationInteractorImpl implements OperationInteractor {

    private OperationPresenter presenter;

    public OperationInteractorImpl(OperationPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void add(int num1, int num2) {
        presenter.showResult(Integer.toString(num1 + num2));
    }

    @Override
    public void substract(int num1, int num2) {
        presenter.showResult(Integer.toString(num1 - num2));
    }

    @Override
    public void multiply(int num1, int num2) {
        presenter.showResult(Integer.toString(num1 * num2));
    }

    @Override
    public void divide(int num1, int num2) {
        if(num2 == 0){
            presenter.invalidOperation();
        }else{
            presenter.showResult(Integer.toString(num1 / num2));
        }
    }
}
