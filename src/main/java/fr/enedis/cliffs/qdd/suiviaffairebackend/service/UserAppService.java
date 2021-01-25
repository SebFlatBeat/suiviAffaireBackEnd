package fr.enedis.cliffs.qdd.suiviaffairebackend.service;


import fr.enedis.cliffs.qdd.suiviaffairebackend.configuration.BCryptEncoderConfig;
import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.UserAppDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.UserApp;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.NotNniException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.UserExistException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.UserNotFoundException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.WrongPasswordException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAppService implements UserDetailsService {

    @Autowired
    private UserAppDao userAppDao;

    private static final Logger LOG = LoggerFactory.getLogger(UserAppService.class);

    @Override
    public UserDetails loadUserByUsername(String username){
        LOG.debug("Chargement d'un utilisateur par son username");
        Optional<UserApp> userApp = userAppDao.findByUsername(username);
        LOG.trace("Vérification de la présence de l'optional");
        if (userApp.isPresent()) {
            LOG.info("Utilisateur retrouvé");
            return (UserDetails) userApp.get();
        } else {
            LOG.warn("Utilisateur non trouvé");
            throw new UsernameNotFoundException("Utilisateur non trouvé");
        }
    }

    public Optional<UserApp> findById(Long userId) {
        LOG.debug("Recherche d'un utilisateur par id");
        return userAppDao.findById(userId);
    }

    public Optional<UserApp> findByUsername(String username) {
        LOG.debug("Recherche d'un utilisateur par son username");
        return userAppDao.findByUsername(username);
    }

    public UserApp findByUsernameAndPassword(String username, String password) throws WrongPasswordException, UserNotFoundException {
        LOG.debug("Recherche d'un utilisateur par son username et son mot de passe");
        Optional<UserApp> userApp = userAppDao.findByUsername(username);
        LOG.trace("Vérification de la présence de l'optional");
        if (userApp.isPresent()) {
            LOG.trace("Vérification du mot de passe");
            String passwordMatch = userApp.get().getPassword();
            boolean matches = BCryptEncoderConfig.passwordencoder().matches(password, passwordMatch);
            if (!matches) {
                LOG.warn("Mot de passe incorrect");
                throw new WrongPasswordException("Mot de passe incorrect");
            }
        }else{
            LOG.warn("Utilisateur inexistant");
            throw new UserNotFoundException("Vous n'êtes pas habilité");
        }
        LOG.info("Utilisateur Authentifié");
        return userApp.get();
    }

    public void saveNewUser(String username, String password, String email) throws UserExistException, NotNniException {
        LOG.debug("Début de l'enregistrement d'un utilisateur");
        UserApp newUserApp = new UserApp();
        newUserApp.setUsername(username);
        LOG.trace("Vérification du respect de la contrainte");
        if(!username.matches("^\\b[a-z[A-Z]][0-9]{5}?$")){
            LOG.error("Contrainte non respectée");
            throw new NotNniException("Exemple de NNI : A00001");
        }
        newUserApp.setPassword(password);
        newUserApp.setEmail(email);
        LOG.trace("Vérification de l'existence de l'utilisateur dans la BDD");
        if (!userAppDao.findByUsername(username).isPresent()) {
            userAppDao.save(newUserApp);
            LOG.info("Nouvel utilisateur enregitré");
        }else{
            LOG.error("Utilisateur déjà exsitant");
            throw new UserExistException("Cet utilisateur existe déjà !");
        }
    }
}


