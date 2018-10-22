package managedBeans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@Entity
@NamedQuery(
name = "pointlist",
query = "SELECT p FROM Point p WHERE p.sessionid = :session ORDER BY p.created DESC")
@ManagedBean(name = "point", eager = false)
@RequestScoped
@Table(name = "Point")
    public class Point implements Serializable  {
	
	public Point() {
		Date dt = new Date();
		this.setCreated(dt);
	}
	
	private static final long serialVersionUID = 154L;

		@Column (name="X")
        @Id
        private double x;
        
		
		@Id
        @Column (name="Y")
        private double y;
        
		@Id
        @Column (name="R")
        private double r;
        
        @Id
        @Column (name = "Hit")
        private boolean hit;
        
        @Id
        @Column (name = "sessionId")
        private String sessionid;
        
        @Id
        @Temporal(TemporalType.TIMESTAMP)
        @Column (name = "created")
        private Date created;
        
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

		public boolean isHit() {
			return hit;
		}

		public void setHit(boolean hit) {
			this.hit = hit;
		}

		public String getSessionid() {
			return sessionid;
		}

		public void setSessionid(String sessionid) {
			this.sessionid = sessionid;
		}

		public Date getCreated() {
			return created;
		}

		public void setCreated(Date created) {
			this.created = created;
		}
        
        
        
    }