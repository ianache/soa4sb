package ws.crossnet.udm.core.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PARTYTYPE")
@NamedQueries(value={
		@NamedQuery(name="PartyType.findAll",query="select pt from PartyType as pt"),
		@NamedQuery(name="PartyType.findById",query="select pt from PartyType as pt where pt.id = :partyId")
	})
public class PartyType {
	@Id @Column(name="ID") Integer id;
	@Column(name="NAME") String name;
	
	public PartyType() {
		super();
	}

	public PartyType(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
}
