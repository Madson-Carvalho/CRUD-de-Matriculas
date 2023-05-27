package View;

import javax.swing.*;
import java.awt.*;

public abstract class BaseLayout extends JFrame {
    private GridBagLayout layout;
    private GridBagConstraints constraints;

    @Override
    public GridBagLayout getLayout() {
        return layout;
    }

    public GridBagConstraints getConstraints() {
        return constraints;
    }

    public BaseLayout() {
        this("Cadastro de Matrículas");
    }

    public BaseLayout(String title) {
        super(title);
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode("#8C8C8C"));
    }
}
