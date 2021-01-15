package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.configuration.BCryptEncoderConfig;
import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.UserAppDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.UserApp;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.NotNniException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.UserExistException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.UserNotFoundException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.WrongPasswordException;
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


    @Override
    public UserDetails loadUserByUsername(String username) throws RuntimeException {
        Optional<UserApp> userApp = userAppDao.findByUsername(username);
        if (userApp.isPresent()) {
            return (UserDetails) userApp.get();
        } else {
            throw new UsernameNotFoundException("Utilisateur non trouvé");
        }
    }

    public Optional<UserApp> findById(Long userId) {
        return userAppDao.findById(userId);
    }

    public Optional<UserApp> findByUsername(String username) {
        return userAppDao.findByUsername(username);
    }

    public UserApp findByUsernameAndPassword(String username, String password) throws WrongPasswordException, UserNotFoundException {
        Optional<UserApp> userApp = userAppDao.findByUsername(username);
        if (userApp.isPresent()) {
            String passwordMatch = userApp.get().getPassword();
            boolean matches = BCryptEncoderConfig.passwordencoder().matches(password, passwordMatch);
            if (!matches) {
                throw new WrongPasswordException("Mot de passe incorrect");
            }
        }else{
            throw new UserNotFoundException("Vous n'êtes pas habilité");
        }
        return userApp.get();
    }

    public void saveNewUser(String username, String password, String email) throws UserExistException, NotNniException {
        UserApp newUserApp = new UserApp();
        newUserApp.setUsername(username);
        if(!username.matches("^\\b[a-z[A-Z]][0-9]{5}?$")){
            throw new NotNniException("Exemple de NNI : A00001");
        }
        newUserApp.setPassword(password);
        newUserApp.setEmail(email);
        if (!userAppDao.findByUsername(username).isPresent()) {
            userAppDao.save(newUserApp);
        }else{
            throw new UserExistException("Cet utilisateur existe déjà !");
        }
    }
}

