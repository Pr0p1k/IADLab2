package managedBeans;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;	
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;


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
    
    private List<String> logs = new ArrayList<String>();

    public void onIdle(AjaxBehaviorEvent ae) {
        logs.add("idle: " + new java.util.Date());
        
    }

    public void onActive(AjaxBehaviorEvent ae) {
        logs.add("active: " + new java.util.Date());

    }

    public List<String> getLogs() {
        return logs;
    }
	
}
