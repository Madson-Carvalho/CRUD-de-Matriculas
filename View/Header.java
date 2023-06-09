package View;

import java.awt.Font;
import javax.swing.*;

public class Header extends JPanel {

    public Header() {
        render();
    }

    private void render() {
        JLabel header = new JLabel("LISTA DE ALUNOS CADASTRADOS");
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setVerticalAlignment(JLabel.CENTER);
        header.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(header);
    }

}
