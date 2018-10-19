package managedBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
@ManagedBean(name = "databaseBean")
public class DatabaseBean implements Serializable {

	private static final long serialVersionUID = -3201463349097795831L;
	
	private static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("provider");
    private static EntityManager EM = EMF.createEntityManager();
    
    public Point[] gPoints() {
        //return EM.createNamedQuery("Point.getAll").getResultList();
    	Point a = new Point();
    	Point b = new Point();
    	a.setR(2.5);
    	a.setX(1.2);
    	a.setY(3.2);
    	b.setR(0.1);
    	b.setX(1.14);
    	b.setY(0.01478);
    	Point[] apl = {a, b};
    	return apl;
    }
    
    public void addPoint(Point p) {
            EM.getTransaction().begin();
            EM.persist(p);
            EM.getTransaction().commit();
    }
	
}
