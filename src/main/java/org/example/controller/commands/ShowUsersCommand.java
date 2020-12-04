package org.example.controller.commands;

import org.example.controller.Command;
import org.example.model.entity.Subscriber;
import org.example.model.entity.Tariff;
import org.example.model.service.SubscriberProfileService;
import org.example.view.View;

import java.util.ArrayList;
import java.util.List;

public class ShowUsersCommand extends Command {
    private SubscriberProfileService subscriberProfileService;

    public ShowUsersCommand() {
        subscriberProfileService = new SubscriberProfileService();
    }

    @Override
    public void execute(View view, String description) {
        List<Subscriber> usersList = new ArrayList<>();

        switch (description) {
            case "asc":
                usersList = subscriberProfileService.getAllUsersAsc();
                break;
            case "desc":
                usersList = subscriberProfileService.getAllUsersDesc();
                break;
            case "price":
                usersList = subscriberProfileService.getAllUsersByBalance();
        }

        if (usersList.isEmpty()) {
            view.showError("There are no subscribers");
        } else {
            for (Subscriber s :usersList) {
                System.out.println(s);
            }
        }
    }
}
