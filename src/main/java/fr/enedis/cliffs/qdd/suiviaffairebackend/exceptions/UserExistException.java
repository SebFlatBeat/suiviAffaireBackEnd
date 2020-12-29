package fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UserExistException extends Exception {
    public UserExistException(String message) {
        super(message);
    }
}
