package Controller;

import Model.Student;
import View.MyFrame;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

    StudentController controller;
    MyFrame frame;
    String element = "";
    Student student;

    boolean bSurName = false;
    boolean bFirstName = false;
    boolean bMiddleName = false;
    boolean bBirthday = false;
    boolean bReceipt = false;
    boolean bExpiration = false;

    public Handler(StudentController controller, MyFrame frame)
    {
        this.controller = controller;
        this.frame = frame;
    }

    @Override
    public void startDocument() throws SAXException {
        controller.deleteAllStudent();
    }

    @Override
    public void endDocument()throws SAXException{
        frame.generationTable();
    }

    public void startElement(String namespace, String localname, String qName, Attributes attributes)
    {
        if (qName.equals("student")){
            student = new Student();
        }
        if(qName.equals("surname")) {
            bSurName = true;
        }
        if(qName.equals("firstname")) {
            bFirstName = true;
        }
        if(qName.equals("middlename")) {
            bMiddleName = true;
        }
        if(qName.equals("dateBirthday")) {
            bBirthday = true;
        }
        if(qName.equals("dateReceipt")) {
            bReceipt = true;
        }
        if(qName.equals("dateExpiration")) {
            bExpiration = true;
        }
    }

    public void endElement(String namespace, String localname, String qName) throws SAXException
    {
        element = "";
        if(qName.equals("student")) {
            controller.addStudent(student);
        }
    }

    public void characters(char []ch, int start, int end)
    {
        if(bSurName)
        {
            student.setSurName(new String(ch, start, end));
            bSurName = false;
        }
        else if(bFirstName)
        {
            student.setFirstName(new String(ch, start, end));
            bFirstName = false;
        }
        else if(bMiddleName)
        {
            student.setMiddleName(new String(ch, start, end));
            bMiddleName = false;
        }
        else if(bBirthday)
        {
            student.setDateBirthday(new String(ch, start, end));
            bBirthday = false;
        }
        else if(bReceipt)
        {
            student.setDateReceipt(new String(ch, start, end));
            bReceipt = false;
        }
        else if(bExpiration)
        {
            student.setDateExpiration(new String(ch, start, end));
            bExpiration = false;
        }
    }
}

