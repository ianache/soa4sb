package ws.crossnet.soa4sb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class HelloPB {
	private String name = "";
	public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    
    public String getHello() {
        if (name == null || name.length() < 1) {
            return null;
        }
        return "Hello " + name;
    }
}
