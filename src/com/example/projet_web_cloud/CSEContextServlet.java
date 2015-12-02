package com.example.projet_web_cloud;

import java.io.*;
import javax.servlet.http.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class CSEContextServlet extends HttpServlet {

	private static final long serialVersionUID = -4740726131262354698L;
	private Document CSEContext;
	
	public CSEContextServlet() {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			CSEContext = builder.parse(new File("CSEContext.xml"));
		} catch (Exception e) { 
		}
	}
	
	private String documentToString() {
		try {
			DOMSource domSource = new DOMSource(CSEContext);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			return writer.toString();
		} catch (Exception e) {
			return "toto";
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/xml;charset=UTF-8");
	  	resp.getWriter().println(documentToString());
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String disabilitie = req.getParameter("disabilitie");
		Element nodeLabel = CSEContext.createElement("Label");
		nodeLabel.setAttribute("name", disabilitie);
		nodeLabel.setAttribute("mode", "BOOST");
		Node nodeBackgroundLabels = CSEContext.getElementsByTagName("BackgroundLabels").item(0);
		nodeBackgroundLabels.appendChild(nodeLabel);
		
		resp.setContentType("text/xml;charset=UTF-8");
	  	resp.getWriter().println(documentToString());
	}
	
}
