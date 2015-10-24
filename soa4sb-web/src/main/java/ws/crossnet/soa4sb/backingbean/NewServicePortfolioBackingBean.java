package ws.crossnet.soa4sb.backingbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ws.crossnet.soa4sb.bean.ServicePortfolioBean;
import ws.crossnet.soa4sb.facade.ServicesPortfolioFacade;
import ws.crossnet.soa4sb.portfolio.dto.ServicePortfolio;

@SessionScoped
@ManagedBean
public class NewServicePortfolioBackingBean implements Serializable {

	private static final long serialVersionUID = -8127412491816447818L;
	@Inject
		ServicesPortfolioFacade servicesPortfolioFacade;
	
	// Data Object to collect form data
	private ServicePortfolioBean servicePortfolio = new ServicePortfolioBean();

	public NewServicePortfolioBackingBean() {
		super();
	}

	public ServicePortfolioBean getServicePortfolio() {
		return servicePortfolio;
	}

	public void setServicePortfolio(ServicePortfolioBean servicePortfolio) {
		this.servicePortfolio = servicePortfolio;
	}	
	
	// Actions
	public String save() {
		ServicePortfolio sp = new ServicePortfolio();
		sp.setId(servicePortfolio.getId());
		sp.setName(servicePortfolio.getName());
		sp.setDescription(servicePortfolio.getDescription());
		servicesPortfolioFacade.createPortfolio(sp);
		return "";
	}
}
