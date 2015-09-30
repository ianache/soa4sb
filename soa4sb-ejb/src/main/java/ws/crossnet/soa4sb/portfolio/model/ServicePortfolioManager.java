package ws.crossnet.soa4sb.portfolio.model;

import javax.ejb.Local;
import javax.ejb.Remote;

import ws.crossnet.soa4sb.portfolio.dto.ServicePortfolio;

//@Remote
@Local
public interface ServicePortfolioManager {
	/**
	 * Se realiza la creación de un portafolio de servicios SOA donde se organiza el ciclo completo
	 * de los servicios SOA.
	 * 
	 * @param portfolio
	 * @return
	 */
	public String createPortfolio(ServicePortfolio portfolio);
}
