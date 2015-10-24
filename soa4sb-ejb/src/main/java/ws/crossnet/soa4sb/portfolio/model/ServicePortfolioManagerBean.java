package ws.crossnet.soa4sb.portfolio.model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ws.crossnet.soa4sb.portfolio.data.BaseService;
import ws.crossnet.soa4sb.portfolio.data.SOAService;
import ws.crossnet.soa4sb.portfolio.dto.Service;
import ws.crossnet.soa4sb.portfolio.dto.ServicePortfolio;


@Stateless
@Named
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ServicePortfolioManagerBean implements ServicePortfolioManager {
	@PersistenceContext(unitName = "soa4sb")
    private EntityManager entityManager;
	
	@Override
	public String createPortfolio(ServicePortfolio portfolio) {
		ws.crossnet.soa4sb.portfolio.data.ServicePortfolio obj = 
				new ws.crossnet.soa4sb.portfolio.data.ServicePortfolio();
		obj.setCode(portfolio.getId());
		obj.setName(portfolio.getName());
		obj.setDescription(portfolio.getDescription());
		entityManager.persist(obj);
		return portfolio.getId();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ServicePortfolio> getServicesPortfolios() {
		List<ServicePortfolio> results = new ArrayList<ServicePortfolio>();
		Query q = entityManager.createNamedQuery("ServicePortfolio.findAll");
		List<ws.crossnet.soa4sb.portfolio.data.ServicePortfolio> rs = q.getResultList();
		for(ws.crossnet.soa4sb.portfolio.data.ServicePortfolio s: rs) {
			results.add(new ServicePortfolio(s.getCode(), s.getName(), s.getDescription()));
		}
		
		return results;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Service> getServicesByPortfolioId(String id) {
		List<Service> results = new ArrayList<Service>();
		//Query q = entityManager.createNamedQuery("SOAService.findAll");
		Query q = entityManager.createNamedQuery("SOAService.findAllByPortfolioId");
		q.setParameter("code", id);
		List<ws.crossnet.soa4sb.portfolio.data.SOAService> services = q.getResultList();
		for(ws.crossnet.soa4sb.portfolio.data.SOAService s: services) {
			results.add(new Service(s.getPortfolioCode(), s.getCode(),s.getName(),s.getVersion(),s.getDescription(),s.getParentVersion()));
		}
		return results;
	}

	@Override
	public String createNewService(Service service) {
		BaseService bs = new BaseService();
		bs.setCode(service.getCode());
		entityManager.persist(bs);

		SOAService s = new SOAService();
		s.setCode(service.getCode());
		s.setName(service.getName());
		s.setDescription(service.getDescription());
		s.setParentVersion(service.getParentVersion());
		s.setVersion("1.0");
		s.setPortfolioCode(service.getPortfolioCode());
		entityManager.persist(s);
		return null;
	}
}
