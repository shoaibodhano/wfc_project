package models;

import java.util.Objects;

public class Customer {
    private String name;
    private String address;
    private String phone; //it will be uniquely identifier
    private int weight;
    private int age;


    public Customer(String name, String address, String phone, int weight, int age) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.weight = weight;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", address='" + address + '\'' + ", phone='" + phone + '\'' + ", weight='" + weight + '\'' + ", age='" + age + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age && name.equals(customer.name) && address.equals(customer.address) && phone.equals(customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phone, age);
    }
}
