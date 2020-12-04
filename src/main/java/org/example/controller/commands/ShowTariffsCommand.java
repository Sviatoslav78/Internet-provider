package org.example.controller.commands;

import org.example.controller.Command;
import org.example.model.entity.Tariff;
import org.example.model.service.TariffService;
import org.example.view.View;

import java.util.ArrayList;
import java.util.List;

public class ShowTariffsCommand extends Command {
    private TariffService tariffService;

    public ShowTariffsCommand() {
        tariffService = new TariffService();
    }

    @Override
    public void execute(View view, String description) {
        List<Tariff> tariffList = new ArrayList<>();

        switch (description.split(" ")[0]) {
            case "asc":
                tariffList = tariffService.getTariffsAsc();
                break;
            case "desc":
                tariffList = tariffService.getTariffsDesc();
                break;
            case "price":
                tariffList = tariffService.getTariffsByPrice();
        }

        if (tariffList.isEmpty()) {
            view.showError("There are no tariffs");
        } else {
            for (Tariff t :tariffList) {
                System.out.println(t);
            }
        }
    }

}
