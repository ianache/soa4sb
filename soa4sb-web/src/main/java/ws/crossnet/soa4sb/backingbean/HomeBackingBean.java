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

import ws.crossnet.soa4sb.bean.ServicePortfolioBean;
import ws.crossnet.soa4sb.components.DataListingSupport;
import ws.crossnet.soa4sb.facade.ServicesPortfolioFacade;
import ws.crossnet.soa4sb.portfolio.dto.ServicePortfolio;

@ManagedBean
@ViewScoped
@Named
@Singleton
public class HomeBackingBean extends DataListingSupport<ServicePortfolioBean> {
	private static final long serialVersionUID = -3321112279089824015L;
	
	org.apache.webbeans.servlet.WebBeansConfigurationListener d;
	
	@Inject
		ServicesPortfolioFacade servicesPortfolioFacade;
	
	@Inject
		ManageServicePortfolioBackingBean manageBean;

	private String selectedPortfolioId;
	
	public HomeBackingBean() {
		super();
	}
	
	@PostConstruct
	public void loadData() {
		setRowsPerPage(5);
		refresh();
	}

	public List<ServicePortfolioBean> getServicesPortfolio() {
		List<ServicePortfolioBean> results = new ArrayList<ServicePortfolioBean>();
		
		for(ServicePortfolio sp: servicesPortfolioFacade.getServicesPortfolios()) {
			results.add(new ServicePortfolioBean( sp.getId(), sp.getName(), sp.getDescription() ));
		}
		
		return results;
	}
	
	public String getSelectedPortfolioId() {
		return selectedPortfolioId;
	}

	public void setSelectedPortfolioId(String selectedPortfolioId) {
		this.selectedPortfolioId = selectedPortfolioId;
	}

	@Override
	protected void populateCountAndData() {
		List<ServicePortfolioBean> l = getServicesPortfolio();
		setRecordCount(l.size());
		setData(new ListDataModel<ServicePortfolioBean>(l));
	}	
	
	public String go(String id) {
		manageBean.setServicePortfolioId(id);
		return "viewPortfolio";
	}
	
	public DataModel<ServicePortfolioBean> getQueryData() {
		refresh();
		return getData();
	}	
}
