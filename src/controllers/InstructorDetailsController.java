package controllers;

import models.InstructorDetailsModel;
import views.InstructorDetailsView;

public class InstructorDetailsController {
    private InstructorDetailsView view;
    private InstructorDetailsModel model;

    public InstructorDetailsController() {
        model = new InstructorDetailsModel();
        view = new InstructorDetailsView(this);
    }

    public void showView() {
        view.setVisible(true);
    }

    public void loadClassHistory(int instructorId) {
        view.displayClassHistory(model.getInstructorDetails(instructorId));
    }
}
