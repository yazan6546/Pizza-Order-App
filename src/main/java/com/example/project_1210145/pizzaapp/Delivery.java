/*
Name : yazan AbuAlown
ID : 1210145
Lecture Section : 3
Lab Section : 4L
 */


package com.example.project_1210145.pizzaapp;

public class Delivery extends PizzaOrder  {
    private double tripRate;
    private int zone;

    public Delivery (String customerName, int pizzaSize, int numberOfToppings,
                     double toppingPrice, double tripRate, int zone) {

        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
        this.tripRate = tripRate;
        this.zone = zone;

    }
    public Delivery() {
        this("yazan", SMALL,3,50, 34, 3);
    }
    @Override
    public double calculateOrderPrice () {
        double old = super.calculateOrderPrice();
        return old + (tripRate/100) * old * zone;
    }

    @Override
    public String toString() {
        String order = super.toString();
        String s = order + String.format("Trip Rate = %.1f\n" +
                        "Zone = %d\n" +
                        "Order Price = %.1f"
                , tripRate, zone, calculateOrderPrice()
        );
        return s;
    }

    public double getTripRate() {
        return tripRate;
    }

    public int getZone() {
        return zone;
    }

    public void setTripRate(double tripRate) {
        this.tripRate = tripRate;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }
}
