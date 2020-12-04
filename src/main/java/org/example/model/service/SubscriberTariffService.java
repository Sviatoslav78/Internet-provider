package org.example.model.service;

import org.example.model.db.Database;
import org.example.model.db.SubscriberDao;
import org.example.model.db.SubscriberTariffDao;
import org.example.model.db.TariffDao;
import org.example.model.entity.Subscriber;
import org.example.model.entity.SubscriberTariff;
import org.example.model.entity.Tariff;

public class SubscriberTariffService {
    private SubscriberTariffDao subscriberTariffDao;
    private TariffDao tariffDao;
    private SubscriberDao subscriberDao;

    public SubscriberTariffService() {
        subscriberTariffDao = new SubscriberTariffDao(Database.connection);
        tariffDao = new TariffDao(Database.connection);
        subscriberDao = new SubscriberDao(Database.connection);
    }

    public boolean chooseTariff (String tariffName, String userLogin) {
        Tariff tariff = tariffDao.getByName(tariffName);
        Subscriber subscriber = subscriberDao.getByLogin(userLogin);

        if (!tariff.getName().equals("EMPTY") &&
        subscriber.getBalance() - tariff.getPrice() > 0) {
            subscriberTariffDao.save(new SubscriberTariff(userLogin, tariffName));
            subscriber.setBalance(subscriber.getBalance() - tariff.getPrice());
            return true;
        }
        subscriber.setActive(false);
        subscriberDao.update(subscriber);
        return false;

    }
}
