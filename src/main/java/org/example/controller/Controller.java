package org.example.controller;

import org.example.model.entity.Subscriber;
import org.example.view.View;

public class Controller {
    View view;
    Subscriber lastAuthorizedUser;
    ManagerCommands managerCommands;

    public Controller() {
        view = new View();
        lastAuthorizedUser = new Subscriber();
        managerCommands = new ManagerCommands();
    }

    public void run() {
        int mainCommand;

        view.showMainMenu();
        mainCommand = view.getCommand("3");
        executeCommands(mainCommand);
    }

    private void executeCommands(int mainCommand) {
        String stringCommand;

        switch (mainCommand) {
            case 1:
                stringCommand = view.getAuthData();
                lastAuthorizedUser.setLogin(stringCommand.split(" ")[1]);
                sendCommand(stringCommand);

                if (lastAuthorizedUser.getLogin().equals("admin123")) {
                    executeAdminCommands();
                } else {
                    executeUserCommands();
                }
                break;
            case 2:
                // guest
                break;
            case 3:
                System.exit(0);
        }
    }

    private void executeAdminCommands() {
        int intCommand;
        view.showMainAdminMenu();
        intCommand = view.getCommand("3");

        switch (intCommand) {
            case 1:
                editTariffCommands();
                break;
            case 2:
                editUserCommands();
                break;
            case 3:
                run();
        }
    }

    private void editTariffCommands() {
        String stringCommand;
        view.showEditTariffsMenu();

        switch (view.getCommand("4")) {
            case 1:
                stringCommand = view.getTariffToAdd();
                sendCommand(stringCommand);
                editTariffCommands();
            case 2:
                stringCommand = view.getTariffToDelete();
                sendCommand(stringCommand);
                editTariffCommands();
            case 3:
                stringCommand = view.getNewTariffPrice();
                sendCommand(stringCommand);
                editTariffCommands();
            case 4:
                executeAdminCommands();
        }
    }

    private void editUserCommands() {
        String stringCommand;
        view.showEditSubscribersMenu();

        switch (view.getCommand("4")) {
            case 1:
                stringCommand = view.getUserNameToRegister();
                sendCommand(stringCommand);
                editUserCommands();
            case 2:
                stringCommand = view.getUserToBlock();
                sendCommand(stringCommand);
                editUserCommands();
            case 3:
                stringCommand = view.getUserToUnblock();
                sendCommand(stringCommand);
                editUserCommands();
            case 4:
                executeAdminCommands();
        }
    }

    private void executeUserCommands() {
        String stringCommand;
        view.showMainUserMenu();

        switch (view.getCommand("5")) {
            case 1:
                stringCommand = view.getTariffSortType();
                sendCommand(stringCommand);
                executeUserCommands();
            case 2:
                stringCommand = view.getTariffToChoose();
                stringCommand += " " + lastAuthorizedUser.getLogin();
                sendCommand(stringCommand);
                executeUserCommands();
                break;
            case 3:
                stringCommand = view.getDepositSum();
                stringCommand += " " + lastAuthorizedUser.getLogin();
                sendCommand(stringCommand);
                executeUserCommands();
                break;
            case 4:
                sendCommand("profileInfo " + lastAuthorizedUser.getLogin());
                executeUserCommands();
            case 5:
                run();
        }
    }

    private void sendCommand(String command) {
        managerCommands.getCommand(command.split(" ")[0]).execute(view, command);
    }

}
