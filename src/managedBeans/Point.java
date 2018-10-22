package managedBeans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@Entity
@NamedQuery(
name = "pointlist",
query = "SELECT p FROM Point p")
@ManagedBean(name = "point", eager = false)
@RequestScoped
@Table(name = "Point")
    public class Point implements Serializable  {
        
	private static final long serialVersionUID = 154L;

		@Column (name="X")
        @Id
        private double x;
        
        @Column (name="Y")
        private double y;

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    @Column (name="R")
        private double r;

        private boolean hit;
        public Point(){}

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getR() {
            return r;
        }

        public void setR(double r) {
            this.r = r;
        }
        
    }