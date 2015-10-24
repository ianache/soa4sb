package ws.crossnet.udm.core.dto;

import java.io.Serializable;

public class PartyRelationshipTypeRole implements Serializable {
	private static final long serialVersionUID = -4937388992542465617L;
	private String name;
	private String description;
	private String minOccurs;
	private String maxOccurs;
	private PartyType partyType;
	
	public PartyRelationshipTypeRole() {
		super();
	}
	public PartyRelationshipTypeRole(String name, String description,
			String minOccurs, String maxOccurs, PartyType partyType) {
		super();
		this.name = name;
		this.description = description;
		this.minOccurs = minOccurs;
		this.maxOccurs = maxOccurs;
		this.partyType = partyType;
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
	public PartyType getPartyType() {
		return partyType;
	}
	public void setPartyType(PartyType partyType) {
		this.partyType = partyType;
	}	
}
