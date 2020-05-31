package editor;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.*;
import java.nio.file.Paths;

public class TextEditor extends JFrame {
    public TextEditor() {
        super("The second stage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(440, 460);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        InitComponents();

    }

    private void InitComponents() {
        JTextArea textEditArea = new JTextArea();
        textEditArea.setName("TextArea");
        JScrollPane scrollableTextArea = new JScrollPane(textEditArea);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setBounds(20, 40, 400, 380);
        scrollableTextArea.setName("ScrollPane");
        add(scrollableTextArea);

        JTextField fileNameField = new JTextField();
        fileNameField.setName("FilenameField");
        fileNameField.setBounds(20, 10, 200, 20);
        add(fileNameField);

        JButton saveButton = new JButton("Save");
        saveButton.setName("SaveButton");
        saveButton.setBounds(220, 10, 90, 20);
        saveButton.addActionListener(actionEvent -> {
            SaveFile(fileNameField.getText(), textEditArea.getText());
        });
        add(saveButton);

        JButton loadButton = new JButton("Load");
        loadButton.setName("LoadButton");
        loadButton.setBounds(310, 10, 90, 20);
        loadButton.addActionListener(actionEvent -> {
            String contained;
            textEditArea.setText("");
            try {
                contained = LoadFile(fileNameField.getText());
                textEditArea.setText(contained);
            } catch (IOException e) {
            }
        });
        add(loadButton);
    }

    public void SaveFile(String fileName, String contained) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(contained);
        } catch (IOException e) {
        }
    }

    public static String LoadFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
