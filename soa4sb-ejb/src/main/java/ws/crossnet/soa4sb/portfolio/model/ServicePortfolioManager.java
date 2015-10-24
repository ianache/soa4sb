package ws.crossnet.soa4sb.portfolio.model;

import java.util.List;

import javax.ejb.Remote;

import ws.crossnet.soa4sb.portfolio.dto.Service;
import ws.crossnet.soa4sb.portfolio.dto.ServicePortfolio;

@Remote
public interface ServicePortfolioManager {
	/**
	 * Se realiza la creación de un portafolio de servicios SOA donde se organiza el ciclo completo
	 * de los servicios SOA.
	 * 
	 * @param portfolio
	 * @return
	 */
	public String createPortfolio(ServicePortfolio portfolio);
	/**
	 * 
	 * @return
	 */
	public List<ServicePortfolio> getServicesPortfolios();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Service> getServicesByPortfolioId(String id);
	
	/**
	 * 
	 * @param service
	 * @return
	 */
	public String createNewService(Service service);
}
