package managedBeans;

import java.util.List;
import java.io.Serializable;	
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


public class DatabaseBean implements Serializable {

	private static final long serialVersionUID = -3201463349097795831L;
    
    public List<Point> getPoints() {
    	EntityManagerFactory EMF = Persistence.createEntityManagerFactory("provider");
    	EntityManager EM = EMF.createEntityManager();
    	FacesContext fCtx = FacesContext.getCurrentInstance();
    	HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
    	String sessionId = session.getId();
    	List<Point> lst = EM.createNamedQuery("pointlist").setParameter("session", sessionId).getResultList();
    	return lst;
    }
    
    public void addPoint(Point p) {
    	EntityManagerFactory EMF = Persistence.createEntityManagerFactory("provider");
    	EntityManager EM = EMF.createEntityManager();
            EM.getTransaction().begin();
            EM.persist(p);
            EM.getTransaction().commit();
    }
	
}
