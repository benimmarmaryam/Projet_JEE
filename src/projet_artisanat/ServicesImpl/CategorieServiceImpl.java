package projet_artisanat.ServicesImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import projet_artisanat.Controllers.SessionDBUtil;
import projet_artisanat.Models.CategorieEntity;
import projet_artisanat.Services.CategorieService;


public class CategorieServiceImpl implements CategorieService {

	public static Session session = SessionDBUtil.getSessionCategorieEntity();
	public static CategorieServiceImpl factureServiceImpl = new CategorieServiceImpl();
	
	private CategorieServiceImpl () {
		
	}	
	
	@Override
	public CategorieEntity findById(Integer id) {		
		
		Transaction transaction = session.beginTransaction();
		CategorieEntity categorieEntity = (CategorieEntity) session.get(CategorieEntity.class, id);
		transaction.commit();

		return categorieEntity;
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<CategorieEntity> findAll() {
		return (List<CategorieEntity>) session.createCriteria(CategorieEntity.class).list();		 
	}
}
