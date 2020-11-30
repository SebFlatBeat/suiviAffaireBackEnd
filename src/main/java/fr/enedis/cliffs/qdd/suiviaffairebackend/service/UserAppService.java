package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.UserAppDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.UserApp;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserApp> userApp = userAppDao.findByUsername(username);
        if(userApp.isPresent()){
            return (UserDetails) userApp.get();
        }else {
            throw new UsernameNotFoundException(String.format("Username[%s] not found"));
        }
    }
}
