package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;



public class NavigationController implements Serializable {
	private static final long serialVersionUID = 1L;

	private String pageId;

    public String processLabPage() {
    	if (pageId.equals("labPage"))
    		return "lab";
    	else return null;
    }
    public String processStartPage() {
    	if (pageId.equals("start"))
    		return "start";
    	else return null;
    }

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
}