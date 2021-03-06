package ws.crossnet.udm.core.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PARTYRELATIONSHIPTYPE")
@NamedQueries(value={
		@NamedQuery(name="PartyRelationshipType.findAll",query="select prt from PartyRelationshipType as prt")
	})
public class PartyRelationshipType {
	@Id @Column(name="ID") 
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	private Integer id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="NAME")
	private String name;

	public PartyRelationshipType() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
