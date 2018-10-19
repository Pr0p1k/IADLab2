import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = "inputView")
public class InputView implements Serializable {
    private int x = 2;
    private double y = 1;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
