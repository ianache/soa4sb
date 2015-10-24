package ws.crossnet.soa4sb.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import ws.crossnet.soa4sb.bean.PartyRelationshipTypeBean;
import ws.crossnet.soa4sb.bean.RequirementPortfolioBean;
import ws.crossnet.soa4sb.bean.ServicePortfolioBean;
import ws.crossnet.soa4sb.components.DataListingSupport;
import ws.crossnet.soa4sb.facade.MetamodelManagementFacade;
import ws.crossnet.soa4sb.facade.ServicesPortfolioFacade;
import ws.crossnet.soa4sb.portfolio.dto.ServicePortfolio;
import ws.crossnet.udm.core.data.PartyRelationshipType;

@ManagedBean
@ViewScoped
@Named
@Singleton
public class MetamodelBackingBean extends DataListingSupport<RequirementPortfolioBean> {
	private static final long serialVersionUID = -3321112279089824015L;
	
	org.apache.webbeans.servlet.WebBeansConfigurationListener d;
	
	@Inject
		MetamodelManagementFacade metamodelFacade;

	private String partyRelationshipTypeId;
	
	public MetamodelBackingBean() {
		super();
	}
	
	@PostConstruct
	public void loadData() {
		setRowsPerPage(5);
		refresh();
	}

	public List<PartyRelationshipTypeBean> getPartyRelationshipTypes() {
		List<PartyRelationshipTypeBean> results = new ArrayList<PartyRelationshipTypeBean>();
		
		List<PartyRelationshipType> list = metamodelFacade.getMetamodelPartyRelationshipTypes();
		
		for(PartyRelationshipType pr: list) {
			PartyRelationshipTypeBean bean = new PartyRelationshipTypeBean();
			bean.setId(pr.getId());
			bean.setName(pr.getName());
			bean.setDescription(pr.getDescription());
			results.add(bean);
		}
		
		return results;
	}
	
	public String getPartyRelationshipTypeId() {
		return partyRelationshipTypeId;
	}

	public void setPartyRelationshipTypeId(String partyRelationshipTypeId) {
		this.partyRelationshipTypeId = partyRelationshipTypeId;
	}

	@Override
	protected void populateCountAndData() {
		List<PartyRelationshipTypeBean> l = getPartyRelationshipTypes(); 
		setRecordCount(l.size());
		setData(new ListDataModel<RequirementPortfolioBean>());
	}	
	
	public String go(String id) {
		//manageBean.setServicePortfolioId(id);
		return "viewReqPortfolio";
	}
	
	public DataModel<RequirementPortfolioBean> getQueryData() {
		refresh();
		return getData();
	}	
}
