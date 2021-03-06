package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import java.io.Serializable;


public class InputView implements Serializable {
	private static final long serialVersionUID = -4049920593055331825L;
	private double x;
    private double y;
    private double r;
    private double xMin = -3;
    private double xMax = 3;
    private double yMin = -5;
    private double yMax = 5;
    private double rMin = 2;
    private double rMax = 5;
    private double xStep = 1;
    private double rStep = 3.33; //Seems to be 0.1 / (rMax - rMin) * 100

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getxMin() {
        return xMin;
    }

    public void setxMin(double xMin) {
        this.xMin = xMin;
    }

    public double getxMax() {
        return xMax;
    }

    public void setxMax(double xMax) {
        this.xMax = xMax;
    }

    public double getyMin() {
        return yMin;
    }

    public void setyMin(double yMin) {
        this.yMin = yMin;
    }

    public double getyMax() {
        return yMax;
    }

    public void setyMax(double yMax) {
        this.yMax = yMax;
    }

    public double getrMin() {
        return rMin;
    }

    public void setrMin(double rMin) {
        this.rMin = rMin;
    }

    public double getrMax() {
        return rMax;
    }

    public void setrMax(double rMax) {
        this.rMax = rMax;
    }

    public double getxStep() {
        return xStep;
    }

    public void setxStep(double xStep) {
        this.xStep = xStep;
    }

    public double getrStep() {
        return rStep;
    }

    public void setrStep(double rStep) {
        this.rStep = rStep;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void submitForm() {
    	Point pnt = new Point();
    	pnt.setR(r);
    	pnt.setX(x);
    	pnt.setY(y);
    	pnt.setHit(checkHit(pnt));
    	FacesContext fCtx = FacesContext.getCurrentInstance();
    	HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
    	String sessionId = session.getId();
    	pnt.setSessionid(sessionId);
    	DatabaseBean dbb = new DatabaseBean();
    	dbb.addPoint(pnt);
    	//return "";
        //addMessage("kekekekekekeke ldofldgjdg");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    private boolean checkHit (Point pnt) {
    	double x = pnt.getX();
    	double y = pnt.getY();
    	double r = pnt.getR();
    	if (x > 0 && y > 0)
    		return false;
    	if (x <= 0 && y > 0) {
    		if (y > (x + r/2))
    			return false;
    		else
    			return true;
    	}
    	if (x > 0 && y <= 0) {
    		if (x > r/2 || y < -r)
    			return false;
    		else return true;
    	}
    	if ((x*x + y*y) > (r*r/4))
    		return false;
    	return true;
    }
    
}