package com.dominant;

public class Info {
    private int id, payment,sum;
    private String name, address,time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Info(int id, String name, int payment, int sum, String time, String address) {
        this.id = id;
        this.payment = payment;
        this.sum = sum;
        this.name = name;
        this.address = address;
        this.time = time;
    }
}
