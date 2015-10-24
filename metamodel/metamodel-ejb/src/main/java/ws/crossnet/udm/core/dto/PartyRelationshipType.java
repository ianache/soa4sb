package ws.crossnet.udm.core.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PartyRelationshipType implements Serializable {
	private static final long serialVersionUID = 8401696494729511253L;
	private Integer id;
	private String name;
	private String description;
	List<PartyRelationshipTypeRole> roles = new ArrayList<PartyRelationshipTypeRole>();
	
	public PartyRelationshipType() {
		super();
	}
	public PartyRelationshipType(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
	public List<PartyRelationshipTypeRole> getRoles() {
		return roles;
	}
	public void setRoles(List<PartyRelationshipTypeRole> roles) {
		this.roles = roles;
	}
		
}
