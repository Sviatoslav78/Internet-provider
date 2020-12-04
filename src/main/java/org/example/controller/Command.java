package org.example.controller;

import org.example.view.View;

public abstract class Command {
    public abstract void execute(View view, String description);
}
