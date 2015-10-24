package ws.crossnet.udm.core.model.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ws.crossnet.udm.core.dto.CreateNewPartyRelationshipTypeReqTYPE;
import ws.crossnet.udm.core.dto.QueryPartyRelationshipsTypesRespTYPE;
import ws.crossnet.udm.core.dto.RelationshipRoleType;
import ws.crossnet.udm.core.model.PartyRelationshipTypeManagement;

public class PartyRelationshipTypeManagementTest {
	private static EJBContainer ejbContainer;
	private PartyRelationshipTypeManagement ejb;
	
	@BeforeClass
    public static void startTheContainer() {
        ejbContainer = EJBContainer.createEJBContainer();
    }

	@Before
    public void lookupABean() throws NamingException {
        Object object = ejbContainer.getContext().lookup("java:global/metamodel-ejb/PartyRelationshipTypeManagementBean");

        assertTrue(object instanceof PartyRelationshipTypeManagement);

        ejb = (PartyRelationshipTypeManagement) object;
    }	
	
	@AfterClass
    public static void stopTheContainer() {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }
	
	@Test
	public void testCreateRoleRelationshipType() {
		CreateNewPartyRelationshipTypeReqTYPE req = new CreateNewPartyRelationshipTypeReqTYPE();
		req.setDescription("Descripcion");
		req.setName("Prueba2");
		
		RelationshipRoleType firstRole = new RelationshipRoleType();
		firstRole.setDescription("RoleA");
		firstRole.setName("RoleA");
		firstRole.setPartyTypeId(0);
		firstRole.setMinOccurs("0");
		firstRole.setMinOccurs("1");
		req.setFirstRole(firstRole );

		RelationshipRoleType secondRole = new RelationshipRoleType();
		secondRole.setDescription("RoleB");
		secondRole.setName("RoleB");
		secondRole.setPartyTypeId(0);
		secondRole.setMinOccurs("0");
		secondRole.setMinOccurs("1");
		req.setSecondRole(secondRole);
		
		Integer result = ejb.createNewPartyRelationshipType(req);
		System.out.println("ID Relationship Type: " + result);
		assertEquals(1L, result.longValue());
		
		QueryPartyRelationshipsTypesRespTYPE resultQuery = ejb.queryPartyRelationshipsTypes();
		assertEquals(1, resultQuery.getPartyRelationshipTypes().size());
		for(ws.crossnet.udm.core.dto.PartyRelationshipType d: resultQuery.getPartyRelationshipTypes()) {
			System.out.println("Party Relationship: " + d.getName());
		}
	}
	
	//@Test
	public void testQuery() {
		QueryPartyRelationshipsTypesRespTYPE result = ejb.queryPartyRelationshipsTypes();
		assertEquals(1L, result.getPartyRelationshipTypes().size());
	}
}
