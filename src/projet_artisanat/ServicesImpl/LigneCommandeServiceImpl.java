package projet_artisanat.ServicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import projet_artisanat.Controllers.SessionDBUtil;
import projet_artisanat.Models.LigneCommandeEntity;
import projet_artisanat.Models.LigneCommandeEntityPK;
import projet_artisanat.Services.LigneCommandeService;

public class LigneCommandeServiceImpl implements LigneCommandeService {

	public static Session session = SessionDBUtil.getSessionLigneCommandeEntity();
	public static LigneCommandeServiceImpl ligneCommandeServiceImpl = new LigneCommandeServiceImpl();
	
	private LigneCommandeServiceImpl () {
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<LigneCommandeEntity> findAllBycmdid(Integer id) {
		List<LigneCommandeEntity>  list = (List<LigneCommandeEntity> ) session.createCriteria(LigneCommandeEntity.class).list();
		List<LigneCommandeEntity>  resultList = new ArrayList<LigneCommandeEntity>();
		for(LigneCommandeEntity lignecommande : list) {
			if(lignecommande.getCmdid() == id){
				resultList.add(lignecommande);
			}
		}
		return resultList;
	}

	@Override
	public LigneCommandeEntity findByPk(LigneCommandeEntityPK ligneCommandePk) {
		return (LigneCommandeEntity)session.get(LigneCommandeEntity.class, ligneCommandePk);
	}

	@Override
	public void save(LigneCommandeEntity ligneCommande) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(ligneCommande);
		transaction.commit();
	}

}
