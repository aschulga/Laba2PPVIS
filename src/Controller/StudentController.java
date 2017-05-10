package Controller;

import Model.Student;
import Model.StudentBase;

import javax.swing.*;
import java.awt.*;

public class StudentController {

    private StudentBase studentBase;
    public static final int value = 0;

    public StudentController(StudentBase studentBase)
    {
        this.studentBase = studentBase;
    }

    public void addStudent(Student student) {
        studentBase.add(student);
    }

    public Student get(int i)
    {
        return studentBase.get(i);
    }

    public int size()
    {
        return studentBase.size();
    }

    public void deleteAllStudent()
    {
        studentBase.deleteAllStudent();
    }

    public StudentBase getBase()
    {
        return studentBase;
    }

    public StudentBase searchName(String surName, String firstName, String middleName, int day, int j)
    {
        StudentBase searchBase = new StudentBase();
        for (int i = 0; i < studentBase.size(); i++)
            if ((studentBase.get(i).getSurName()).equals(surName)
                    && (studentBase.get(i).getFirstName()).equals(firstName)
                    && (studentBase.get(i).getMiddleName()).equals(middleName)
                    && (studentBase.get(i).sel(j).toLocalDate().getDayOfMonth() == day)) {
                searchBase.add(studentBase.get(i));
            }
        if(searchBase.size() == value)
            JOptionPane.showMessageDialog(new Frame(), "Записей не найдено. Для продолжения работы нажмите \"ОК\"");
        return searchBase;
    }

    public StudentBase searchDayAndYear(int day, int yearMin, int yearMax, int j)
    {
        StudentBase searchBase = new StudentBase();
        for (int i = 0; i < studentBase.size(); i++)
            if ((studentBase.get(i).sel(j).toLocalDate().getDayOfMonth() == day)
                    && ((studentBase.get(i).sel(j).toLocalDate().getYear() >= yearMin) && (studentBase.get(i).sel(j).toLocalDate().getYear() <= yearMax))){
                searchBase.add(studentBase.get(i));
            }
        if(searchBase.size() == value)
            JOptionPane.showMessageDialog(new Frame(), "Записей не найдено. Для продолжения работы нажмите \"ОК\"");
        return searchBase;
    }

    public StudentBase searchDayAndMonth(int day, int month, int j)
    {
        StudentBase searchBase = new StudentBase();
        for (int i = 0; i < studentBase.size(); i++)
            if ((studentBase.get(i).sel(j).toLocalDate().getMonthValue() == month)
                    && (studentBase.get(i).sel(j).toLocalDate().getDayOfMonth() == day)){
                searchBase.add(studentBase.get(i));
            }
        if(searchBase.size() == value)
            JOptionPane.showMessageDialog(new Frame(), "Записей не найдено. Для продолжения работы нажмите \"ОК\"");
        return searchBase;
    }

    public int deleteName(String surName, String firstName, String middleName, int day,int j)
    {
        int del = value;
        for (int i = 0; i < studentBase.size(); i++)
            if ((studentBase.get(i).getSurName()).equals(surName)
                    && (studentBase.get(i).getFirstName()).equals(firstName)
                    && (studentBase.get(i).getMiddleName()).equals(middleName)
                    && (studentBase.get(i).sel(j).toLocalDate().getDayOfMonth() == day)) {
                studentBase.delete(i);
                i--;
                del++;
            }
        if(del == value)
            JOptionPane.showMessageDialog(new Frame(), "Записей не найдено. Для продолжения работы нажмите \"ОК\"");
        return del;
    }

    public int deleteDayAndYear(int day, int yearMin, int yearMax,int j)
    {
        int del = value;
        for (int i = 0; i < studentBase.size(); i++)
            if ((studentBase.get(i).sel(j).toLocalDate().getDayOfMonth() == day)
                    && ((studentBase.get(i).sel(j).toLocalDate().getYear() >= yearMin) && (studentBase.get(i).sel(j).toLocalDate().getYear() <= yearMax))) {
                studentBase.delete(i);
                i--;
                del++;
            }
        if(del == value)
            JOptionPane.showMessageDialog(new Frame(), "Записей не найдено. Для продолжения работы нажмите \"ОК\"");
        return del;
    }

    public int deleteDayAndMonth(int day, int month,int j)
    {
        int del = value;
        for (int i = 0; i < studentBase.size(); i++)
            if ((studentBase.get(i).sel(j).toLocalDate().getMonthValue() == month)
                    && (studentBase.get(i).sel(j).toLocalDate().getDayOfMonth() == day)) {
                studentBase.delete(i);
                i--;
                del++;
            }
        if(del == value)
            JOptionPane.showMessageDialog(new Frame(), "Записей не найдено. Для продолжения работы нажмите \"ОК\"");
        return del;
    }

}
