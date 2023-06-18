package View.HomePage;

import Model.RegistrationStorage;
import View.BaseLayout;
import View.Table.Table;
import View.Table.TableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeButtons extends JPanel {
    private BaseLayout baseLayout;
    private JTable table;
    private TableModel tableModel;
    private JButton addNew;
    private JButton edit;
    private JButton remove;

    public HomeButtons(BaseLayout baseLayout, JTable table, TableModel tableModel) {
        this.baseLayout = baseLayout;
        this.table = table;
        this.tableModel = tableModel;
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        showButtons();
    }

    private void showButtons() {
        addNew = new JButton("Adicionar");
        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseLayout.showFormPage(null);
            }
        });
        add(addNew);

        edit = new JButton("Editar");
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseLayout.showFormPage(tableModel.getRegistrationModel(table.getSelectedRow()));
            }
        });
        add(edit);

        remove = new JButton("Remover");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationStorage.delete(tableModel.getRegistrationModel(table.getSelectedRow()));
                tableModel.remove(tableModel.getRegistrationModel(table.getSelectedRow()));
            }
        });
        add(remove);
    }

    public void enableButton() {
        edit.setEnabled(true);
        remove.setEnabled(true);
    }

    public void disableButton() {
        edit.setEnabled(false);
        remove.setEnabled(false);
    }

}
