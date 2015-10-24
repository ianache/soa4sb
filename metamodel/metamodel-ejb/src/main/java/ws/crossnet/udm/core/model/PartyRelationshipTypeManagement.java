package ws.crossnet.udm.core.model;

import java.util.List;

import javax.ejb.Remote;

import ws.crossnet.udm.core.dto.CreateNewPartyRelationshipTypeReqTYPE;
import ws.crossnet.udm.core.dto.QueryPartyRelationshipsTypesRespTYPE;

@Remote
public interface PartyRelationshipTypeManagement {
	/**
	 * 
	 * @param req
	 * @return
	 */
	public Integer createNewPartyRelationshipType(CreateNewPartyRelationshipTypeReqTYPE req);
	/**
	 * 
	 * @return
	 */
	public QueryPartyRelationshipsTypesRespTYPE queryPartyRelationshipsTypes();
	
	/**
	 * Se realiza el registro de una nueva herencia del PartyType
	 * 
	 * @param childPartyTypeId
	 * @param parentPartyTypeId
	 */
	public void createPartyTypeInheritance(Integer childPartyTypeId, Integer parentPartyTypeId);
	
	/**
	 * Se realiza el registro de varias herencias de un PartyType hacia diferentes padres.
	 * @param childPartyTypeId
	 * @param parentPartyTypeId
	 */
	public void createPartyTypeInheritance(Integer childPartyTypeId, List<Integer> parentPartyTypeIds);
	
}
