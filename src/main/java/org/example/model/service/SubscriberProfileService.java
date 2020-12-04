package org.example.model.service;

import org.example.model.db.Database;
import org.example.model.db.SubscriberDao;
import org.example.model.entity.Subscriber;
import org.example.model.entity.Tariff;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubscriberProfileService {
    SubscriberDao subscriberDao;

    public SubscriberProfileService() {
        subscriberDao = new SubscriberDao(Database.connection);
    }

    public String getUserInfo(String login) {
        Subscriber subscriber = subscriberDao.getByLogin(login);
        return subscriber.toString();
    }

    public List<Subscriber> getAllUsersAsc() {
        List<Subscriber> subscriberList = subscriberDao.getAll();

        Collections.sort(subscriberList, Comparator.comparing(Subscriber::getName));
        return subscriberList;
    }

    public List<Subscriber> getAllUsersDesc() {
        List<Subscriber> subscriberList = getAllUsersAsc();

        Collections.reverse(subscriberList);
        return  subscriberList;
    }

    public List<Subscriber> getAllUsersByBalance() {
        List<Subscriber> subscriberList = subscriberDao.getAll();

        Collections.sort(subscriberList, Comparator.comparing(Subscriber::getBalance));
        return subscriberList;
    }
}
