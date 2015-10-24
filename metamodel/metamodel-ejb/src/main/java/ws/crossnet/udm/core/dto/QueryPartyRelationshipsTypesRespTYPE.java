package ws.crossnet.udm.core.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QueryPartyRelationshipsTypesRespTYPE implements Serializable {
	private static final long serialVersionUID = 4171192503638684009L;
	private List<PartyRelationshipType> partyRelationshipTypes = new ArrayList<PartyRelationshipType>();
	public QueryPartyRelationshipsTypesRespTYPE() {
		super();
	}
	public List<PartyRelationshipType> getPartyRelationshipTypes() {
		return partyRelationshipTypes;
	}
	public void setPartyRelationshipTypes(
			List<PartyRelationshipType> partyRelationshipTypes) {
		this.partyRelationshipTypes = partyRelationshipTypes;
	}
	
}
