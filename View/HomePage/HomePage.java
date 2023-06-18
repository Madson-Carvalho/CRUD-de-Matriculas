package View.HomePage;

import View.BaseLayout;
import View.Header.Header;
import View.Table.Table;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {
    private BorderLayout layout;
    private Header header;
    private Table table;
    private BaseLayout baseLayout;

    public HomePage(BaseLayout baseLayout) {
        this.baseLayout = baseLayout;
        setBackground(Color.decode("#8C8C8C"));
        layout = new BorderLayout(5,5);
        setLayout(layout);
        initialize();
    }

    public Table getTable() {
        return table;
    }

    private void initialize() {
        header = new Header("LISTA DE ALUNOS CADASTRADOS");
        addComponent(header, "north");

        table = new Table(baseLayout);
        addComponent(table,"center");

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
