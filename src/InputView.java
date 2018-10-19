import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = "inputView")
public class InputView implements Serializable {
    private int x = 2;
    private int y = 0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
