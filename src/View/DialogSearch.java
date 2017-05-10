package View;

import Controller.StudentController;
import Model.StudentBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Controller.ClassOfConst.BIRTHDAY;
import static Controller.ClassOfConst.EXPIRATION;
import static Controller.ClassOfConst.RECEIPT;

public class DialogSearch{

    private JDialog dialog = new JDialog();
    private StudentController studentController;
    private StudentBase searchStudentBase = new StudentBase();
    private Table table;

    public DialogSearch(StudentController studentController) {
        this.studentController = studentController;
        table = new Table(searchStudentBase);
    }

    public void search() {

        dialog.setSize(500,500);
        dialog.setLayout(new GridBagLayout());
        dialog.setLocationRelativeTo(null);

        SearchOrDelete searchOrDelete = new SearchOrDelete(dialog);

        dialog = searchOrDelete.oneDialog();

        JPanel panelTable = new JPanel();
        panelTable.setLayout(new GridBagLayout());

        panelTable.add(table.getJsp(), new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JButton searchButton = new JButton("Поиск");

        JPanel panelSearchButton = new JPanel();
        panelSearchButton.setLayout(new GridBagLayout());

        panelSearchButton.add(searchButton, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(panelSearchButton, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(panelTable, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(table.createPanel(),new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.pack();
        dialog.setVisible(true);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (searchOrDelete.getRadiobutBirthday1().isSelected() == true) {
                    if(searchOrDelete.CheckOne())
                        searchStudentBase = studentController.searchName(searchOrDelete.getsurNameText(),searchOrDelete.getfirstNameText(),searchOrDelete.getmiddleNameText(),Integer.parseInt(searchOrDelete.getDay()),BIRTHDAY);
                }

                if (searchOrDelete.getRadiobutBirthday2().isSelected() == true){
                    if(searchOrDelete.CheckTwo())
                        searchStudentBase = studentController.searchDayAndYear(Integer.parseInt(searchOrDelete.getDay()),Integer.parseInt(searchOrDelete.getMinNum()),Integer.parseInt(searchOrDelete.getMaxNum()),BIRTHDAY);
                }

                if (searchOrDelete.getRadiobutBirthday3().isSelected() == true) {
                    if(searchOrDelete.CheckThree())
                        searchStudentBase = studentController.searchDayAndMonth(Integer.parseInt(searchOrDelete.getDay()),Integer.parseInt(searchOrDelete.getMonth()),BIRTHDAY);
                }

                if (searchOrDelete.getRadiobutReceipt1().isSelected() == true){
                    if(searchOrDelete.CheckOne())
                        searchStudentBase = studentController.searchName(searchOrDelete.getsurNameText(),searchOrDelete.getfirstNameText(),searchOrDelete.getmiddleNameText(),Integer.parseInt(searchOrDelete.getDay()),RECEIPT);
                }

                if (searchOrDelete.getRadiobutReceipt2().isSelected() == true) {
                    if(searchOrDelete.CheckTwo())
                        searchStudentBase = studentController.searchDayAndYear(Integer.parseInt(searchOrDelete.getDay()),Integer.parseInt(searchOrDelete.getMinNum()),Integer.parseInt(searchOrDelete.getMaxNum()),RECEIPT);
                }

                if (searchOrDelete.getRadiobutReceipt3().isSelected() == true){
                    if(searchOrDelete.CheckThree())
                        searchStudentBase = studentController.searchDayAndMonth(Integer.parseInt(searchOrDelete.getDay()),Integer.parseInt(searchOrDelete.getMonth()),RECEIPT);
                }

                if (searchOrDelete.getRadiobutExpiration1().isSelected() == true) {
                    if(searchOrDelete.CheckOne())
                        searchStudentBase = studentController.searchName(searchOrDelete.getsurNameText(),searchOrDelete.getfirstNameText(),searchOrDelete.getmiddleNameText(),Integer.parseInt(searchOrDelete.getDay()),EXPIRATION);
                }

                if (searchOrDelete.getRadiobutExpiration2().isSelected() == true) {
                    if(searchOrDelete.CheckTwo())
                        searchStudentBase = studentController.searchDayAndYear(Integer.parseInt(searchOrDelete.getDay()),Integer.parseInt(searchOrDelete.getMinNum()),Integer.parseInt(searchOrDelete.getMaxNum()),EXPIRATION);
                }

                if (searchOrDelete.getRadiobutExpiration3().isSelected() == true){
                    if(searchOrDelete.CheckThree())
                        searchStudentBase = studentController.searchDayAndMonth(Integer.parseInt(searchOrDelete.getDay()),Integer.parseInt(searchOrDelete.getMonth()),EXPIRATION);
                }
                table.genTable(searchStudentBase);
            }
        });
    }
}
