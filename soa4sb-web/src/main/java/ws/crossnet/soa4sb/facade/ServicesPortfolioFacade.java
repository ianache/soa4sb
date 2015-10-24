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

@ManagedBean
@SessionScoped
@Singleton
public class ServicesPortfolioFacade implements Serializable{
	@EJB(mappedName="ServicePortfolioManagerBean")
	ServicePortfolioManager servicePortfolioManager;
	
	private static final long serialVersionUID = 5466725299921503212L;

	public ServicesPortfolioFacade() {
		super();
	}
	
	public List<ServicePortfolio> getServicesPortfolios() {
		return servicePortfolioManager.getServicesPortfolios();
	}

	public void createPortfolio(ServicePortfolio sp) {
		servicePortfolioManager.createPortfolio(sp);		
	}

	public List<Service> findServicesByPortfolioId(String id) {
		return servicePortfolioManager.getServicesByPortfolioId(id);
	}

	public void createNewService(Service s) {
		servicePortfolioManager.createNewService(s);
	}	
}
