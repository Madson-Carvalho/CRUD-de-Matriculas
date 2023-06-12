package View.Form;

import javax.swing.*;
import java.awt.*;

public class FormButtons extends JPanel {
    private JButton formButton;

    public FormButtons() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        createButtons();
    }

    private void createButtons() {
        formButton = new JButton("Adicionar");
        add(formButton);

        formButton = new JButton("Cancelar");
        add(formButton);
    }
}
