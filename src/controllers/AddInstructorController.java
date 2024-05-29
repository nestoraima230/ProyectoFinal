package controllers;

import java.util.List;

import models.AddInstructorModel;
import views.AddInstructorView;
import views.InstructorMainPanel;

public class AddInstructorController {

    private AddInstructorView view;
    private AddInstructorModel model;
    private InstructorMainPanel instructorMainPanelView;

    public AddInstructorController() {
        view = new AddInstructorView(this); 
        model = new AddInstructorModel();
    }

    public boolean addInstructor(String nombre, String apellidos, String especialidad, String email) {
        List<String> instructorData = List.of(nombre, apellidos, especialidad, email);
        return model.addInstructor(instructorData);
    }

    public void showInstructorMainPanel() {
        if (instructorMainPanelView == null) {
            instructorMainPanelView = new InstructorMainPanel();
        }
        instructorMainPanelView.setVisible(true);
    }

    public void showView() {
    	view.setVisible(true);
    }
}
