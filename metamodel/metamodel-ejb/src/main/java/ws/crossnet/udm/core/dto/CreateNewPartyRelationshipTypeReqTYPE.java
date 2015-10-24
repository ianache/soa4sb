package ws.crossnet.udm.core.dto;

import java.io.Serializable;

public class CreateNewPartyRelationshipTypeReqTYPE implements Serializable {
	private static final long serialVersionUID = -8269908994434996380L;
	private String name;
	private String description;
	private RelationshipRoleType firstRole;
	private RelationshipRoleType secondRole;
	
	public CreateNewPartyRelationshipTypeReqTYPE() {
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

	public RelationshipRoleType getFirstRole() {
		return firstRole;
	}

	public void setFirstRole(RelationshipRoleType firstRole) {
		this.firstRole = firstRole;
	}

	public RelationshipRoleType getSecondRole() {
		return secondRole;
	}

	public void setSecondRole(RelationshipRoleType secondRole) {
		this.secondRole = secondRole;
	}
	
}
