package org.example.controller.commands;

import org.example.controller.Command;
import org.example.model.service.SubscriberProfileService;
import org.example.view.View;

public class ShowProfileInfoCommand extends Command {
    private SubscriberProfileService subscriberProfileService;

    public ShowProfileInfoCommand() {
        subscriberProfileService = new SubscriberProfileService();
    }

    @Override
    public void execute(View view, String description) {
        view.showMessage(subscriberProfileService.getUserInfo(description));
    }
}
