package ws.crossnet.udm.core.dto;

import java.io.Serializable;

public class RelationshipRoleType implements Serializable {
	private static final long serialVersionUID = 802290967999579136L;
	private String name;
	private String description;
	private String minOccurs;
	private String maxOccurs;
	private Integer partyTypeId;
	
	public RelationshipRoleType() {
		super();
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

	public String getMinOccurs() {
		return minOccurs;
	}

	public void setMinOccurs(String minOccurs) {
		this.minOccurs = minOccurs;
	}

	public String getMaxOccurs() {
		return maxOccurs;
	}

	public void setMaxOccurs(String maxOccurs) {
		this.maxOccurs = maxOccurs;
	}

	public Integer getPartyTypeId() {
		return partyTypeId;
	}

	public void setPartyTypeId(Integer partyTypeId) {
		this.partyTypeId = partyTypeId;
	}	
}
