package View;

import javax.swing.*;

public class Header extends JPanel{

    public Header() {
        render();
    }

    private void render() {
        // Adicionando um botão na primeira célula
        JLabel header = new JLabel("Lista de alunos cadastrados");
        add(header);
    }
}
