package com.dreamcar.model;

public class LeaseContract extends Contract {

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
    }

    public double getExpectedEndingValue() {
        return getVehicle().getPrice() * 0.5;
    }

    public double getLeaseFee() {
        return getVehicle().getPrice() * 0.07;
    }

    @Override
    public double getTotalPrice() {
        return getLeaseFee() + getExpectedEndingValue();
    }

    @Override
    public double getMonthlyPayment() {
        double totalPrice = getTotalPrice();
        double leaseRate = 0.04 / 12;
        int leaseMonths = 36;

        return (totalPrice * leaseRate) / (1 - Math.pow(1 + leaseRate, -leaseMonths));
    }
}