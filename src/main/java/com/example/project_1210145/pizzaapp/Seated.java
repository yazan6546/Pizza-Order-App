/*
Name : yazan AbuAlown
ID : 1210145
Lecture Section : 3
Lab Section : 4L
 */


package com.example.project_1210145.pizzaapp;

public class Seated extends PizzaOrder {
    private double serviceCharge;
    private int numberOfPeople;

    @Override
    public String toString() {
        String order = super.toString();
        String s = order + String.format("Service Price = %.1f\n" +
                        "Number Of People = %d" +
                        "Order Price = %.1f",
                serviceCharge, numberOfPeople, calculateOrderPrice()
        );
        return s;
    }
    public Seated (String customerName, int pizzaSize, int numberOfToppings,
                   double toppingPrice, double serviceCharge, int numberOfPeople) {

        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
        this.serviceCharge = serviceCharge;
        this.numberOfPeople = numberOfPeople;
    }
    public double calculateOrderPrice () {
        double old = super.calculateOrderPrice();
        return old + serviceCharge * numberOfPeople;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
