package projet_artisanat.ServicesImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import projet_artisanat.Controller.SessionDBUtil;
import projet_artisanat.Models.CommandeEntity;
import projet_artisanat.Services.CommandeService;

public class CommandeServiceImpl implements CommandeService {

	public static Session session = SessionDBUtil.getSessionCommandeEntity();
	
	@Override
	public CommandeEntity findById(Integer id) {
		Transaction transaction = session.beginTransaction();
		CommandeEntity commandeEntity = (CommandeEntity) session.get(CommandeEntity.class, id);
		transaction.commit();

		return commandeEntity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CommandeEntity> findCarteAll() {
		return (List<CommandeEntity>) session.createCriteria(CommandeEntity.class).list();	
	}

	@Override
	public void save(CommandeEntity commande) {
		
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(commande);
		transaction.commit();

	}

}
