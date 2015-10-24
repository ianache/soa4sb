package ws.crossnet.soa4sb.portfolio.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICEVERSION")
@NamedQueries(value={
		@NamedQuery(name="SOAService.findAll",query="select s from SOAService as s"),
		@NamedQuery(name="SOAService.findAllByPortfolioId",query="select s from SOAService as s where s.portfolioCode = :code")
	})
public class SOAService {
	@Id @Column(name="CODE") String code;
	@Column(name="VERSION") String version;
	@Column(name="NAME") String name;
	@Column(name="DESCRIPTION") String description;
	@Column(name="PARENTVERSION") String parentVersion;
	@Column(name="PORTFOLIO_CODE") String portfolioCode;
	
	public SOAService() {
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
	public String getParentVersion() {
		return parentVersion;
	}
	public void setParentVersion(String parentVersion) {
		this.parentVersion = parentVersion;
	}
	public String getPortfolioCode() {
		return portfolioCode;
	}
	public void setPortfolioCode(String portfolioCode) {
		this.portfolioCode = portfolioCode;
	}
	
}
