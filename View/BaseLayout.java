package View;

import View.Form.FormPage;

import javax.swing.*;
import java.awt.*;

public class BaseLayout extends JFrame {
    private HomePage homePage = new HomePage();
    private FormPage formPage = new FormPage();
    private CardLayout layout;
    private JPanel cardsPane;

    public BaseLayout() {
        this("Cadastro de Matrículas");
        pack();
        setLocationRelativeTo(null);
        cardsPane = new JPanel();
        cardsPane.setLayout(layout);
        add(cardsPane);
    }

    public BaseLayout(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
//Olhar como alternar entre as telas e dar funcionalidades aos botões.