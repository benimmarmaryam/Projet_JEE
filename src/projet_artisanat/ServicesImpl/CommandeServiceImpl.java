package projet_artisanat.ServicesImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import projet_artisanat.Controllers.SessionDBUtil;
import projet_artisanat.Models.CommandeEntity;
import projet_artisanat.Services.CommandeService;

public class CommandeServiceImpl implements CommandeService {

	public static Session session = SessionDBUtil.getSessionCommandeEntity();
	public static CommandeServiceImpl commandeServiceImpl = new CommandeServiceImpl();
	
	private CommandeServiceImpl() {
		
	}
	
	@Override
	public CommandeEntity findById(Integer id) {
		Transaction transaction = session.beginTransaction();
		CommandeEntity commandeEntity = (CommandeEntity) session.get(CommandeEntity.class, id);
		transaction.commit();

		return commandeEntity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CommandeEntity> findCateAll() {
		return (List<CommandeEntity>) session.createCriteria(CommandeEntity.class).list();	
	}

	@Override
	public void save(CommandeEntity commande) {
		
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(commande);
		transaction.commit();
	}

}
