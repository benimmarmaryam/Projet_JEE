package projet_artisanat.ServicesImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import projet_artisanat.Controller.SessionDBUtil;
import projet_artisanat.Models.ProduitEntity;
import projet_artisanat.Services.ProduitService;


public class ProduitServiceImpl implements ProduitService {

	public static Session session = SessionDBUtil.getSessionProduitEntity();
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ProduitEntity> findAll() {
		return (List<ProduitEntity>) session.createCriteria(ProduitEntity.class).list();
	}

	@Override
	public ProduitEntity findById(Integer id) {
		Transaction transaction = session.beginTransaction();
		ProduitEntity produitEntity = (ProduitEntity) session.get(ProduitEntity.class, id);
		transaction.commit();

		return produitEntity ;
	}

}
