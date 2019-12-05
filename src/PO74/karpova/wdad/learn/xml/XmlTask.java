package PO74.karpova.wdad.learn.xml;

import org.jdom2.input.DOMBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XmlTask {
    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder builder = factory.newDocumentBuilder();
    private Document document = builder.parse(new File("C:\\starting-monkey-to-human-path\\src\\PO74\\karpova\\wdad\\learn\\xml\\organizations.xml"));
    private NodeList employeeElements = document.getDocumentElement().getElementsByTagName("employee");
    private XPathFactory xPathFactory = XPathFactory.newInstance();
    private XPath xPath = xPathFactory.newXPath();




    public XmlTask() throws ParserConfigurationException, IOException, SAXException {}


    //возвращает среднюю заработную плату сотрудников организации.
    public double salaryAverage() throws  XPathExpressionException {
        NodeList list = (NodeList) xPath.evaluate("/organization/department/employee/salary", document, XPathConstants.NODESET);
        double summ = 0;
        int count = 0;
        count = Integer.parseInt(xPath.evaluate("count(/organization/department/employee/salary)", document));
        for (int i = 0; i < list.getLength(); i++) {
            summ += Integer.parseInt(list.item(i).getTextContent());
        }
        System.out.println();
        return summ / count;
    }

    //возвращает среднюю заработную плату сотрудников заданного департамента.
    public double salaryAverage(String departmentName) throws  XPathExpressionException {
        NodeList list = (NodeList) xPath.evaluate("/organization/department[@name='" + departmentName + "']/employee/salary", document, XPathConstants.NODESET);
        double summ = 0;
        int count = 0;
        count = Integer.parseInt(xPath.evaluate("count(/organization/department[@name='" + departmentName + "']/employee/salary)", document));
        for (int i = 0; i < list.getLength(); i++) {
            summ += Integer.parseInt(list.item(i).getTextContent());

        }
        return summ / count;
    }

    //изменяет должность сотрудника.
    public void setJobTitile(String firstName, String secondName, String newJobTitle) throws  TransformerException {
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Element employee = (Element) employeeElements.item(i);
            if (employee.getAttribute("firstname").equals(firstName)
                    && employee.getAttribute("secondname").equals(secondName)) {
                //System.out.println(employee.getAttribute("firstname") + "   " + employee.getAttribute("secondname"));
                Element jobtitle = (Element) employee.getElementsByTagName("jobtitle").item(0);
                jobtitle.setAttribute("value", newJobTitle);

                transformer();
                return;
            }

        }

    }
    // изменяет размер заработной платы сотрудника.
     public void setSalary(String firstName, String secondName, int newSalary)throws   TransformerException {

         for (int i = 0; i < employeeElements.getLength(); i++) {
             Element employee = (Element) employeeElements.item(i);
             if (employee.getAttribute("firstname").equals(firstName)
                     && employee.getAttribute("secondname").equals(secondName)) {
                 System.out.println(employee.getAttribute("firstname") + "   " + employee.getAttribute("secondname"));
                 Element jobtitle = (Element) employee.getElementsByTagName("salary").item(0);
                 jobtitle.setTextContent(Integer.toString(newSalary));

                 transformer();
                 return;

             }

         }
     }



//удаляющий информацию о сотруднике.
    public void fireEmployee(String firstName, String secondName) throws  TransformerException {
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Element employee = (Element) employeeElements.item(i);
            if (employee.getAttribute("firstname").equals(firstName)
                    && employee.getAttribute("secondname").equals(secondName)) {
                employee.getParentNode().removeChild(employee);
                transformer();
                return;
            }
        }
    }

    //добавить департамент
    public void add(String department) throws IOException {

    }

    private void transformer() throws TransformerException {
        TransformerFactory factory1 = TransformerFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        Transformer transformer = factory1.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(document.getDocumentURI()));
    }

}





