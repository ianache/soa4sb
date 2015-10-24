package ws.crossnet.udm.core.data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PARTYRELROLETYPE")
@NamedQueries(value={
		@NamedQuery(name="PartyRelationshipRoleType.findAll",query="select prrt from PartyRelationshipRoleType as prrt"),
		@NamedQuery(name="PartyRelationshipRoleType.findAllByRelId",query="select prrt from PartyRelationshipRoleType as prrt where prrt.key.partyRelationshipTypeId = :partyRelTypeId")
	})
public class PartyRelationshipRoleType { 	
	@EmbeddedId
	private PartyRelationshipRoleTypeKey key;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PARTYTYPE_ID")
	private Integer partyTypeId;
	
	@Column(name="MINOCCUR")
	private String minOccurs;
	
	@Column(name="MAXOCCUR")
	private String maxOccurs;

	public PartyRelationshipRoleType() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPartyTypeId() {
		return partyTypeId;
	}

	public void setPartyTypeId(Integer partyTypeId) {
		this.partyTypeId = partyTypeId;
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

	public PartyRelationshipRoleTypeKey getKey() {
		return key;
	}

	public void setKey(PartyRelationshipRoleTypeKey key) {
		this.key = key;
	}	
}
