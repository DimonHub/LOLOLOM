package bankher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankApp {

    private static final Logger logger = LoggerFactory.getLogger(BankApp.class);

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.openSession();

            int clientId = 1;
            session.beginTransaction();

            Client client = session.get(Client.class, clientId);

            if (client != null) {
                logger.info("Client: {} {}", client.getFirstName(), client.getLastName());
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }

            factory.close();
        }
    }
}
