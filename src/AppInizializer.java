
import embedded.MobileNo;
import embedded.NameIdintifire;
import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppInizializer {

    //private static Connection transaction;

    public static void main(String[] args) throws SQLException {
        //1.Save
        //serilizable define the  table primary key value
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = getCustomer();

        session.save(customer);
        transaction.commit();

       session.close();

        //2.Get
     /*   Session getSession = SessionFactoryConfig.getInstance().getSession();
        Customer exsistingCustomer =
        getSession.get(Customer.class,5);
        System.out.println("exsisting customer : "+ exsistingCustomer);
        getSession.close();

        //3.update(modified)
        Session updateSession =  SessionFactoryConfig
                .getInstance()
                .getSession();

        Transaction updateTransaction = updateSession.beginTransaction();

        Customer exsistingCus = updateSession.get(Customer.class,5);
        exsistingCus.setAddress("Mathara");
        updateSession.update(exsistingCus);
        updateTransaction.commit();
        updateSession.close();*/
        //delete Customer
        /*Session deleteSession=SessionFactoryConfig.getInstance().getSession();
        Transaction deleteTransaction=deleteSession.beginTransaction();

        Customer existingCustomer=deleteSession.get(Customer.class,25);
        deleteSession.delete(existingCustomer);
        deleteTransaction.commit();
        deleteSession.close();*/
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setId(8);
        customer.setName(getIdentifier());
        List<MobileNo> mobileNumbers = getMobileNumbers();
        customer.setMobileNoList(mobileNumbers);
        customer.setAddress("Galle");
        customer.setSalary(20000);

        return customer;
    }

    private static List<MobileNo> getMobileNumbers() {
        MobileNo homeNo = new MobileNo();
        homeNo.setType("Home");
        homeNo.setMobileNo("9012345675");

        MobileNo mobileNumber = new MobileNo();
        mobileNumber.setType("MOBILE");
        mobileNumber.setMobileNo("0771234567");

        List<MobileNo> mobileNumbers = new ArrayList<>();
        mobileNumbers.add(homeNo);
        mobileNumbers.add(mobileNumber);
        return mobileNumbers;
    }

    private static NameIdintifire getIdentifier() {
        NameIdintifire nameIdentifier = new NameIdintifire();
        nameIdentifier.setFirstName("Saman");
        nameIdentifier.setMiddleName("De");
        nameIdentifier.setLastName("Silva");
        return nameIdentifier;
    }
}