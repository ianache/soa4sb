package ws.crossnet.soa4sb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServicePortfolioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String description;
	
	private List<ServiceBean> services = new ArrayList<ServiceBean>();
	
	public ServicePortfolioBean(String id, String name, String description) {
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
	public ServicePortfolioBean() {
		super();
	}
	public List<ServiceBean> getServices() {
		return services;
	}
	public void setServices(List<ServiceBean> services) {
		this.services = services;
	}		
}
