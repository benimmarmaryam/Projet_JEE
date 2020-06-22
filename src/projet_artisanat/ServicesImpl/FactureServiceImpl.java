package projet_artisanat.ServicesImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import projet_artisanat.Controllers.SessionDBUtil;
import projet_artisanat.Models.FactureEntity;
import projet_artisanat.Services.FactureService;

public class FactureServiceImpl implements FactureService {
	
	public static Session session = SessionDBUtil.getSessionFactureEntity();
	public static FactureServiceImpl factureServiceImpl = new FactureServiceImpl();
	
	private FactureServiceImpl () {
		
	}
	
	@Override
	public void save(FactureEntity factureCommande) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(factureCommande);
		transaction.commit();
	}

}
