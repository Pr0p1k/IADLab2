package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

@ManagedBean(name = "inputView")
public class InputView implements Serializable {
	private static final long serialVersionUID = -4049920593055331825L;
	private double x = 2;
    private double y = 1;
    private double r = 0;
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

    public void buttonAction(ActionEvent actionEvent) {
        addMessage("kekekekekekeke ldofldgjdg");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}