package View;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel{
    public BorderLayout layout;

    private Header header;

    public HomePage() {
        setBackground(Color.decode("#8C8C8C"));
        layout = new BorderLayout(5,5);
        setLayout(layout);
        initialize();
    }

    private void initialize() {
        header = new Header();
        addComponent(header);
    }

    private void addComponent(JComponent component) {
        add(component,BorderLayout.NORTH);
    }
}
