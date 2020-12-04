package org.example.model.service;

import org.example.model.db.Database;
import org.example.model.db.SubscriberDao;
import org.example.model.entity.Subscriber;

public class ChangeUserStatusService {
    SubscriberDao subscriberDao;

    public ChangeUserStatusService() {
        subscriberDao = new SubscriberDao(Database.connection);
    }

    public boolean changeUserStatus(String userLogin, boolean action) {
        if (!subscriberDao.getByLogin(userLogin).getLogin().equals("EMPTY")) {
            subscriberDao.update(new Subscriber(action, userLogin));
            return true;
        }
        return false;
    }
}
