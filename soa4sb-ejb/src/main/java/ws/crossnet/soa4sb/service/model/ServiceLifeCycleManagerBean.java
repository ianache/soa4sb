package ws.crossnet.soa4sb.service.model;

import java.util.List;

import javax.ejb.Stateless;

import ws.crossnet.soa4sb.service.dto.ServiceSpecification;
import ws.crossnet.soa4sb.service.dto.Version;

@Stateless
public class ServiceLifeCycleManagerBean implements ServiceLifeCycleManager {

	@Override
	public String createNewService(ServiceSpecification service) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createVersionFromPrevious(String serviceId, String versionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Version> listVersions(String serviceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
