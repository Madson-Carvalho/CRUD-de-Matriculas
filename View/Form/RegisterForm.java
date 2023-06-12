package View.Form;

import View.Table.Table;

import javax.swing.*;
import java.awt.*;

public class RegisterForm extends JPanel {
    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private FormFields formFields = new FormFields();

    public RegisterForm() {
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();
        showForm();
    }

    private void showForm() {
        formFields.mountFormFields(this);
    }

    public void addFormComponents(JComponent component, int row, int column) {
        addFormComponents(component,row,column,1,1);
    }

    public void addFormComponents(JComponent component, int row, int column, int width, int height) {
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = FIELD_INSETS;

        layout.setConstraints(component, constraints);
        add(component);
    }
}
