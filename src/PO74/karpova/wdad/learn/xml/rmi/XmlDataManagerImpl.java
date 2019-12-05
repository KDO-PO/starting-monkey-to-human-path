package PO74.karpova.wdad.learn.xml.rmi;

import PO74.karpova.wdad.learn.xml.Department;
import PO74.karpova.wdad.learn.xml.Employee;
import PO74.karpova.wdad.learn.xml.JobTitle;
import PO74.karpova.wdad.learn.xml.XmlTask;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class XmlDataManagerImpl implements XmlDataManager {

    XmlTask xmlTask;
    public XmlDataManagerImpl() throws ParserConfigurationException, SAXException, IOException
    {
        xmlTask = new XmlTask();
    }

    @Override
    public double salaryAverage() throws XPathExpressionException {
        return xmlTask.salaryAverage();
    }

    @Override
    public double salaryAverage(String departmentName) throws XPathExpressionException {
        return xmlTask.salaryAverage(departmentName);
    }

    @Override
    public void setJobTitle(String firstName, String secondName, String newJobTitle) throws TransformerException {
        xmlTask.setJobTitile(firstName,secondName,newJobTitle);
    }

    @Override
    public void setSalary(String firstName, String secondName, int newSalary) throws TransformerException {
        xmlTask.setSalary(firstName,secondName,newSalary);
    }

    @Override
    public void fireEmployee(String fname, String sname) throws  TransformerException {
        xmlTask.fireEmployee(fname, sname);
    }

    @Override
    public void add(String department) throws IOException {
        xmlTask.add(department);
    }


}
