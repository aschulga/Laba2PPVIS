package View;

import Model.StudentBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table {

    private ModelTable model = new ModelTable();
    private JTable table = new JTable(model);
    private JScrollPane jsp = new JScrollPane(table);
    public static final int valueNull = 0;
    public static final int value = 1;
    private int number = 10;
    private int numberRecord = 0;
    private int allNumber = 0;
    private int nowNumberStr = 0;
    private int allStr = 0;

    private JPanel panel = new JPanel();

    private JButton firstButton = new JButton("Первая страница");
    private JButton lastButton = new JButton("Последняя страница");
    private JButton prevButton = new JButton("Предыдущая страница");
    private JButton nextButton = new JButton("Следующая страница");
    private JButton otherNumberRecord = new JButton("Изменить");

    private JLabel numberRecords = new JLabel("Число записей:");

    private JTextField numberRecordsText = new JTextField(10);

    private JLabel nowNumberLabel = new JLabel();

    private JLabel allNumberLabel = new JLabel();

    private JLabel nowNumberStrLabel = new JLabel();

    private JLabel allNumberStrLabel = new JLabel();

    private StudentBase base;

    public Table(StudentBase base)
    {
        this.base = base;
    }

    public JPanel createPanel()
    {
        JLabel nowNumberText = new JLabel("Текущее число записей:");
        nowNumberLabel.setText(String.valueOf(numberRecord));

        JLabel allNumberText = new JLabel("Число всех записей:");
        allNumberLabel.setText(String.valueOf(allNumber));

        JLabel nowNumberStrText = new JLabel("Текущий номер страницы:");
        nowNumberStrLabel.setText(String.valueOf(nowNumberStr));
        nowNumberStr ++;

        JLabel allNumberStrText = new JLabel("Число всех страниц:");
        allNumberStrLabel.setText(String.valueOf(allStr));

        panel.setLayout(new GridBagLayout());

        JPanel panel1 = new JPanel();

        panel1.setLayout(new GridLayout());

        panel1.add(firstButton, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel1.add(prevButton, new GridBagConstraints(1, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel1.add(nextButton, new GridBagConstraints(2, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel1.add(lastButton, new GridBagConstraints(3, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout());

        panel2.add(numberRecords, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel2.add(numberRecordsText, new GridBagConstraints(1, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panel2.add(otherNumberRecord, new GridBagConstraints(2, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout());

        panel3.add(nowNumberText, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel3.add(nowNumberLabel, new GridBagConstraints(1, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panel3.add(allNumberText, new GridBagConstraints(1, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel3.add(allNumberLabel, new GridBagConstraints(1, 1, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout());

        panel4.add(nowNumberStrText, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel4.add(nowNumberStrLabel, new GridBagConstraints(1, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panel4.add(allNumberStrText, new GridBagConstraints(1, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel4.add(allNumberStrLabel, new GridBagConstraints(1,1, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        nextButton.addActionListener(new nextButtonActionListener());
        prevButton.addActionListener(new prevButtonActionListener());
        firstButton.addActionListener(new firstButtonActionListener());
        lastButton.addActionListener(new lastButtonActionListener());
        otherNumberRecord.addActionListener(new otherNumberRecordActionListener());

        panel.add(panel1, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(panel2, new GridBagConstraints(0,1, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(panel3, new GridBagConstraints(0, 2, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(panel4, new GridBagConstraints(0,3, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        return panel;
    }

    public void genTable(StudentBase baseStudents) {
        this.base = baseStudents;

        if(numberRecordsText.getText().isEmpty())
            numberRecord = number;

        allNumberLabel.setText(String.valueOf(baseStudents.size()));
        allStr = (int) Math.ceil((float) baseStudents.size() / numberRecord);

        if((nowNumberStr > allStr) && (allStr!=0)) nowNumberStr = allStr;

        nowNumberLabel.setText(String.valueOf(numberRecord));

        if(nowNumberStr == value) prevButton.setEnabled(false);
        else prevButton.setEnabled(true);

        if(nowNumberStr == allStr) {
            nextButton.setEnabled(false);
            if(baseStudents.size()%numberRecord != valueNull)
                nowNumberLabel.setText(String.valueOf(baseStudents.size()%numberRecord));
            else nowNumberLabel.setText(String.valueOf(numberRecord));
        }
        else nextButton.setEnabled(true);

        allNumberStrLabel.setText(String.valueOf(allStr));
        model.addStudent(baseStudents,nowNumberStr,numberRecord);
        nowNumberStrLabel.setText(String.valueOf(nowNumberStr));
        if(baseStudents.size()==valueNull) {
            nowNumberLabel.setText(String.valueOf(valueNull));
            allNumberStrLabel.setText(String.valueOf(valueNull));
            allNumberLabel.setText(String.valueOf(valueNull));
            nowNumberStrLabel.setText(String.valueOf(valueNull));
        }
    }

    public class nextButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            nowNumberStr++;
            genTable(base);
        }
    }

    public class prevButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            nowNumberStr--;
            genTable(base);
        }
    }

    public class firstButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            nowNumberStr = value;
            genTable(base);
        }
    }

    public class lastButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            nowNumberStr = allStr;
            genTable(base);
        }
    }

    public class otherNumberRecordActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            numberRecord = Integer.parseInt(numberRecordsText.getText());
            genTable(base);
        }
    }

    public JScrollPane getJsp()
    {
        return jsp;
    }
}
