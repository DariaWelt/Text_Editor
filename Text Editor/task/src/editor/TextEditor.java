package editor;

import javax.swing.*;

public class TextEditor extends JFrame {
    public TextEditor() {
        super("The first stage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        InitComponents();
        setLayout(null);
    }

    private void InitComponents() {
        JTextArea textEditArea = new JTextArea();
        textEditArea.setName("TextArea");
        textEditArea.setBounds(20,20,240,220);
        add(textEditArea);
    }

}
