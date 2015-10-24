package ws.crossnet.soa4sb.portfolio.dto;

import java.io.Serializable;

public class Service implements Serializable {
	private static final long serialVersionUID = -6143512274652333420L;

	private String code;
	private String name;
	private String version;
	private String description;
	private String parentVersion;
	private String portfolioCode;
	
	public Service() {
		super();
	}

	public Service(String portfolioCode, String code, String name, String version,
			String description, String parentVersion) {
		super();
		this.code = code;
		this.name = name;
		this.version = version;
		this.description = description;
		this.parentVersion = parentVersion;
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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
