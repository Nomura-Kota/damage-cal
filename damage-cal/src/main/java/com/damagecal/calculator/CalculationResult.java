package com.damagecal.calculator;

public class CalculationResult {

    private int result;

    public CalculationResult() {
        // デフォルトコンストラクタが必要
    }

    public CalculationResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
