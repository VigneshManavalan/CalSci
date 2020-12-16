package com.dev.calsci;

public class Calculation {
    String title;
    String calculationString;

    public Calculation(String title, String calculationString) {
        this.title = title;
        this.calculationString = calculationString;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCalculationString() {
        return calculationString;
    }

    public void setCalculationString(String calculationString) {
        this.calculationString = calculationString;
    }
}
