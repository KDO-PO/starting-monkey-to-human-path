package PO74.karpova.wdad.resources.configuration;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class PreferencesManager{
    private static PreferencesManager preferencesManager;
    private  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private  DocumentBuilder builder = factory.newDocumentBuilder();
    private  Document document = builder.parse(new File("C:/starting-monkey-to-human-path/src/PO74/karpova/wdad/resources/configuration/appconfig.xml"));
    private  NodeList employeeElements = document.getDocumentElement().getElementsByTagName("employee");
    private XPathFactory xPathFactory = XPathFactory.newInstance();
    private XPath xPath = xPathFactory.newXPath();

    private String createregistry;
    private String registryaddress;
    private String registryport;
    private String policypath;
    private String usecodebaseonly;
    private String classprovider;


    private PreferencesManager() throws ParserConfigurationException, IOException, SAXException {
    }
    @Deprecated
    public static  synchronized   PreferencesManager getPreferencesManager() throws ParserConfigurationException, IOException, SAXException {
        if (preferencesManager==null){
            preferencesManager=new PreferencesManager();
        }
        return preferencesManager;
    }
    @Deprecated
    public String getCreateregistry() throws XPathExpressionException {
        return (String) xPath.evaluate("/appconfig/rmi/server/registry/createregistry", document, XPathConstants.STRING);
    }
    @Deprecated
    public void setCreateregistry(String newCreateregistry) throws TransformerException, XPathExpressionException {
            employeeElements =(NodeList) xPath.evaluate("/appconfig/rmi/server/registry/createregistry", document, XPathConstants.NODESET);
            employeeElements.item(0).setTextContent(newCreateregistry);
            transformer();

    }
    @Deprecated
    public String getRegistryaddress() throws XPathExpressionException {
        registryaddress = (String) xPath.evaluate("/appconfig/rmi/server/registry/registryaddress", document, XPathConstants.STRING);
        return registryaddress;
    }
    @Deprecated
    public void setRegistryaddress(String newRegistryaddress) throws TransformerException, XPathExpressionException {
        employeeElements =(NodeList) xPath.evaluate("/appconfig/rmi/server/registry/registryaddress", document, XPathConstants.NODESET);
        employeeElements.item(0).setTextContent(newRegistryaddress);
        transformer();

    }
    @Deprecated
    public String getRegistryport() throws XPathExpressionException {
        registryport = (String) xPath.evaluate("/appconfig/rmi/server/registry/registryport", document, XPathConstants.STRING);
        return registryport;
    }
    @Deprecated
    public void setRegistryport(int newRegistryport) throws TransformerException, XPathExpressionException {
        employeeElements =(NodeList) xPath.evaluate("/appconfig/rmi/server/registry/registryport", document, XPathConstants.NODESET);
        employeeElements.item(0).setTextContent(Integer.toString(newRegistryport));
        transformer();

    }
    @Deprecated
    public String getPolicypath() throws XPathExpressionException {
        policypath = (String) xPath.evaluate("/appconfig/rmi/client/policypath", document, XPathConstants.STRING);
        return policypath;
    }
    @Deprecated
    public void setPolicypath(String newPolicypath) throws TransformerException, XPathExpressionException {
        employeeElements =(NodeList) xPath.evaluate("/appconfig/rmi/client/policypath", document, XPathConstants.NODESET);
        employeeElements.item(0).setTextContent(newPolicypath);
        transformer();

    }
    @Deprecated
    public String getUsecodebaseonly() throws XPathExpressionException {
        usecodebaseonly = (String) xPath.evaluate("/appconfig/rmi/client/usecodebaseonly", document, XPathConstants.STRING);
        return usecodebaseonly;
    }
    @Deprecated
    public void setUsecodebaseonly(String newUsecodebaseonly) throws TransformerException, XPathExpressionException {
        employeeElements =(NodeList) xPath.evaluate("/appconfig/rmi/client/usecodebaseonly", document, XPathConstants.NODESET);
        employeeElements.item(0).setTextContent(newUsecodebaseonly);
        transformer();

    }
    @Deprecated
    public String getClassprovider() throws XPathExpressionException {
        classprovider = (String) xPath.evaluate("/appconfig/rmi/client/classprovider", document, XPathConstants.STRING);
        return classprovider;
    }
    @Deprecated
    public void setClassprovider(String newClassprovider) throws TransformerException, XPathExpressionException {
        employeeElements =(NodeList) xPath.evaluate("/appconfig/rmi/client/classprovider", document, XPathConstants.NODESET);
        employeeElements.item(0).setTextContent(newClassprovider);
        transformer();

    }
    private void transformer() throws TransformerException {
        TransformerFactory factory1 = TransformerFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        Transformer transformer = factory1.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(document.getDocumentURI()));
    }

    public void setProperty(String key, String value){}

    public String getProperty(String key){return null;}

    public void setProperties(Properties prop){}

    public Properties getProperties(){return null;}

    public void addBindedObject(String name, String className){}

    public void removeBindedObject(String name){}
}
