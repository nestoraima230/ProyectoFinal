package controllers;

import models.RegisterModel;
import views.AuthView;
import views.MainPanel;

public class RegisterController {
    private AuthView vista;
    private MainPanel mainPanelView;

    public RegisterController() {
        vista = new AuthView();
    }

    public void registro() {
        vista.register();
    }

    public void mainPanel() {
        if (mainPanelView == null) {
            mainPanelView = new MainPanel();
        }
        mainPanelView.setVisible(true); 
    }
}
