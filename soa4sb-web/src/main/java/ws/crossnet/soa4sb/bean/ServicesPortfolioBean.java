package ws.crossnet.soa4sb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ws.crossnet.soa4sb.portfolio.model.ServicePortfolioManager;

@SessionScoped
@ManagedBean
@Named
public class ServicesPortfolioBean {
	@ManagedProperty(value="#{servicePortfolio}")
		ServicePortfolio servicePortfolio;
	@EJB(mappedName="ServicePortfolioManagerBean")
		ServicePortfolioManager servicePortfolioManager;
	
	public ServicePortfolio getServicePortfolio() {
		return servicePortfolio;
	}

	public void setServicePortfolio(ServicePortfolio servicePortfolio) {
		this.servicePortfolio = servicePortfolio;
	}

	private Integer lastId = 0;
	private List<ServicePortfolio> servicesPortfolio = new ArrayList<ServicePortfolio>();
	public List<ServicePortfolio> getServicesPortfolio() {
		return servicesPortfolio;
	}
	
	public String newServicePortfolio() {
		
		servicePortfolioManager.createPortfolio(null);
		
		servicesPortfolio.add(new ServicePortfolio(lastId.toString(), servicePortfolio.getName(), servicePortfolio.getDescription()));		
		return "ok";
	}
}
