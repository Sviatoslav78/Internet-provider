package org.example.model.service;

import org.example.model.db.Database;
import org.example.model.db.SubscriberDao;
import org.example.model.entity.Subscriber;

public class DepositService {
    private SubscriberDao subscriberDao;

    public DepositService() {
        subscriberDao = new SubscriberDao(Database.connection);
    }

    public boolean topUpAccount(double depositSum, String userLogin) {
        Subscriber currentSubscriber = subscriberDao.getByLogin(userLogin);

        currentSubscriber.setBalance(currentSubscriber.getBalance() + depositSum);
        subscriberDao.changeBalance(currentSubscriber);

        if (currentSubscriber.getBalance() >= 0) {
            currentSubscriber.setActive(true);
            subscriberDao.update(currentSubscriber);
            return true;
        }
        return false;
    }
}
