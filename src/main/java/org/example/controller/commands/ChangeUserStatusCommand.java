package org.example.controller.commands;

import org.example.controller.Command;
import org.example.model.service.ChangeUserStatusService;
import org.example.view.View;

public class ChangeUserStatusCommand extends Command {
    private ChangeUserStatusService changeUserStatusService;

    public ChangeUserStatusCommand() {
        changeUserStatusService = new ChangeUserStatusService();
    }

    @Override
    public void execute(View view, String description) {
        String action = description.split(" ")[0];
        String userLogin = description.split(" ")[1];
        boolean wasChanged = false;

        switch (action) {
            case "block":
                wasChanged = changeUserStatusService.changeUserStatus(userLogin, false);
                break;
            case "unblock":
                wasChanged = changeUserStatusService.changeUserStatus(userLogin, true);
        }
        if (wasChanged) {
            view.showMessage("User status was changed");
        } else {
            view.showError("User status wasn't changed(user doesn't exist)");
        }
    }
}
