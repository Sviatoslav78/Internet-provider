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
        String tariffName = description.split(" ")[1];
        String userLogin = description.split(" ")[2];

        if (subscriberTariffService.chooseTariff(tariffName, userLogin)) {
            view.showMessage("Tariff " + tariffName + " was successfully chosen");
        } else {
            view.showError("Tariff wasn't chosen(no such tariff)");
        }

    }
}
