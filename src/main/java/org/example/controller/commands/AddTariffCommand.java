package org.example.controller.commands;

import org.example.controller.Command;
import org.example.model.entity.ServiceType;
import org.example.model.entity.Tariff;
import org.example.model.service.TariffService;
import org.example.view.View;

public class AddTariffCommand extends Command {
    private TariffService tariffService;

    public AddTariffCommand() {
        tariffService = new TariffService();
    }

    @Override
    public void execute(View view, String description) {
        int serviceTypeNumber = Integer.parseInt(description.split(" ")[0]);
        String tariffName = description.split(" ")[1];
        int tariffPrice = Integer.parseInt(description.split(" ")[2]);

        ServiceType serviceType = ServiceType.values()[serviceTypeNumber];

        if (tariffService.addTariff(new Tariff(serviceType, tariffName, tariffPrice))) {
            view.showMessage("Tariff was successfully added");
        } else {
            view.showError("Tariff already exists");
        }
    }
}
