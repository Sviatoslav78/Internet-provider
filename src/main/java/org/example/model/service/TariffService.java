package org.example.model.service;

import org.example.model.db.Database;
import org.example.model.db.TariffDao;
import org.example.model.entity.ServiceType;
import org.example.model.entity.Subscriber;
import org.example.model.entity.Tariff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TariffService {
    private final TariffDao tariffDao;

    public TariffService() {
        tariffDao = new TariffDao(Database.connection);
    }

    public boolean addTariff(Tariff tariff) {
        if (tariffDao.getByName(tariff.getName()).getName().equals("EMPTY")) {
            tariffDao.save(tariff);
            return true;
        }
        return false;
    }

    public boolean deleteTariff(String name) {
        if (!tariffDao.getByName(name).getName().equals("EMPTY")) {
            tariffDao.deleteByName(name);
            return true;
        }
        return false;
    }

    public boolean changeTariffPrice(String name, int newPrice) {
        if (!tariffDao.getByName(name).getName().equals("EMPTY")) {
            tariffDao.update(new Tariff(ServiceType.EMPTY, name, newPrice));
            return true;
        }
        return false;
    }

    public List<Tariff> getTariffsAsc() {
        List<Tariff> tariffList = tariffDao.getAll();

        Collections.sort(tariffList, Comparator.comparing(Tariff::getName));
        return tariffList;
    }

    public List<Tariff> getTariffsDesc() {
        List<Tariff> tariffList = getTariffsAsc();

        Collections.reverse(tariffList);
        return  tariffList;
    }

    public List<Tariff> getTariffsByPrice() {
        List<Tariff> tariffList = tariffDao.getAll();

        Collections.sort(tariffList, Comparator.comparing(Tariff::getPrice));
        return tariffList;
    }
}
