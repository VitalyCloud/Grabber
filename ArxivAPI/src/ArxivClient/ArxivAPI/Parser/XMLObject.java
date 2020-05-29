package ArxivClient.ArxivAPI.Parser;



import ArxivClient.ArxivAPI.Parser.XMLObjectExceptions.NodeInitException;
import org.w3c.dom.*;
import java.util.ArrayList;

public class XMLObject {
    private Element element;
    private NodeList childNodes;
    private NamedNodeMap attributes;

    public XMLObject(Element element) {
        this.element = element;
        if(element!=null) {
            childNodes = element.getChildNodes();
            if(element.hasAttributes())
                attributes = element.getAttributes();
        }
    }

    public XMLObject(Node node) throws Exception {
        if(node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            this.element = element;
            childNodes = element.getChildNodes();
            if(element!= null && element.hasAttributes())
                attributes = element.getAttributes();
        } else {
            throw new NodeInitException();
        }
    }
    public boolean isEmpty() {
        if(element==null)
            return true;
        return false;
    }

    public NamedNodeMap getAttributes() {
        return attributes;
    }

    public NodeList getChildNodes() {
        return childNodes;
    }

    private Node getAttribute(String name) {
        if(attributes!=null) {
            return attributes.getNamedItem(name);
        }
        return null;
    }

    //return attribute value by name
    public String getAttributeValue(String name) {
        Node node = getAttribute(name);
        if(node!= null && node.getNodeType() == Node.ATTRIBUTE_NODE) {
            return node.getNodeValue().trim();
        }
        return "";
    }

    //Return first matched node
    public Node getNode(String name) {
        for(int i=0; i<childNodes.getLength(); i++) {
           Node node = childNodes.item(i);
           if(node.getNodeName().equals(name) && node.getNodeType() == Node.ELEMENT_NODE)
               return node;
        }
        return null;
    }

    public XMLObject getElement(String name) {
        Node node = getNode(name);
        if(node != null) {
            return new XMLObject((Element) node);
        }

        return new XMLObject(null);
    }

    public ArrayList<XMLObject> getElements(String name) {
        ArrayList<XMLObject> elementList = new ArrayList<>();
        for(int i=0; i<childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if(node.getNodeType() == Element.ELEMENT_NODE &&
                    node.getNodeName().equals(name))
                elementList.add(new XMLObject((Element) node));
        }
        return elementList;
    }

    public String getText() {
        if(element!=null)
            return element.getTextContent().trim();

        return "";
    }


}
