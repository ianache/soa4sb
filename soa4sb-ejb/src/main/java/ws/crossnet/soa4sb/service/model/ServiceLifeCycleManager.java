package ws.crossnet.soa4sb.service.model;

import java.util.List;

import javax.ejb.Remote;

import ws.crossnet.soa4sb.service.dto.ServiceSpecification;
import ws.crossnet.soa4sb.service.dto.Version;

@Remote
public interface ServiceLifeCycleManager {
	/**
	 * Se realiza la creación de una nueva versión de un servicio. La primera vez que se crea
	 * el servicio es realizada a través de esta operacion.
	 * 
	 * @param service
	 * @return
	 */
	public String createNewService(ServiceSpecification service);
	/**
	 * Se crea una nueva versión del servicio a partir de una versión previa.
	 * 
	 * @param serviceId
	 * @param versionId
	 * @return
	 */
	public String createVersionFromPrevious(String serviceId, String versionId);
	/**
	 * Se listan todas las versiones de un servicio.
	 * @param serviceId
	 * @return
	 */
	public List<Version> listVersions(String serviceId);
}
