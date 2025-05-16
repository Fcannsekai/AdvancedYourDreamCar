package com.dreamcar.model;

public class SalesContract extends Contract {
    private boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean finance) {
        super(date, customerName, customerEmail, vehicle);
        this.finance = finance;
    }

    public boolean isFinance() {
        return finance;
    }

    public double getSalesTaxAmount() {
        return getVehicle().getPrice() * 0.05;
    }

    public double getRecordingFee() {
        return 100.00;
    }

    public double getProcessingFee() {
        return getVehicle().getPrice() < 10000 ? 295.00 : 495.00;
    }

    @Override
    public double getTotalPrice() {
        return getVehicle().getPrice() + getSalesTaxAmount() + getRecordingFee() + getProcessingFee();
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) {
            return 0.00;
        }

        double price = getTotalPrice();
        double interestRate;
        int loanMonths;

        if (price >= 10000) {
            interestRate = 0.0425;
            loanMonths = 48;
        } else {
            interestRate = 0.0525;
            loanMonths = 24;
        }

        double monthlyInterest = interestRate / 12;
        return (price * monthlyInterest) / (1 - Math.pow(1 + monthlyInterest, -loanMonths));
    }
}