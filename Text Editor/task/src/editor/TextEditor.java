package editor;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.*;
import java.nio.file.Paths;

public class TextEditor extends JFrame {
    JTextArea textEditArea;
    JTextField fileNameField;

    public TextEditor() {
        super("The second stage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(440, 460);
        setLocationRelativeTo(null);
        setLayout(null);
        InitComponents();
        InitMenu();
        setVisible(true);
    }

    private void InitComponents() {
        textEditArea = new JTextArea();
        textEditArea.setName("TextArea");
        JScrollPane scrollableTextArea = new JScrollPane(textEditArea);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setBounds(20, 40, 400, 380);
        scrollableTextArea.setName("ScrollPane");
        add(scrollableTextArea);

        fileNameField = new JTextField();
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
            LoadFile(fileNameField.getText());
        });
        add(loadButton);
    }

    private void InitMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.setName("MenuFile");

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setName("MenuSave");
        saveMenuItem.addActionListener(event -> SaveFile(fileNameField.getText(), textEditArea.getText()));

        JMenuItem loadMenuItem = new JMenuItem("Load");
        loadMenuItem.setName("MenuLoad");
        loadMenuItem.addActionListener(event -> LoadFile(fileNameField.getText()));

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setName("MenuExit");
        exitMenuItem.addActionListener(event -> {
            this.dispose();
            System.exit(0);
        });

        fileMenu.add(saveMenuItem);
        fileMenu.add(loadMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }
    private void SaveFile(String fileName, String contained) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(contained);
        } catch (IOException e) {
        }
    }

    private void LoadFile(String fileName) {
        try {
            String contained = new String(Files.readAllBytes(Paths.get(fileName)));
            textEditArea.setText(contained);
        } catch (IOException e) {
            textEditArea.setText("");
        }
    }
}
