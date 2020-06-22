package projet_artisanat.Controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import projet_artisanat.Models.CategorieEntity;
import projet_artisanat.Models.CommandeEntity;
import projet_artisanat.Models.FactureEntity;
import projet_artisanat.Models.LigneCommandeEntity;
import projet_artisanat.Models.ProduitEntity;
import projet_artisanat.Models.UtilisateurEntity;

public class SessionDBUtil {

	private static SessionDBUtil sessionDBUtil = new SessionDBUtil();
	private Session sessionCategorie;
	private Session sessionCommande;
	private Session sessionFacture;
	private Session sessionLigneCommande;
	private Session sessionProduit;
	private Session sessionUtilisateur;
	static int idUser = 1;
	static int pdtid;
	
	
	private SessionDBUtil() {
		
		sessionCategorie = configurationCommun(CategorieEntity.class);
		sessionCommande = configurationCommun(CommandeEntity.class);
		sessionFacture = configurationCommun(FactureEntity.class);
		sessionLigneCommande = configurationCommun(LigneCommandeEntity.class);
		sessionProduit = configurationCommun(ProduitEntity.class);
		sessionUtilisateur = configurationCommun(UtilisateurEntity.class);		
	}
	
	public static Session getSessionCategorieEntity() {
		return sessionDBUtil.sessionCategorie;
	}
	
	public static Session getSessionCommandeEntity() {
		return sessionDBUtil.sessionCommande;
	}
	
	public static Session getSessionFactureEntity() {
		return sessionDBUtil.sessionFacture;
	}
	
	public static Session getSessionLigneCommandeEntity() {
		return sessionDBUtil.sessionLigneCommande;
	}
	
	public static Session getSessionProduitEntity() {
		return sessionDBUtil.sessionProduit;
	}
	
	public static Session getSessionUtilisateurEntity() {
		return sessionDBUtil.sessionUtilisateur;
	}
	
	private static Session configurationCommun(Class<?> classs) {
		Configuration conf = new Configuration().configure().addAnnotatedClass(classs);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = conf.buildSessionFactory(reg);	
		Session session = sessionFactory.openSession();
		return session;
	}
}

