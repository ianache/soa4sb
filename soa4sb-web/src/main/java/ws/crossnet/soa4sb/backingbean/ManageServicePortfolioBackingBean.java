package ws.crossnet.soa4sb.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import ws.crossnet.soa4sb.bean.ServiceBean;
import ws.crossnet.soa4sb.components.DataListingSupport;
import ws.crossnet.soa4sb.facade.ServicesPortfolioFacade;
import ws.crossnet.soa4sb.portfolio.dto.Service;

@SessionScoped
@ManagedBean
@Named
@Singleton
public class ManageServicePortfolioBackingBean  extends DataListingSupport<ServiceBean>  {

	private static final long serialVersionUID = -2341442051195625276L;
	@Inject ServicesPortfolioFacade servicesPortfolioFacade;
	
	private ServiceBean service = new ServiceBean();
	
	private String servicePortfolioId = null;
	
	public ManageServicePortfolioBackingBean() {
		super();
		setRowsPerPage(10);
	}
	
	public void loadData() {
		System.out.println("Loading on viewLoad()");
		refresh();
	}
	
	public String getServicePortfolioId() {
	/*	if(servicePortfolioId == null) {
			Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			servicePortfolioId = params.get("servicePortfolioId");			
		}*/
		return servicePortfolioId;
	}

	public void setServicePortfolioId(String servicePortfolioId) {
		System.out.println("Setting servicePortfolioId: " + servicePortfolioId);
		this.servicePortfolioId = servicePortfolioId;
	}

	public ServiceBean getService() {
		if(!service.getPortfolioCode().equals(getServicePortfolioId())) {
			service.setPortfolioCode(getServicePortfolioId());
		}
		return service;
	}

	public void setService(ServiceBean service) {
		this.service = service;
	}	

	public List<ServiceBean> getServicesAssigned() {
		List<ServiceBean> results = new ArrayList<ServiceBean>();
		
		if(servicesPortfolioFacade != null) {		
			System.out.println("Consultando servicios por " + getServicePortfolioId());
			List<Service> services = servicesPortfolioFacade.findServicesByPortfolioId(getServicePortfolioId());
			System.out.println("Servicios consultados: " + services.size());
			
			for(Service s: services) {
				ServiceBean bean = new ServiceBean( );
				bean.setCode(s.getCode());
				bean.setFunctionalName(s.getName());
				bean.setTechnicalName(s.getName());
				bean.setState("Identified");
				bean.setPortfolioCode(s.getPortfolioCode());
				bean.setVersion(s.getVersion());
				results.add(bean);
			}
		}
		
		return results;
	}

	@Override
	protected void populateCountAndData() {
		List<ServiceBean> l = getServicesAssigned();
		setRecordCount(l.size());
		setData(new ListDataModel<ServiceBean>(l));
	}
	
	public DataModel<ServiceBean> getQueryData() {
		refresh();
		return getData();
	}
}
