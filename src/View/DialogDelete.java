package View;

import Controller.StudentController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Controller.ClassOfConst.BIRTHDAY;
import static Controller.ClassOfConst.EXPIRATION;
import static Controller.ClassOfConst.RECEIPT;

public class DialogDelete {
    private JDialog dialog = new JDialog();
    private StudentController studentController;
    private MyFrame frame;
    int number = 0;

    public DialogDelete(StudentController studentController, MyFrame frame) {
        this.studentController = studentController;
        this.frame = frame;
    }

    public void delete() {

        dialog.setSize(500, 500);
        dialog.setLayout(new GridBagLayout());
        dialog.setLocationRelativeTo(null);

        SearchOrDelete searchOrDelete = new SearchOrDelete(dialog);

        dialog = searchOrDelete.oneDialog();

        JButton deleteButton = new JButton("Удалить");

        JLabel delStr = new JLabel("Удалено записей");

        JLabel del = new JLabel();
        del.setText(String.valueOf(number));

        JPanel panelDeleteButton = new JPanel();
        panelDeleteButton.setLayout(new GridBagLayout());

        panelDeleteButton.add(deleteButton, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panelDeleteButton.add(delStr, new GridBagConstraints(0, 1, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panelDeleteButton.add(del, new GridBagConstraints(0, 2, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(panelDeleteButton, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.pack();
        dialog.setVisible(true);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchOrDelete.getRadiobutBirthday1().isSelected() == true) {
                    if(searchOrDelete.CheckOne())
                    number += studentController.deleteName(searchOrDelete.getsurNameText(),searchOrDelete.getfirstNameText(),searchOrDelete.getmiddleNameText(),Integer.parseInt(searchOrDelete.getDay()),BIRTHDAY);
                }

                if (searchOrDelete.getRadiobutBirthday2().isSelected() == true) {
                    if(searchOrDelete.CheckTwo())
                    number += studentController.deleteDayAndYear(Integer.parseInt(searchOrDelete.getDay()),Integer.parseInt(searchOrDelete.getMinNum()),Integer.parseInt(searchOrDelete.getMaxNum()),BIRTHDAY);
                }

                if (searchOrDelete.getRadiobutBirthday3().isSelected() == true) {
                    if(searchOrDelete.CheckThree())
                    number += studentController.deleteDayAndMonth(Integer.parseInt(searchOrDelete.getDay()),Integer.parseInt(searchOrDelete.getMonth()),BIRTHDAY);
                }

                if (searchOrDelete.getRadiobutReceipt1().isSelected() == true) {
                    if(searchOrDelete.CheckOne())
                    number += studentController.deleteName(searchOrDelete.getsurNameText(),searchOrDelete.getfirstNameText(),searchOrDelete.getmiddleNameText(),Integer.parseInt(searchOrDelete.getDay()),RECEIPT);
                }

                if (searchOrDelete.getRadiobutReceipt2().isSelected() == true) {
                    if(searchOrDelete.CheckTwo())
                    number += studentController.deleteDayAndYear(Integer.parseInt(searchOrDelete.getDay()),Integer.parseInt(searchOrDelete.getMinNum()),Integer.parseInt(searchOrDelete.getMaxNum()),RECEIPT);
                }

                if (searchOrDelete.getRadiobutReceipt3().isSelected() == true) {
                    if(searchOrDelete.CheckThree())
                        number += studentController.deleteDayAndMonth(Integer.parseInt(searchOrDelete.getDay()),Integer.parseInt(searchOrDelete.getMonth()),RECEIPT);
                }

                if (searchOrDelete.getRadiobutExpiration1().isSelected() == true) {
                    if(searchOrDelete.CheckOne())
                    number += studentController.deleteName(searchOrDelete.getsurNameText(),searchOrDelete.getfirstNameText(),searchOrDelete.getmiddleNameText(),Integer.parseInt(searchOrDelete.getDay()),EXPIRATION);
                }

                if (searchOrDelete.getRadiobutExpiration2().isSelected() == true) {
                    if(searchOrDelete.CheckTwo())
                    number += studentController.deleteDayAndYear(Integer.parseInt(searchOrDelete.getDay()),Integer.parseInt(searchOrDelete.getMinNum()),Integer.parseInt(searchOrDelete.getMaxNum()),EXPIRATION);
                }

                if (searchOrDelete.getRadiobutExpiration3().isSelected() == true) {
                    if(searchOrDelete.CheckThree())
                        number += studentController.deleteDayAndMonth(Integer.parseInt(searchOrDelete.getDay()),Integer.parseInt(searchOrDelete.getMonth()),EXPIRATION);
                }
                frame.generationTable();
                del.setText(String.valueOf(number));
            }
        });
    }
}

