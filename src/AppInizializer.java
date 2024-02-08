import config.SessionFactoryConfig;
import entity.Customer;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInizializer {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Customer customer = new Customer();
        customer.setId(135);
        customer.setName("Saman");
        customer.setAddress("Galle");
        customer.setSalary(25000);

        Customer customer1=new Customer();

        customer1.setId(151);
        customer1.setName("Saman");
        customer1.setAddress("Galle");
        customer1.setSalary(25000);

        session.save(customer);
        session.save(customer1);

        Employee employee=new Employee();

        employee.setId(4521);
        employee.setName("madhu");

        session.save(employee);
        transaction.commit();
        session.close();
    }
}