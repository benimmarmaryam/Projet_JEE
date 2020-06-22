package projet_artisanat.Services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import projet_artisanat.Models.CommandeEntity;
import projet_artisanat.ServicesImpl.CommandeServiceImpl;

class CommandeServiceTest {

	static CommandeServiceImpl commandeServiceImpl;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		commandeServiceImpl = CommandeServiceImpl.commandeServiceImpl;
	}

	@Test
	void findById() {
		assertTrue(2 == commandeServiceImpl.findById(2).getCmdid());
	}
	
	@Test
	void findCateAll(){
		List<CommandeEntity> commandes = commandeServiceImpl.findCateAll();
		assertNotNull(commandes);
		assertTrue(commandes.size()>0);
	}
	
	@Test
    void save() {
    	CommandeEntity commande =  commandeServiceImpl.findById(1);
    	int etatinitial = commande.getCmdetat();
    	commande.setCmdetat(etatinitial+1);
    	commandeServiceImpl.save(commande);
    	CommandeEntity commandeAfterSave =  commandeServiceImpl.findById(1);
    	assertTrue(etatinitial != commandeAfterSave.getCmdetat());
    	commande.setCmdetat(etatinitial);
    	commandeServiceImpl.save(commande);
    	CommandeEntity commandeAfterSave2 =  commandeServiceImpl.findById(1);
    	assertTrue(etatinitial == commandeAfterSave2.getCmdetat());
    }

}
