package Controller;

import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Properties;

public class SaveDialog {

    private StudentController controller;
    private File file;

    public SaveDialog(StudentController controller, File file)
    {
        this.file = file;
        this.controller = controller;
    }

    public void save(){

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        org.w3c.dom.Document document = documentBuilder.newDocument();

        Element allstudents = document.createElement("allstudents");

        document.appendChild(allstudents);

        for(int i = 0; i < controller.size(); i++) {
            Element student = document.createElement("student");

            allstudents.appendChild(student);

            String str = controller.get(i).getSurName();

            Element surname = document.createElement("surname");
            surname.appendChild(document.createTextNode(str));
            student.appendChild(surname);

            str = controller.get(i).getFirstName();

            Element firstname = document.createElement("firstname");
            firstname.appendChild(document.createTextNode(str));
            student.appendChild(firstname);

            str = controller.get(i).getMiddleName();

            Element middlename = document.createElement("middlename");
            middlename.appendChild(document.createTextNode(str));
            student.appendChild(middlename);

            str = String.valueOf(controller.get(i).getDateBirthday());

            Element dateBirthday = document.createElement("dateBirthday");
            dateBirthday.appendChild(document.createTextNode(str));
            student.appendChild(dateBirthday);

            str = String.valueOf(controller.get(i).getDateReceipt());

            Element dateReceipt = document.createElement("dateReceipt");
            dateReceipt.appendChild(document.createTextNode(str));
            student.appendChild(dateReceipt);

            str = String.valueOf(controller.get(i).getDateExpiration());

            Element dateExpiration = document.createElement("dateExpiration");
            dateExpiration.appendChild(document.createTextNode(str));
            student.appendChild(dateExpiration);

            TransformerFactory factory1 = TransformerFactory.newInstance();
            try {
                Transformer transformer = factory1.newTransformer();

                Properties outFormat = new Properties();
                outFormat.setProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperties(outFormat);

                DOMSource domSource = new DOMSource(document);
                StreamResult streamFile = new StreamResult(file);
                transformer.transform(domSource, streamFile);

            } catch (TransformerException e) {
                e.printStackTrace();
            }
        }
    }
}

