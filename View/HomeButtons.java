package View;

import javax.swing.*;
import java.awt.*;

public class HomeButtons extends JPanel {
    private JButton button;

    public HomeButtons() {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        showButtons();

    }

    private void showButtons() {
        button = new JButton("Adicionar");
        add(button);

        button = new JButton("Editar");
        add(button);

        button = new JButton("Remover");
        add(button);
    }

}
