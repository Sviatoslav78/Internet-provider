package org.example.model.service;

import org.example.model.db.Database;
import org.example.model.db.SubscriberDao;
import org.example.model.entity.Subscriber;

public class RegisterService {
    SubscriberDao subscriberDao;

    public RegisterService() {
        subscriberDao = new SubscriberDao(Database.connection);
    }

    public void registerUser(String newUserName) {
        String login = newUserName + subscriberDao.getMaxSubscriber();
        String password = PasswordGenerator.generatePassword();

        subscriberDao.save(new Subscriber(newUserName, login, password));
    }
}
