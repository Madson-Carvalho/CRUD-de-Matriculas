package View.Table;

import Model.TarefaStorage;
import View.HomeButtons;

import javax.swing.*;
import java.awt.*;

public class Table extends JPanel {
    private HomeButtons homeButtons;
    private JTable table;
    private TableModel tableModel;
    private GridBagConstraints constraints;
    private GridBagLayout layout;

    public Table() {
        layout = new GridBagLayout();
        setBackground(Color.decode("#8C8C8C"));
        setLayout(layout);
        constraints = new GridBagConstraints();
        createTable();
        setVisible(true);
    }

    private void createTable() {

        tableModel = new TableModel(TarefaStorage.listar());
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(table);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.setConstraints(scrollPane, constraints);
        add(scrollPane);

        homeButtons = new HomeButtons();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.setConstraints(homeButtons, constraints);
        add(homeButtons);
    }

}
