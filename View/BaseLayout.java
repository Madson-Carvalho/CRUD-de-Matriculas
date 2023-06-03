package View;

import javax.swing.*;
import java.awt.*;

public class BaseLayout extends JFrame {
    private HomePage homePage = new HomePage();

    public BaseLayout() {
        this("Cadastro de Matrículas");
        add(homePage);
    }

    public BaseLayout(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
