package managedBeans;

import java.util.List;
import java.io.Serializable;	
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "databaseBean", eager = false)
@RequestScoped

public class DatabaseBean implements Serializable {

	private static final long serialVersionUID = -3201463349097795831L;
    
    public List<Point> getPoints() {
    	EntityManagerFactory EMF = Persistence.createEntityManagerFactory("provider");
    	EntityManager EM = EMF.createEntityManager();
    	List<Point> lst = EM.createNamedQuery("pointlist").getResultList();
    	EM.close();
    	EMF.close();
    	return lst;
    }
    
    public void addPoint(Point p) {
    	EntityManagerFactory EMF = Persistence.createEntityManagerFactory("provider");
    	EntityManager EM = EMF.createEntityManager();
            EM.getTransaction().begin();
            EM.persist(p);
            EM.getTransaction().commit();
            EMF.close();
        	EM.close();
    }
	
}
