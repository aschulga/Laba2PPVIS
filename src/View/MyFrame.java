package View;

import Controller.Handler;
import Controller.SaveDialog;
import Controller.StudentController;
import Model.StudentBase;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MyFrame {

    private String title;
    private Dimension d;
    private StudentBase studentBase;
    private StudentController studentController;
    private JFrame frame = new JFrame();
    private Table table;

    JToolBar tb = new JToolBar();
    JButton createButton = new JButton(new ImageIcon("1.png"));
    JButton openButton = new JButton(new ImageIcon("2.png"));
    JButton saveButton = new JButton(new ImageIcon("3.png"));
    JButton searchButton = new JButton(new ImageIcon("4.png"));
    JButton deleteButton = new JButton(new ImageIcon("5.png"));
    JButton offButton = new JButton(new ImageIcon("6.png"));

    private JMenuBar menubar = new JMenuBar();
    private JMenu fileMenu = new JMenu("Файл");
    private JMenu searchMenu = new JMenu("Поиск");
    private JMenu deleteMenu = new JMenu("Удаление");

    private JMenuItem createMenuItem = new JMenuItem("Создать");
    private JMenuItem openMenuItem = new JMenuItem("Открыть");
    private JMenuItem saveMenuItem = new JMenuItem("Сохранить");
    private JMenuItem exitMenuItem = new JMenuItem("Выход");

    private JMenuItem searchMenuItem = new JMenuItem("Найти студента");
    private JMenuItem deleteMenuItem = new JMenuItem("Удалить студента");

    public MyFrame(String title, Dimension d, StudentController studentController) {
        this.title = title;
        this.d = d;
        this.studentController = studentController;
        this.studentBase = studentController.getBase();
        table = new Table(studentController.getBase());
    }

    public void init() {
        frame.setTitle(title);
        frame.setSize(d);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(table.getJsp(), BorderLayout.CENTER);
        table.getJsp().setPreferredSize(new Dimension(700, 500));

        tb.add(createButton);
        tb.add(openButton);
        tb.add(saveButton);
        tb.add(searchButton);
        tb.add(deleteButton);
        tb.add(offButton);

        frame.getContentPane().add(tb, BorderLayout.NORTH);

        frame.add(table.createPanel(),BorderLayout.AFTER_LAST_LINE);

        createButton.addActionListener(new createActionListener());
        createMenuItem.addActionListener(new createActionListener());

        searchButton.addActionListener(new searchActionListener());
        searchMenuItem.addActionListener(new searchActionListener());

        deleteButton.addActionListener(new deleteActionListener());
        deleteMenuItem.addActionListener(new deleteActionListener());

        saveButton.addActionListener(new saveActionListener());
        saveMenuItem.addActionListener(new saveActionListener());

        openButton.addActionListener(new openActionListener());
        openMenuItem.addActionListener(new openActionListener());

        offButton.addActionListener(new offActionListener());
        exitMenuItem.addActionListener(new offActionListener());

        createMenuItem.setIcon(new ImageIcon("1.png"));
        openMenuItem.setIcon(new ImageIcon("2.png"));
        saveMenuItem.setIcon(new ImageIcon("3.png"));
        exitMenuItem.setIcon(new ImageIcon("6.png"));

        fileMenu.add(createMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);

        searchMenuItem.setIcon(new ImageIcon("4.png"));
        deleteMenuItem.setIcon(new ImageIcon("5.png"));

        searchMenu.add(searchMenuItem);
        deleteMenu.add(deleteMenuItem);

        menubar.add(fileMenu);
        menubar.add(searchMenu);
        menubar.add(deleteMenu);
        frame.setJMenuBar(menubar);

        frame.setVisible(true);
        frame.pack();
    }

    public class saveActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser filesave = new JFileChooser();
            int val = filesave.showDialog(null,"Сохранить");
            if(val == JFileChooser.APPROVE_OPTION) {
                File file = filesave.getSelectedFile();
                SaveDialog saveStudentDialog = new SaveDialog(studentController, file);
                saveStudentDialog.save();
            }
        }
    }

    public class openActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileopen = new JFileChooser();
            int val = fileopen.showDialog(null, "Открыть файл");
            if (val == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                SAXParserFactory parserF = SAXParserFactory.newInstance();
                Handler handler = new Handler(studentController, MyFrame.this);
                try {
                    SAXParser saxParser = parserF.newSAXParser();
                    saxParser.parse(file, handler);
                } catch (SAXException e1) {
                    e1.printStackTrace();
                } catch (ParserConfigurationException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public class createActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DialogCreate addStudentDialog = new DialogCreate(studentController, MyFrame.this);
            addStudentDialog.create();
        }
    }

    public class searchActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DialogSearch searchStudentDialog = new DialogSearch(studentController);
            searchStudentDialog.search();
        }
    }

    public class deleteActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DialogDelete searchStudentDialog = new DialogDelete(studentController, MyFrame.this);
            searchStudentDialog.delete();
        }
    }

    public class offActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public void generationTable()
    {
        table.genTable(studentBase);
    }
}
