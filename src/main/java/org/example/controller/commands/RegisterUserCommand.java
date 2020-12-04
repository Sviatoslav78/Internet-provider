package org.example.controller.commands;

import org.example.controller.Command;
import org.example.model.service.RegisterService;
import org.example.view.View;

public class RegisterUserCommand extends Command {
    private RegisterService registerService;

    public RegisterUserCommand() {
        registerService = new RegisterService();
    }

    @Override
    public void execute(View view, String description) {
        String newUserName = description.split(" ")[0];
        registerService.registerUser(newUserName);
        view.showMessage("User was successfully registered");
    }
}
