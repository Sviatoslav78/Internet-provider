package org.example.controller.commands;

import org.example.controller.Command;
import org.example.model.entity.Subscriber;
import org.example.model.service.AuthorizationService;
import org.example.view.View;

public class AuthorizationCommand extends Command {
    private AuthorizationService authorizationService;

    public AuthorizationCommand() {
        authorizationService = new AuthorizationService();
    }

    @Override
    public void execute(View view, String description) {

        String login = description.split(" ")[1];
        String password = description.split(" ")[2];

        if (login.equals("admin123") && password.equals("admin123")) {
            view.showMessage("You are signed in as Admin");
            return;
        }

        Subscriber subscriber = authorizationService.isValidAuth(login, password);
        if (subscriber.getLogin().equals("EMPTY")) {
            view.showError("Invalid login/password");
            System.exit(0);
        } else {
            view.showMessage("You are signed in as " + subscriber.getName());
        }
    }
}
