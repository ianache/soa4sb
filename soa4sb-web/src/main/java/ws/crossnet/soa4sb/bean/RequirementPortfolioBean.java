package ws.crossnet.soa4sb.bean;

import java.io.Serializable;

public class RequirementPortfolioBean implements Serializable {
	private static final long serialVersionUID = 1863837265348634918L;

	private Integer id;
	private String name;
	private String description;	
	
	public RequirementPortfolioBean() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
	
}
