package ws.crossnet.soa4sb.facade;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Singleton;

import ws.crossnet.soa4sb.portfolio.dto.Service;
import ws.crossnet.soa4sb.portfolio.dto.ServicePortfolio;
import ws.crossnet.soa4sb.portfolio.model.ServicePortfolioManager;
import ws.crossnet.udm.core.data.PartyRelationshipType;
import ws.crossnet.udm.core.dto.QueryPartyRelationshipsTypesRespTYPE;
import ws.crossnet.udm.core.model.PartyRelationshipTypeManagement;

@ManagedBean
@SessionScoped
@Singleton
public class RequirementsManagementFacade implements Serializable{
	@EJB(mappedName="PartyRelationshipTypeManagementBean")
	PartyRelationshipTypeManagement partyRelationshipManager;
	
	private static final long serialVersionUID = 5466725299921503212L;

	public RequirementsManagementFacade() {
		super();
	}
	
	public List<PartyRelationshipType> getPartyRelationshipsPortfolios() {
		QueryPartyRelationshipsTypesRespTYPE result = partyRelationshipManager.queryPartyRelationshipsTypes();
		return null;
	}

}
