package projet_artisanat.Services;

import projet_artisanat.Models.UtilisateurEntity;

public interface UtilisateurService {

    UtilisateurEntity findById(Integer id);
    UtilisateurEntity findByLogin(String login);
    void save(UtilisateurEntity utilisateur);

}
