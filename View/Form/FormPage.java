package View.Form;

import View.BaseLayout;
import View.Header;
import View.Table.Table;

import javax.swing.*;
import java.awt.*;

public class FormPage extends JPanel {
    private BorderLayout layout;
    private RegisterForm registerForm;
    private Header header;

    public FormPage() {
        setBackground(Color.decode("#8C8C8C"));
        layout = new BorderLayout(5,5);
        setLayout(layout);
        initialize();
    }

    private void initialize() {
        registerForm = new RegisterForm();
        add(registerForm,BorderLayout.CENTER);

        header = new Header("CADASTRAR NOVO USUÁRIO");
        add(header, BorderLayout.NORTH);
    }
}
