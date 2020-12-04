package org.example.controller.commands;

import org.example.controller.Command;
import org.example.model.service.TariffService;
import org.example.view.View;

public class EditTariffCommand extends Command {
    private TariffService tariffService;

    public EditTariffCommand() {
        tariffService = new TariffService();
    }

    @Override
    public void execute(View view, String description) {
        String tariffName = description.split(" ")[0];
        int newTariffPrice = Integer.parseInt(description.split(" ")[1]);

        if (tariffService.changeTariffPrice(tariffName, newTariffPrice)) {
            view.showMessage("Price of the tariff was successfully updated");
        } else {
            view.showError("Price wasn't updated(no such tariff found)");
        }
    }
}
