package org.example.controller.commands;

import org.example.controller.Command;
import org.example.model.service.DepositService;
import org.example.view.View;

public class DepositCommand extends Command {
    private DepositService depositService;

    public DepositCommand() {
        depositService = new DepositService();
    }

    @Override
    public void execute(View view, String description) {
        double depositSum = Double.parseDouble(description.split(" ")[0]);
        String userLogin = description.split(" ")[1];

        if (depositService.topUpAccount(depositSum, userLogin)) {
            view.showMessage("Transaction finished successfully, your account status is active now");
        } else {
            view.showMessage("Transaction finished successfully, but your account is still blocked");
        }

    }
}
