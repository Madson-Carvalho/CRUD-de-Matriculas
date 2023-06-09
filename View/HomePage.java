package View;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {
    public BorderLayout layout;
    private HomeButtons homeButtons;
    private Header header;
    //private Table table;

    public HomePage() {
        setBackground(Color.decode("#8C8C8C"));
        layout = new BorderLayout(5, 5);
        setLayout(layout);
        initialize();
    }

    private void initialize() {
        header = new Header();
        addComponent(header, "north");

        //table = new Table();
        //addComponent(table, "center");
        homeButtons = new HomeButtons();
        addComponent(homeButtons, "center");
    }

    private void addComponent(JComponent component, String position) {
        switch (position) {
            case "north":
                add(component, BorderLayout.NORTH);
                break;
            case "south":
                add(component, BorderLayout.SOUTH);
                break;
            case "east":
                add(component, BorderLayout.EAST);
                break;
            case "west":
                add(component, BorderLayout.WEST);
                break;
            case "center":
                add(component,BorderLayout.CENTER);
                break;
        }

    }
}
