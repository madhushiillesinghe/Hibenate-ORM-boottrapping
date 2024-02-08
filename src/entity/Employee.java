package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="employee")

@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employeeId")
    private  int id;

    @Column (name="employeeName")
    private  String name;

    public Employee(){}
    public Employee(int id,String name){
        this.id=id;
        this.name=name;
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
}
