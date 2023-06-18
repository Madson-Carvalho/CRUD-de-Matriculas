package View.Table;

import Model.RegistrationStorage;
import View.BaseLayout;
import View.HomePage.HomeButtons;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Table extends JPanel {
    private HomeButtons homeButtons;
    private JTable table;
    private TableModel tableModel;
    private GridBagConstraints constraints;
    private GridBagLayout layout;
    private BaseLayout baseLayout;

    public Table(BaseLayout baseLayout) {
        this.baseLayout = baseLayout;
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();
        createTable();
        setVisible(true);
    }

    private void createTable() {

        tableModel = new TableModel(RegistrationStorage.retrieve());
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if  (table.getSelectedRow() >= 0) {
                        homeButtons.enableButton();
                } else {
                        homeButtons.disableButton();
                    }
                }

            }
        });


        JScrollPane scrollPane = new JScrollPane(table);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.setConstraints(scrollPane, constraints);
        add(scrollPane);

        homeButtons = new HomeButtons(baseLayout, table, tableModel);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.setConstraints(homeButtons, constraints);
        add(homeButtons);
    }

    public void reloadTableData() {
        tableModel.reloadTable(RegistrationStorage.retrieve());
    }

}
