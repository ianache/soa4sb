package ws.crossnet.soa4sb.bean;

import java.io.Serializable;

import javax.enterprise.inject.Alternative;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@SessionScoped
@ManagedBean
@Named
@Alternative
public class ServicePortfolio implements Serializable {
	private String id;
	private String name;
	private String description;
	
	public ServicePortfolio(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ServicePortfolio() {
		super();
	}	
}
