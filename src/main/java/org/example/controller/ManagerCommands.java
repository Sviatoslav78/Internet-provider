package org.example.controller;

import org.example.controller.commands.*;

import java.util.HashMap;

public class ManagerCommands {
private final HashMap<String, Command> commands;

    public ManagerCommands() {
        commands = new HashMap<>();
        commands.put("register", new RegisterUserCommand());
        commands.put("authorization", new AuthorizationCommand());
        commands.put("addTariff", new AddTariffCommand());
        commands.put("deleteTariff", new DeleteTariffCommand());
        commands.put("changeStatus", new ChangeUserStatusCommand());
        commands.put("editTariff", new EditTariffCommand());
        commands.put("showTariffs", new ShowTariffsCommand());
        commands.put("chooseTariff", new ChooseTariffCommand());
        commands.put("deposit", new DepositCommand());
        commands.put("profileInfo", new ShowProfileInfoCommand());
    }

    public Command getCommand(String key) {
        return commands.get(key);
    }

}
