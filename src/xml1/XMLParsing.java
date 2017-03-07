package xml1;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParsing {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://demo.cyberdigm.co.kr:2017/userInfo.xml");
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
        NodeList nodes = doc.getElementsByTagName("node");

        for(int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.printf("%s\n", node.getNodeName());
            NodeList items = node.getChildNodes();
            for (int j = 0; j < items.getLength(); ++j) {
                Node item = items.item(j);
                System.out.printf("-- %s\n", item.getNodeName());
                if (item.getNodeName().equals("item") == false) continue;
                NamedNodeMap attrs = item.getAttributes();
                for (int k = 0; k < attrs.getLength(); ++k) {
                    Node attr = attrs.item(k);
                    System.out.printf("---- %s %s\n", attr.getNodeName(), attr.getNodeValue());
                }
            }
        }
    }

}