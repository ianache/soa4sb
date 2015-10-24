package ws.crossnet.soa4sb.backingbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ws.crossnet.soa4sb.bean.ServiceBean;
import ws.crossnet.soa4sb.bean.ServicePortfolioBean;
import ws.crossnet.soa4sb.facade.ServicesPortfolioFacade;
import ws.crossnet.soa4sb.portfolio.dto.Service;
import ws.crossnet.soa4sb.portfolio.dto.ServicePortfolio;

@ViewScoped
@ManagedBean(name="newServiceBackingBean")
public class NewServiceBackingBean implements Serializable {

	private static final long serialVersionUID = -8127412491816447818L;
	@Inject
		ServicesPortfolioFacade servicesPortfolioFacade;
	@Inject
		ManageServicePortfolioBackingBean manageBean;


	private ServiceBean service = new ServiceBean();
	
	public ServiceBean getService() {
		service.setPortfolioCode(manageBean.getServicePortfolioId());
		return service;
	}

	public void setService(ServiceBean service) {
		this.service = service;
	}

	public String save() {
		try {
			Service s = new Service();
			s.setCode(service.getCode());
			s.setName(service.getFunctionalName());
			s.setDescription(service.getDescription());
			s.setVersion(service.getVersion());
			s.setPortfolioCode(service.getPortfolioCode());
			servicesPortfolioFacade.createNewService(s);
			service = new ServiceBean();
		} catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            //throw new AbortProcessingException(e.getMessage());
		}
		return "ok";
	}
	
	public List<ServicePortfolioBean> getServicesPortfolio() {
		//System.out.println("Consultando Portafolios de Servicios");
		List<ServicePortfolioBean> results = new ArrayList<ServicePortfolioBean>();
		List<ServicePortfolio> lres = servicesPortfolioFacade.getServicesPortfolios();
		//System.out.println("Portfolios de Servicios consultados: " + lres.size());
		
		for(ServicePortfolio sp: lres) {
			results.add(new ServicePortfolioBean( sp.getId(), sp.getName(), sp.getDescription() ));
		}
		
		return results;
	}
}
