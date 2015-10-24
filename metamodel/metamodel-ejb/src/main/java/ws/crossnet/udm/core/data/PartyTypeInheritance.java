package ws.crossnet.udm.core.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//@Entity
//@Table(name="PARTYTYPEINHERITANCE")
//@NamedQueries(value={
//		@NamedQuery(name="PartyTypeInheritance.findAll",query="select sp from PartyTypeInheritance as pt")
//	})
public class PartyTypeInheritance {
	//@Id @Column(name="PARTYTYPE_PARENT_ID")
		Integer parentId;
	
	//@Id @Column(name="PARTYTYPE_CHILD_ID")
		Integer childId;

	public PartyTypeInheritance() {
		super();
	}

	public PartyTypeInheritance(Integer parentId, Integer childId) {
		super();
		this.parentId = parentId;
		this.childId = childId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getChildId() {
		return childId;
	}

	public void setChildId(Integer childId) {
		this.childId = childId;
	}
		
}
