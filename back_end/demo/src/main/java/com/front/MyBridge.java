package com.front;

import java.util.ArrayList;

public class MyBridge {
    private double baseYear;
    private double terminalYear;

    public double getBaseYear() {
        return baseYear;
    }

    public void setBaseYear(double baseYear) {
        this.baseYear = baseYear;
    }

    public double getTerminalYear() {
        return terminalYear;
    }

    public void setTerminalYear(double terminalYear) {
        this.terminalYear = terminalYear;
    }

    public ArrayList<Double> getValue(int uptoN){
        ArrayList<Double> values = new ArrayList<>();
        double difference = (terminalYear - baseYear) / uptoN;
        double value = baseYear;
        for (int i = 0; i < uptoN; i++) {
            value += difference;
            values.add(value);
        }

        for (int i = 0; i < uptoN; i++){
            values.add(value);
        }

        return values;
    }
}
