package View.Form;

import Model.RegistrationModel;
import Model.RegistrationStorage;
import View.BaseLayout;

import View.HomePage.HomePage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JPanel {
    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private RegistrationModel registrationModel;
    private BaseLayout baseLayout;

    private JTextField nameTxt;
    private JTextField fullAge;
    private JTextField email;
    private JTextField adress;
    private JTextField cep;
    private JTextField phone;
    private JTextField user;
    private JPasswordField password;
    private JComboBox<String> course;
    private JTextArea obs;
    private JCheckBox active;
    private String[] courses = {"Selecione uma opção", "Administração", "ADS", "Medicina", "Direito", "Design", "Psicologia", "Física"};

    public RegisterForm(BaseLayout baseLayout) {
        this.registrationModel = null;
        this.baseLayout = baseLayout;
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();

        mountFormFields();
    }

    public JTextField getNameTxt() {
        return nameTxt;
    }

    public JTextField getFullAge() {
        return fullAge;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getAdress() {
        return adress;
    }

    public JTextField getCep() {
        return cep;
    }

    public JTextField getPhone() {
        return phone;
    }

    public JTextField getUser() {
        return user;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public JComboBox<String> getCourse() {
        return course;
    }

    public JTextArea getObs() {
        return obs;
    }

    public JCheckBox getActive() {
        return active;
    }

    public String[] getCourses() {
        return courses;
    }

    public RegistrationModel getRegistrationModel() {
        return registrationModel;
    }

    public void setRegistrationModel(RegistrationModel registrationModel) {
        this.registrationModel = registrationModel;
    }

    public void mountFormFields() {
        JLabel fieldLabel;

        fieldLabel = new JLabel("Nome Completo *");
        addFormComponents(fieldLabel, 0, 0);
        nameTxt = new JTextField(45);
        addFormComponents(nameTxt, 0, 1);

        fieldLabel = new JLabel("Idade *");
        addFormComponents(fieldLabel, 1, 0);
        fullAge = new JTextField(3);
        addFormComponents(fullAge, 1, 1);

        fieldLabel = new JLabel("E-mail *");
        addFormComponents(fieldLabel, 2, 0);
        email = new JTextField(45);
        addFormComponents(email, 2, 1);

        fieldLabel = new JLabel("Endereço *");
        addFormComponents(fieldLabel, 3, 0);
        adress = new JTextField(100);
        addFormComponents(adress, 3, 1);

        fieldLabel = new JLabel("CEP");
        addFormComponents(fieldLabel, 4, 0);
        cep = new JTextField(15);
        addFormComponents(cep, 4, 1);

        fieldLabel = new JLabel("Telefone");
        addFormComponents(fieldLabel, 5, 0);
        phone = new JTextField(45);
        addFormComponents(phone, 5, 1);

        fieldLabel = new JLabel("Usuário *");
        addFormComponents(fieldLabel, 6, 0);
        user = new JTextField(45);
        addFormComponents(user, 6, 1);

        fieldLabel = new JLabel("Senha *");
        addFormComponents(fieldLabel, 7, 0);
        password = new JPasswordField(45);
        addFormComponents(password, 7, 1);

        fieldLabel = new JLabel("Curso *");
        addFormComponents(fieldLabel, 8, 0);
        course = new JComboBox(courses);
        addFormComponents(course, 8, 1);

        JScrollPane scrollPane;
        fieldLabel = new JLabel("Observações");
        addFormComponents(fieldLabel, 9, 0);
        obs = new JTextArea(3, 25);
        scrollPane = new JScrollPane(obs);
        addFormComponents(scrollPane, 9, 1, 3, 3);

        fieldLabel = new JLabel("Ativo *");
        addFormComponents(fieldLabel, 12, 0);
        active = new JCheckBox();
        addFormComponents(active, 12, 1);

        addFormComponents(mountFormButtons(), 13, 0, 2, 0);

    }

    private JPanel mountFormButtons() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        jPanel.add(createAddNewButton());
        jPanel.add(createCancelButton());

        return jPanel;
    }

    private JButton createAddNewButton() {
        JButton addNew = new JButton("Adicionar");
        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (registrationModel == null) {
                    registrationModel = new RegistrationModel();

                    insertModelData(registrationModel, true);
                    JOptionPane.showMessageDialog(RegisterForm.this, "Adicionado com sucesso!", "Cadastro de Matrícula",
                        JOptionPane.INFORMATION_MESSAGE);
                    baseLayout.showHomePage();
                } else {
                    insertModelData(registrationModel, false);
                    JOptionPane.showMessageDialog(RegisterForm.this, "Atualizado com sucesso!", "Cadastro de Matrícula",
                        JOptionPane.INFORMATION_MESSAGE);
                    baseLayout.showHomePage();
                }
            }
        });

        return addNew;
    }

    private JButton createCancelButton() {
        JButton cancel = new JButton("Cancelar");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogobutton = 0;
                dialogobutton = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar?", "Cadastro de Matricula",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(dialogobutton == JOptionPane.YES_OPTION) {
                    baseLayout.showHomePage();
                }if(dialogobutton == JOptionPane.NO_OPTION) {
                    baseLayout.showFormPage(null);
                }

            }
        });

        return cancel;
    }

    private void insertModelData(RegistrationModel model, boolean isNew) {
        model.setName(nameTxt.getText());
        model.setFullAge(Integer.parseInt(fullAge.getText()));
        model.setEmail(email.getText());
        model.setAdress(adress.getText());
        model.setCep(cep.getText());
        model.setPhone(phone.getText());
        model.setUser(user.getText());
        model.setPassword(password.getText());
        model.setCourse(course.getSelectedItem().toString());
        model.setObs(obs.getText());
        model.setActive(active.isSelected());

        if (isNew == true) {
            RegistrationStorage.create(model);
        } else {
            RegistrationStorage.update(model);
        }
    }

    public void addFormComponents(JComponent component, int row, int column) {
        addFormComponents(component,row,column,1,1);
    }

    public void addFormComponents(JComponent component, int row, int column, int width, int height) {
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = FIELD_INSETS;

        layout.setConstraints(component, constraints);
        add(component);
    }
}
