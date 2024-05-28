package controllers;

import models.InstructorModel;
import views.InstructorView;

import java.sql.SQLException;
import java.util.List;

public class InstructorController {
    private InstructorModel model;
    private InstructorView view;

    public InstructorController() {
        this.model = new InstructorModel();
        this.view = new InstructorView();
    }

    public void showInstructors() {
        try {
            List<List<String>> data = model.get();
            view.displayInstructors(data);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
