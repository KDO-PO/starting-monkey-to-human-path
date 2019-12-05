package PO74.karpova.wdad.learn.xml.rmi;


import PO74.karpova.wdad.learn.xml.Department;
import PO74.karpova.wdad.learn.xml.Employee;
import PO74.karpova.wdad.learn.xml.JobTitle;

import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface XmlDataManager extends Remote
{
     double salaryAverage () throws RemoteException, XPathExpressionException;// – возвращает среднюю заработную платусотрудников организации.
     double salaryAverage (String departmentName) throws RemoteException, XPathExpressionException;// – возвращает среднююзаработную плату сотрудников заданного департамента.
     void setJobTitle (String firstName, String secondName, String newJobTitle) throws IOException, TransformerException;// –изменяет должность сотрудника.
     void setSalary (String firstName, String secondName, int newSalary) throws IOException,TransformerException;// – изменяетразмер заработной платы сотрудника.
     void fireEmployee (String fname, String  sname) throws  TransformerException,RemoteException;// – удаляющий информациюо сотруднике.
     void add (String department) throws IOException; //– добавляющий информацию одепартаменте. Если такой департамент уже

}