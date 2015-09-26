package ws.crossnet.soa4sb.bean;

import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TimeBean {
	public Date getNow() {
        return Calendar.getInstance().getTime();
    }
}
