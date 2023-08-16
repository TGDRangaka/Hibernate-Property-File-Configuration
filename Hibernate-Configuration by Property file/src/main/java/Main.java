import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfig;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("S02", "Dilshan", "Panadura");

        Session session = FactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(student);

        transaction.commit();

        session.close();
    }
}
