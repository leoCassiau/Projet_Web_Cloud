package com.example.projet_web_cloud;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class CSEAnnotationsServlet extends HttpServlet {

	private static final long serialVersionUID = -4740726131262354698L;
	private Document CSEAnnotations;
	
	public CSEAnnotationsServlet() throws ParserConfigurationException {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		CSEAnnotations = builder.newDocument();
	}
	
	private static String documentToString(Document doc) throws TransformerException {
		// Code trouvé sur le net. Ca à l'air de marcher
		DOMSource domSource = new DOMSource(doc);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(domSource, result);
		return writer.toString();
	}
	
	private void createCSEAnnotations(String disabilitie, List<String> urls) {
		// <Annotations>
		Element nodeAnnotations = CSEAnnotations.createElement("Annotations");
		CSEAnnotations.appendChild(nodeAnnotations);
		
		for(String url : urls) {
			//	<Annotation about="url">
			Element nodeAnnotation = CSEAnnotations.createElement("Annotation");
			nodeAnnotation.setAttribute("about", url);
			nodeAnnotations.appendChild(nodeAnnotation);
			//		<Label name="disabilitie"/>
			Element nodeLabel = CSEAnnotations.createElement("Label");
			nodeLabel.setAttribute("name", disabilitie);
			nodeAnnotation.appendChild(nodeLabel);
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String disabilitie = req.getParameter("disabilitie");
		WebsiteDisabilitiesEndpoint dataEndpoint = new WebsiteDisabilitiesEndpoint();
		createCSEAnnotations(disabilitie, dataEndpoint.getUrlsByDisabilitie(disabilitie));
		
		resp.setContentType("text/xml;charset=UTF-8");
	  	try {
			resp.getWriter().println(documentToString(CSEAnnotations));
		} catch (TransformerException e) {
			e.printStackTrace();
			resp.getWriter().println(e.getMessage());
		}
	}
}
