package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.lang.Math;

public class Main {
    /**
     * Iterate through each line of input.
     */

    enum Denomination {
        FIFTY(50.00f),
        TWENTY(20.00f),
        TEN(10.00f),
        FIVE(5.00f),
        TWO(2.00f),
        ONE(1.00f),
        FIFTY_PENCE(0.50f),
        TWENTY_PENCE(0.20f),
        TEN_PENCE(0.10f),
        FIVE_PENCE(0.05f),
        ONE_PENCE(0.01f);

        private final float value;
        private final String description;

        Denomination(float value) {
            this.value = value;
            this.description = this.name().replace("_", " ");
        }

        public float getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.description;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

        try {
            double purchasePrice = Double.parseDouble(in.readLine());
            double cash = Double.parseDouble(in.readLine());
            Main.calculateChange(purchasePrice, cash);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void calculateChange(double purchasePrice, double cash) {
        // Access your code here. Feel free to create other classes as required
        StringBuilder cashBack = new StringBuilder();

        if (purchasePrice == cash){
            System.out.println("Zero");
        } else if (cash > purchasePrice) {
            double change = cash - purchasePrice;
            double changeAsInt = change * 100;
            for (Denomination d : Denomination.values()) {
                while (changeAsInt >= (d.getValue() * 100 )){
                    changeAsInt -= (d.getValue() * 100);
                    switch (d) {
                        case FIFTY:
                            cashBack.append("Fifty Pounds");
                            break;
                        case TWENTY:
                            cashBack.append("Twenty Pounds");
                            break;
                        case TEN:
                            cashBack.append("Ten Pounds");
                            break;
                        case FIVE:
                            cashBack.append("Five Pounds");
                            break;
                        case TWO:
                            cashBack.append("Two Pounds");
                            break;
                        case ONE:
                            cashBack.append("One Pound");
                            break;
                        case FIFTY_PENCE:
                            cashBack.append("Fifty Pence");
                            break;
                        case TWENTY_PENCE:
                            cashBack.append("Twenty Pence");
                            break;
                        case TEN_PENCE:
                            cashBack.append("Ten Pence");
                            break;
                        case FIVE_PENCE:
                            cashBack.append("Five Pence");
                            break;
                        case ONE_PENCE:
                            cashBack.append("One Pence");
                            break;
                    }
                    if (changeAsInt != 0) {
                        cashBack.append(", ");
                    }
                }
            }
            System.out.println(cashBack);
        } else{
            System.out.println("ERROR");
        }
    }
}