package controllers;

import models.AuthModel;
import views.AuthView;
import views.MainPanel;

public class AuthController {
    private AuthView vista;
    private MainPanel mainPanelView;

    public AuthController() {
        vista = new AuthView();
    }

    public void login() {
        vista.login();
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
