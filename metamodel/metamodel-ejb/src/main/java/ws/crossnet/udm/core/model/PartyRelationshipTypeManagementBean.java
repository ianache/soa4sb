package ws.crossnet.udm.core.model;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ws.crossnet.udm.core.data.PartyRelationshipRoleType;
import ws.crossnet.udm.core.data.PartyRelationshipRoleTypeKey;
import ws.crossnet.udm.core.data.PartyRelationshipType;
import ws.crossnet.udm.core.data.PartyTypeInheritance;
import ws.crossnet.udm.core.dto.CreateNewPartyRelationshipTypeReqTYPE;
import ws.crossnet.udm.core.dto.PartyRelationshipTypeRole;
import ws.crossnet.udm.core.dto.PartyType;
import ws.crossnet.udm.core.dto.QueryPartyRelationshipsTypesRespTYPE;
import ws.crossnet.udm.core.dto.RelationshipRoleType;

@Stateless
@Named
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PartyRelationshipTypeManagementBean implements PartyRelationshipTypeManagement {
	private Logger logger = LoggerFactory.getLogger(PartyRelationshipTypeManagementBean.class);
	@PersistenceContext(unitName = "udm")
    private EntityManager entityManager;

	@Override
	public Integer createNewPartyRelationshipType(
			CreateNewPartyRelationshipTypeReqTYPE req) {
		logger.info("execute createNewPartyRelationshipType()");
		PartyRelationshipType partyRelType = new PartyRelationshipType();
		partyRelType.setName(req.getName());
		partyRelType.setDescription(req.getDescription());
		entityManager.persist(partyRelType);
		logger.info("PartyRelationshipType created with Id " + partyRelType.getId());
		registerPartyrelationshipRoleType(partyRelType.getId(), req.getFirstRole());
		registerPartyrelationshipRoleType(partyRelType.getId(), req.getSecondRole());
		
		return partyRelType.getId();
	}

	private void registerPartyrelationshipRoleType(Integer id,
			RelationshipRoleType roleDef) {
		PartyRelationshipRoleType roleType = new PartyRelationshipRoleType();
		roleType.setDescription(roleDef.getDescription());
		PartyRelationshipRoleTypeKey key = new PartyRelationshipRoleTypeKey(id, roleDef.getName());
		roleType.setKey(key);
		roleType.setPartyTypeId(roleDef.getPartyTypeId());
		roleType.setMinOccurs(roleDef.getMinOccurs());
		roleType.setMaxOccurs(roleDef.getMaxOccurs());
		entityManager.persist(roleType);
	}

	@Override
	public QueryPartyRelationshipsTypesRespTYPE queryPartyRelationshipsTypes() {
		QueryPartyRelationshipsTypesRespTYPE resp = new QueryPartyRelationshipsTypesRespTYPE();
		logger.info("execute queryPartyRelationshipsTypes()");
		Query q = entityManager.createNamedQuery("PartyRelationshipType.findAll");
		Query qr = entityManager.createNamedQuery("PartyRelationshipRoleType.findAllByRelId");
		Query qe = entityManager.createNamedQuery("PartyType.findById");
		
		List<PartyRelationshipType> rels = q.getResultList();
		for(PartyRelationshipType prt: rels) {
			ws.crossnet.udm.core.dto.PartyRelationshipType pr = 
					new ws.crossnet.udm.core.dto.PartyRelationshipType();
			pr.setId(prt.getId());
			pr.setName(prt.getName());
			pr.setDescription(prt.getDescription());
			
			// Cargar los tipos de partes del tipo de relacion
			/*qr.setParameter("partyRelTypeId", prt.getId());
			List<PartyRelationshipRoleType> parts = qr.getResultList();
			for(PartyRelationshipRoleType prrt: parts) {
				PartyRelationshipTypeRole e = new PartyRelationshipTypeRole();
				e.setName(prrt.getKey().getId());
				e.setMinOccurs(prrt.getMinOccurs());
				e.setMaxOccurs(prrt.getMaxOccurs());
				e.setDescription(prrt.getDescription());
				
				qe.setParameter("partyId", prrt.getPartyTypeId());
				PartyType r = (PartyType) qe.getSingleResult();
				PartyType pe = new PartyType(r.getId(), r.getName(), r.getDescription());
				e.setPartyType(pe );
				
				pr.getRoles().add(e );
			}*/
			
			resp.getPartyRelationshipTypes().add(pr);
		}
		
		return resp;
	}

	@Override
	public void createPartyTypeInheritance(Integer childPartyTypeId,
			Integer parentPartyTypeId) {
		PartyTypeInheritance inheritance = 
				new PartyTypeInheritance(parentPartyTypeId, childPartyTypeId);
		entityManager.persist(inheritance);		
	}

	@Override
	public void createPartyTypeInheritance(Integer childPartyTypeId,
			List<Integer> parentPartyTypeIds) {
		if(parentPartyTypeIds != null) {
			for(Integer parentPartyTypeId: parentPartyTypeIds) {
				PartyTypeInheritance inheritance = 
						new PartyTypeInheritance(parentPartyTypeId, childPartyTypeId);
				entityManager.persist(inheritance);		
			}
		}
	}
}
