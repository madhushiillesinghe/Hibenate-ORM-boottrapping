package entity;

import embedded.MobileNo;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import embedded.NameIdintifire;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


//define the annotated class
@Entity(name="customer")

@Table(name = "customer")

public class Customer {
    //@Id annotation define the id is primary key in the customer table
    //@ column annotation represent the column name of db table
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerId")
    private int id;
    @Column (name="customerName")
    private NameIdintifire name;


    @Column (name="customerAddress")
    private  String address;

 /*   @Column(name = "mobile_ no")
    private String mobileno;
*/
    @Transient
    @Column (name="customerSalary")
    private double salary;
    @Column(name = "CustomerAge")
    private int age;
// define the has a relationship ---->Customer HAS A list of mobile no
    @ElementCollection
    @CollectionTable(name = "Customer_Mobile_Number",joinColumns = @JoinColumn(name ="customerId" ))
    private List<MobileNo> mobileNoList=new ArrayList<>();

    public Customer(){}

    public Customer(int id, NameIdintifire name, String address, double salary) {
        this.id=id;
        this.name=name;
        this.address=address;
        this.salary=salary;
        this.age=age;
    }
    @CreationTimestamp
    private Timestamp createdDateTime;

    @UpdateTimestamp
    private  Timestamp updatedTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NameIdintifire getName() {
        return name;
    }

    public void setName(NameIdintifire name) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<MobileNo> getMobileNoList() {
        return mobileNoList;
    }

    public void setMobileNoList(List<MobileNo> mobileNoList) {
        this.mobileNoList = mobileNoList;
    }


}
