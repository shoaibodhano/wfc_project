package models;

public class Customer {
    public final String name;
    public final String address;
    public final String phone; //it will be uniquely identifier
    public final int weight;
    public final int age;

    public Customer(String name, String address, String phone, int weight, int age) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.weight = weight;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", address='" + address + '\'' + ", phone='" + phone + '\'' + ", weight='" + weight + '\'' + ", age='" + age + '\'';
    }
}
