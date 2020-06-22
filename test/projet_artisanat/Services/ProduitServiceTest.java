package projet_artisanat.Services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import projet_artisanat.Models.ProduitEntity;
import projet_artisanat.ServicesImpl.ProduitServiceImpl;

class ProduitServiceTest {

	static ProduitServiceImpl produitServiceImpl;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		produitServiceImpl = ProduitServiceImpl.produitServiceImpl;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testFindAll() {
		List<ProduitEntity> produits = produitServiceImpl.findAll();
		assertNotNull(produits);
		assertTrue(produits.size()>0);
	}

	@Test
	void testFindById() {
		assertTrue(1 == produitServiceImpl.findById(1).getPdtid());
	}

}
