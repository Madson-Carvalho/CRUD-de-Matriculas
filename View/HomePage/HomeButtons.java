package View.HomePage;

import Model.RegistrationStorage;
import View.BaseLayout;
import View.Table.Table;
import View.Table.TableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class HomeButtons extends JPanel {
    private JButton button;
    private BaseLayout baseLayout;
    private JTable table;
    private TableModel tableModel;

    public HomeButtons(BaseLayout baseLayout, JTable table, TableModel tableModel) {
        this.baseLayout = baseLayout;
        this.table = table;
        this.tableModel = tableModel;
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        showButtons();
    }

    private void showButtons() {
        button = new JButton("Adicionar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseLayout.showFormPage(null);
            }
        });
        add(button);

        button = new JButton("Editar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseLayout.showFormPage(tableModel.getRegistrationModel(table.getSelectedRow()));
            }
        });
        add(button);

        button = new JButton("Remover");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogobutton = 0;
                dialogobutton = JOptionPane.showConfirmDialog(null, "Deseja realmente remover?", "Cadastro de Matricula",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,null);
                if(dialogobutton == JOptionPane.YES_OPTION) {
                    RegistrationStorage.delete(tableModel.getRegistrationModel(table.getSelectedRow()));
                    tableModel.remove(tableModel.getRegistrationModel(table.getSelectedRow()));
                }if(dialogobutton == JOptionPane.NO_OPTION) {
                    baseLayout.showHomePage();
                }
            }
        });
        add(button);
    }

}
