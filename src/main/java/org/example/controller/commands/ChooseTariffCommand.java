package org.example.controller.commands;

import org.example.controller.Command;
import org.example.model.service.SubscriberTariffService;
import org.example.view.View;

public class ChooseTariffCommand extends Command {
    private SubscriberTariffService subscriberTariffService;

    public ChooseTariffCommand() {
        subscriberTariffService = new SubscriberTariffService();
    }

    @Override
    public void execute(View view, String description) {
        String tariffName = description.split(" ")[0];
        String userLogin = description.split(" ")[1];

        switch (subscriberTariffService.chooseTariff(tariffName, userLogin)) {
            case "inactive":
                view.showError("Sorry, your account is blocked(not enough money)");
                break;
            case "noTariff":
                view.showError("No such tariff found");
                break;
            case "ok":
                view.showMessage("Tariff " + tariffName + " was successfully chosen");
                break;
            case "noMoney":
                view.showError("Tariff " + tariffName + " was chosen, but your account is blocked now due to lack of funds");
        }

    }
}
