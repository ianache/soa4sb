package ws.crossnet.udm.core.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PartyRelationshipRoleTypeKey implements Serializable {
	private static final long serialVersionUID = -8882796046035310504L;

	@Column(name="PARTYRELATIONSHIPTYPEID")private Integer partyRelationshipTypeId;
	@Column(name="ID") String id;
	
	//private Integer partyRelationshipTypeId;
	//private String id;

	public PartyRelationshipRoleTypeKey() {
		super();
	}	

	public PartyRelationshipRoleTypeKey(Integer partyRelationshipTypeId, String roleId) {
		super();
		this.partyRelationshipTypeId = partyRelationshipTypeId;
		this.id = roleId;
	}	

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof PartyRelationshipRoleTypeKey)) return false;
        PartyRelationshipRoleTypeKey other = (PartyRelationshipRoleTypeKey)obj;
		return (id != null && id.equals(other.getId())) && 
				(partyRelationshipTypeId != null && 
					partyRelationshipTypeId.equals(other.getPartyRelationshipTypeId()));
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((partyRelationshipTypeId == null) ? 0 : partyRelationshipTypeId.hashCode());
		return result;
	}

	public Integer getPartyRelationshipTypeId() {
		return partyRelationshipTypeId;
	}

	public void setPartyRelationshipTypeId(Integer partyRelationshipTypeId) {
		this.partyRelationshipTypeId = partyRelationshipTypeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
}
