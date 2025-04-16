/*
Name : yazan AbuAlown
ID : 1210145
Lecture Section : 3
Lab Section : 4L
 */


package com.example.project_1210145.pizzaapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
public class PizzaOrder implements Comparable<PizzaOrder> {

    private String customerName;
    private Date dateOrdered;
    private int pizzaSize;
    public final static int SMALL = 1;
    public final static int MEDIUM = 2;
    public final static int LARGE = 3;
    private int numeberOfToppings;
    private double toppingPrice;

    public PizzaOrder (String customerName, int pizzaSize, int numeberOfToppings, double toppingPrice) {
        dateOrdered = new Date();
        this.customerName = customerName;
        this.pizzaSize = pizzaSize;
        this.numeberOfToppings = numeberOfToppings;
        this.toppingPrice = toppingPrice;

    }
    public PizzaOrder () {
        this("yazan", SMALL, 3, 34);
    }
    public double calculateOrderPrice() {
        return numeberOfToppings * toppingPrice * pizzaSize;
    }
    public String printOrderInfo () {
        return String.format("%-13s%.1f\n", customerName, calculateOrderPrice());
    }
    @Override
    public String toString() {

        String size;
        if (pizzaSize == 1) {
            size = "small";
        }
        else if (pizzaSize == 2) {
            size = "medium";
        }
        else {
            size = "large";
        }

        String s = String.format("Customer Name = %s\n" +
                        "Date Ordered = %s\n" +
                        "Pizza Size = %s\n" +
                        "Number of Toppings = %d\n" +
                        "Topping Price = %.1f\n",
                customerName, dateOrdered, size, numeberOfToppings, toppingPrice);

        return s;

    }

    @Override
    public int compareTo(PizzaOrder o) {
        if (calculateOrderPrice() > o.calculateOrderPrice()) {
            return 1;
        }
        else if (calculateOrderPrice() < o.calculateOrderPrice()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public int getPizzaSize() {
        return pizzaSize;
    }

    public int getNumeberOfToppings() {
        return numeberOfToppings;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setNumeberOfToppings(int numeberOfToppings) {
        this.numeberOfToppings = numeberOfToppings;
    }

    public void setPizzaSize(int pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public Date getDateOrdered() {
        return new Date(dateOrdered.getTime());
    }

    public static void sortOrders (ArrayList<PizzaOrder> orders) { //method to sort in ascending order based on price

        Collections.sort(orders);
    }
}
