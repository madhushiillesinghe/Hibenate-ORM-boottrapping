package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
// database eke table define

@Entity(name="customer")

@Table(name = "customer")

public class Customer {
    //@Id annotation define the id is primary key in the customer table
    //@ column annotation represent the column name of db table
    @Id
    @Column (name="customerId")
    private  int id;
    @Column (name="customerName")
    private String name;
    @Column (name="customerAddress")
    private  String address;
    @Column (name="customerSalary")
    private double salary;

    public Customer(){}

    public Customer(int id, String name, String address, double salary) {
        this.id=id;
        this.name=name;
        this.address=address;
        this.salary=salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
