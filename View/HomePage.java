package View;

import javax.swing.*;
import java.awt.*;

public class HomePage extends BaseLayout{
    public HomePage() {
        initialize();
    }

    private void initialize() {
        JPanel panel;
        JButton button;

        final int NUM_BOTOES = 3;

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        addComponent(panel, 1,1,10024,1000);

        panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.setLayout(new FlowLayout()); // default
        for (int i = 1; i <= NUM_BOTOES; i++) {
            button = new JButton("Botão " + i);
            panel.add(button);
        }
        addComponent(panel, 1,2,10024,1000);

        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        addComponent(panel, 1,3,10024,1000);
    }

    private void addComponent(JComponent component, int row, int column, int width, int height) {
        getConstraints().gridx = column;
        getConstraints().gridy = row;
        getConstraints().gridwidth = width;
        getConstraints().gridheight = height;

        getLayout().setConstraints(component, getConstraints());
        add(component);
    }
}
