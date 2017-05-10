import Controller.StudentController;
import Model.StudentBase;
import View.MyFrame;

import java.awt.*;

public class Main {

    public static void main(String[] args){
        StudentBase studentBase = new StudentBase();
        StudentController studentController = new StudentController(studentBase);
        MyFrame m = new MyFrame("Таблица студентов",new Dimension(600,400), studentController);
        m.init();
    }
}
