package View;

import Model.RegistrationModel;
import View.Form.FormPage;
import View.HomePage.HomePage;

import javax.swing.*;
import java.awt.*;

public class BaseLayout extends JFrame {
    private HomePage homePage;
    private FormPage formPage;
    private CardLayout layout;
    private JPanel cardsPane;

    public BaseLayout() {
        this("Cadastro de Matrículas");
        pack();
        setLocationRelativeTo(null);
        cardsPane = new JPanel();
        layout = new CardLayout();
        cardsPane.setLayout(layout);
        add(cardsPane);

        createPages();
    }

    public BaseLayout(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showFormPage(RegistrationModel registrationModel) {
        formPage.getRegisterForm().setRegistrationModel(registrationModel);
        layout.show(cardsPane, FormPage.class.getName());
    }

    public void showHomePage() {
        homePage.getTable().reloadTableData();
        layout.show(cardsPane, HomePage.class.getName());
    }

    private void createPages() {
        homePage = new HomePage(this);
        cardsPane.add(homePage, HomePage.class.getName());

        formPage = new FormPage(this);
        cardsPane.add(formPage, FormPage.class.getName());
    }
}
