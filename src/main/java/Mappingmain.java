import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mappingmain {

	public static void main(String[] args) {
		
		Configuration c = new Configuration();


		SessionFactory factory = c.configure("hbm.cfg.xml").buildSessionFactory();

		Address address = new Address(1, "sector-3", "sahibabad", "Uttarprdesh", "201005");
		//Address address1 = new Address(3, "sector-4", "sahibabad", "Uttarprdesh", "201006");


		Employee emp = new Employee(2, "vipin", "ramola", address);
		//Employee emp1 = new Employee(3, "Jaspal", "ramola", address);

		Session session = factory.openSession();

		Transaction tx;
		try {
			tx = session.beginTransaction();
			session.save(address);
			session.save(emp);
			tx.commit();
			session.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  }
	}


