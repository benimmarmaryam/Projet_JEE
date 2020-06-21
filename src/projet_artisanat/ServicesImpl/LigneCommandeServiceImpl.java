package projet_artisanat.ServicesImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import projet_artisanat.Controller.SessionDBUtil;
import projet_artisanat.Models.LigneCommandeEntity;
import projet_artisanat.Models.LigneCommandeEntityPK;
import projet_artisanat.Services.LigneCommandeService;

public class LigneCommandeServiceImpl implements LigneCommandeService {

	public static Session session = SessionDBUtil.getSessionLigneCommandeEntity();
	
	@Override
	//@SuppressWarnings("unchecked")
	public List<LigneCommandeEntity> findAllBycmdid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneCommandeEntity findByPk(LigneCommandeEntityPK ligneCommandePk) {
		return null;//(LigneCommandeEntity) session.createCriteria(LigneCommandeEntity.class).list();
	}

	@Override
	public void save(LigneCommandeEntity ligneCommande) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(ligneCommande);
		transaction.commit();
	}

}
