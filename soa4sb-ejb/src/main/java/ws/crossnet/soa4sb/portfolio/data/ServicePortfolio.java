package ws.crossnet.soa4sb.portfolio.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="SERVICEPORTFOLIO")
@NamedQueries(value={
	@NamedQuery(name="ServicePortfolio.findAll",query="select sp from ServicePortfolio as sp")
})
public class ServicePortfolio {
	@Id @Column(name="CODE") private String code;
	@Column(name="NAME") private String name;
	@Column(name="DESCRIPTION") private String description;
	
	public ServicePortfolio() {
		super();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
