package View;

import java.awt.Font;
import javax.swing.*;

public class Header extends JPanel {

    public Header(String name) {
        render(name);
    }

    private void render(String name) {
        JLabel header = new JLabel(name);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setVerticalAlignment(JLabel.CENTER);
        header.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(header);
    }

}
