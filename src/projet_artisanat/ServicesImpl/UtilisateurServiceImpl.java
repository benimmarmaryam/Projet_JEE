package projet_artisanat.ServicesImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import projet_artisanat.Controller.SessionDBUtil;
import projet_artisanat.Models.UtilisateurEntity;
import projet_artisanat.Services.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService{
	
	public static Session session = SessionDBUtil.getSessionUtilisateurEntity();

	@Override
	public UtilisateurEntity findById(Integer id) {

		Transaction transaction = session.beginTransaction();
		UtilisateurEntity utilisateurEntity = (UtilisateurEntity) session.get(UtilisateurEntity.class, id);
		transaction.commit();

		return utilisateurEntity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public UtilisateurEntity findByLogin(String login) {
		List<UtilisateurEntity> list = (List<UtilisateurEntity>) session.createCriteria(UtilisateurEntity.class).list();
		for(UtilisateurEntity utilisateur : list ) {
			if(utilisateur.getUtillogin().equals(login))
				return utilisateur;
		}
		return null;
	}

	@Override
	public void save(UtilisateurEntity utilisateur) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(utilisateur);
		transaction.commit();
	}

}
