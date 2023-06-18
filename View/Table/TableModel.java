package View.Table;

import Model.RegistrationModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {
    private ArrayList<RegistrationModel> registrationModels = new ArrayList<RegistrationModel>();
    private String[] column = new String[] { "Nome", "Idade", "E-mail", "Endereço", "CEP", "Telefone", "Observação", "Ativo", "Curso" };

    public TableModel(ArrayList<RegistrationModel> registrationModels) {
        this.registrationModels = registrationModels;
    }

    @Override
    public int getRowCount() {
        return registrationModels.size();
    }

    @Override
    public int getColumnCount() {
        return column.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String columnName = null;

        if (columnIndex >= 0 && columnIndex < column.length) {
            columnName = column[columnIndex];
        }
        return columnName;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String value = null;

        if (rowIndex >= 0 && rowIndex < registrationModels.size()) {
            RegistrationModel model = registrationModels.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    value = model.getName();
                    break;
                case 1:
                    value = Integer.toString(model.getFullAge());
                    break;
                case 2:
                    value = model.getEmail();
                    break;
                case 3:
                    value = model.getAdress();
                    break;
                case 4:
                    value = model.getCep();
                    break;
                case 5:
                    value = model.getPhone();
                    break;
                case 6:
                    value = model.getObs();
                    break;
                case 7:
                    value = model.isActive() ? "Sim" : "Não";
                    break;
                case 8:
                    value = model.getCourse();
                    break;
                default:
                    System.err.printf("[ERRO] Índice de coluna inválido: %d\n", columnIndex);
            }
        }

        return value;
    }

    public RegistrationModel getRegistrationModel(int rowIndex) {
        RegistrationModel registrationModel = null;

        if (rowIndex >= 0 && rowIndex < registrationModels.size()) {
            registrationModel = registrationModels.get(rowIndex);
        }

        return registrationModel;
    }

    public void reloadTable(ArrayList<RegistrationModel> registrationModels) {
        this.registrationModels = registrationModels;
        fireTableDataChanged();
    }

    public void remove(RegistrationModel model) {
        registrationModels.remove(model);
        fireTableDataChanged();
    }

}
