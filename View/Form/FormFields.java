package View.Form;

import javax.swing.*;

public class FormFields {
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
    private JRadioButton active;

    private String[] courses = {"Administração", "ADS", "Medicina", "Direito", "Design", "Psicologia", "Física"};

    private FormButtons formButtons = new FormButtons();

    public void mountFormFields(RegisterForm baseForm) {
        JLabel fieldLabel;

        fieldLabel = new JLabel("Nome Completo");
        baseForm.addFormComponents(fieldLabel,0,0);
        nameTxt = new JTextField(45);
        baseForm.addFormComponents(nameTxt, 0,1);

        fieldLabel = new JLabel("Idade");
        baseForm.addFormComponents(fieldLabel,1,0);
        fullAge = new JTextField(3);
        baseForm.addFormComponents(fullAge, 1,1);

        fieldLabel = new JLabel("E-mail");
        baseForm.addFormComponents(fieldLabel,2,0);
        email = new JTextField(45);
        baseForm.addFormComponents(email, 2,1);

        fieldLabel = new JLabel("Endereço");
        baseForm.addFormComponents(fieldLabel,3,0);
        adress = new JTextField(100);
        baseForm.addFormComponents(adress, 3,1);

        fieldLabel = new JLabel("CEP");
        baseForm.addFormComponents(fieldLabel,4,0);
        cep = new JTextField(15);
        baseForm.addFormComponents(cep, 4,1);

        fieldLabel = new JLabel("Telefone");
        baseForm.addFormComponents(fieldLabel,5,0);
        phone = new JTextField(45);
        baseForm.addFormComponents(phone, 5,1);

        fieldLabel = new JLabel("Usuário");
        baseForm.addFormComponents(fieldLabel,6,0);
        user = new JTextField(45);
        baseForm.addFormComponents(user, 6,1);

        fieldLabel = new JLabel("Senha");
        baseForm.addFormComponents(fieldLabel,7,0);
        password = new JPasswordField(45);
        baseForm.addFormComponents(password, 7,1);

        fieldLabel = new JLabel("Curso");
        baseForm.addFormComponents(fieldLabel,8,0);
        course = new JComboBox(courses);
        baseForm.addFormComponents(course, 8,1);

        JScrollPane scrollPane;
        fieldLabel = new JLabel("Observações");
        baseForm.addFormComponents(fieldLabel,9,0);
        obs = new JTextArea(25,250);
        scrollPane = new JScrollPane(obs);
        baseForm.addFormComponents(scrollPane, 9,1,3,3);

        JPanel jPanel = new JPanel();
        fieldLabel = new JLabel("Ativo");
        baseForm.addFormComponents(fieldLabel,10,0);
        ButtonGroup buttonGroup = new ButtonGroup();
        active = new JRadioButton("Sim");
        buttonGroup.add(active);
        jPanel.add(active);
        active = new JRadioButton("Não");
        buttonGroup.add(active);
        jPanel.add(active);
        baseForm.addFormComponents(jPanel, 10,1);

        baseForm.addFormComponents(formButtons,11,0);

    }
}
