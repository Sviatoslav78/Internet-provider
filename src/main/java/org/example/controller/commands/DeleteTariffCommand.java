package org.example.controller.commands;

import org.example.controller.Command;
import org.example.model.service.TariffService;
import org.example.view.View;

public class DeleteTariffCommand extends Command {
    private TariffService tariffService;

    public DeleteTariffCommand() {
        tariffService = new TariffService();
    }

    @Override
    public void execute(View view, String description) {
        String tariffName = description.split(" ")[0];
        if (tariffService.deleteTariff(tariffName)) {
            view.showMessage("Tariff was successfully deleted");
        } else {
            view.showError("Tariff wasn't deleted(it doesn't exist)");
        }
    }
}
