package View.Form;

import View.BaseLayout;
import View.Header.Header;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Arrays;

public class FormPage extends JPanel {
    private BorderLayout layout;
    private RegisterForm registerForm;
    private Header header;
    private BaseLayout baseLayout;

    public FormPage(BaseLayout baseLayout) {
        this.baseLayout = baseLayout;
        setBackground(Color.decode("#8C8C8C"));
        layout = new BorderLayout(5,5);
        setLayout(layout);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                verifyIsNewOrEdit();
            }
        });

        initialize();
    }

    public RegisterForm getRegisterForm() {
        return registerForm;
    }

    private void initialize() {
        registerForm = new RegisterForm(baseLayout);

        add(registerForm,BorderLayout.CENTER);

        header = new Header("CADASTRAR NOVO USUÁRIO");
        add(header, BorderLayout.NORTH);
    }

    public void verifyIsNewOrEdit() {
        if (registerForm.getRegistrationModel() == null) {
            registerForm.getNameTxt().setText("");
            registerForm.getFullAge().setText("");
            registerForm.getEmail().setText("");
            registerForm.getAdress().setText("");
            registerForm.getCep().setText("");
            registerForm.getPhone().setText("");
            registerForm.getUser().setText("");
            registerForm.getPassword().setText("");
            registerForm.getCourse().setSelectedIndex(0);
            registerForm.getObs().setText("");
            registerForm.getActive().setEnabled(true);
        } else {
            registerForm.getNameTxt().setText(registerForm.getRegistrationModel().getName());
            registerForm.getFullAge().setText(Integer.toString(registerForm.getRegistrationModel().getFullAge()));
            registerForm.getEmail().setText(registerForm.getRegistrationModel().getEmail());
            registerForm.getAdress().setText(registerForm.getRegistrationModel().getAdress());
            registerForm.getCep().setText(registerForm.getRegistrationModel().getCep());
            registerForm.getPhone().setText(registerForm.getRegistrationModel().getPhone());
            registerForm.getUser().setText(registerForm.getRegistrationModel().getUser());
            registerForm.getPassword().setText(registerForm.getRegistrationModel().getPassword());
            registerForm.getCourse().setSelectedIndex(Arrays.asList(registerForm.getCourses()).indexOf(registerForm.getRegistrationModel().getCourse()));
            registerForm.getObs().setText(registerForm.getRegistrationModel().getObs());
            registerForm.getActive().setEnabled(registerForm.getRegistrationModel().isActive());
        }
    }
}
