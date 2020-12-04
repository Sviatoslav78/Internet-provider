package org.example.model.service;

import org.example.model.db.Database;
import org.example.model.db.SubscriberDao;
import org.example.model.entity.Subscriber;

public class AuthorizationService {
    SubscriberDao subscriberDao;

    public AuthorizationService() {
        subscriberDao = new SubscriberDao(Database.connection);
    }

    public Subscriber isValidAuth(String login, String password) {
        Subscriber subscriber = subscriberDao.getByLogin(login);
        if (subscriber.getLogin().equals("EMPTY")) {
            return Subscriber.EMPTY;
        } else {
            if (password.equals(subscriber.getPassword())) {
                return subscriber;
            }
        }
        return Subscriber.EMPTY;
    }
}
