package ws.crossnet.soa4sb.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Singleton;

import org.apache.log4j.Logger;

import ws.crossnet.udm.core.data.PartyRelationshipType;
import ws.crossnet.udm.core.dto.QueryPartyRelationshipsTypesRespTYPE;
import ws.crossnet.udm.core.model.PartyRelationshipTypeManagement;

@ManagedBean
@SessionScoped
@Singleton
public class MetamodelManagementFacade implements Serializable{
	private Logger logger = Logger.getLogger(MetamodelManagementFacade.class);
	@EJB(mappedName="PartyRelationshipTypeManagementBean")
	PartyRelationshipTypeManagement partyRelationshipManager;
	
	private static final long serialVersionUID = 5466725299921503212L;

	public MetamodelManagementFacade() {
		super();
	}
	
	public List<PartyRelationshipType> getMetamodelPartyRelationshipTypes() {
		List<PartyRelationshipType> list = new ArrayList<PartyRelationshipType>();
		QueryPartyRelationshipsTypesRespTYPE result = partyRelationshipManager.queryPartyRelationshipsTypes();
		logger.info("PartyRelationshipTypes items selected: " + result.getPartyRelationshipTypes().size());
		for(ws.crossnet.udm.core.dto.PartyRelationshipType prt: result.getPartyRelationshipTypes()) {
			PartyRelationshipType pr = new PartyRelationshipType();
			pr.setId(prt.getId());
			pr.setDescription(prt.getDescription());
			pr.setName(pr.getName());
		}
		return list;
	}

}
