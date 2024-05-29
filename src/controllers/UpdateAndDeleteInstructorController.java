package controllers;

import java.util.List;

import models.UpdateAndDeleteInstructorModel;
import views.UpdateAndDeleteInstructorView;
import views.InstructorMainPanel;


public class UpdateAndDeleteInstructorController {

    private UpdateAndDeleteInstructorModel model;
    private UpdateAndDeleteInstructorView view;

    public UpdateAndDeleteInstructorController() {
        model = new UpdateAndDeleteInstructorModel();
        view = new UpdateAndDeleteInstructorView(this);
    }

    public boolean updateInstructor(int id, String nombre, String apellidos, String especialidad, String email) {
        List<String> instructorData = List.of(String.valueOf(id), nombre, apellidos, especialidad, email);
        return model.updateInstructor(instructorData);
    }

    public boolean deleteInstructor(int instructorId) {
        return model.deleteInstructor(instructorId);
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
