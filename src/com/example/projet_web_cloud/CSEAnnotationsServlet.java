package com.example.projet_web_cloud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CSEAnnotationsServlet extends HttpServlet {

	private static final long serialVersionUID = -4740726131262354698L;
	private Document CSEAnnotations;
	private String disabilitie = "anxiety";
	
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
	
	private void createCSEAnnotations(String disabilitie, List<String> urls) throws ParserConfigurationException {
		if(CSEAnnotations.hasChildNodes()) {
			CSEAnnotations = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		}
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
	
	private List<String> getUrlsByDisabilitie(String disabilitie) throws MalformedURLException, IOException {
		List<String> urls = new ArrayList<String>();
		URL url = new URL("https://1-dot-projet-web-cloud.appspot.com/_ah/api/websitedisabilitiesendpoint/v1/stringcollection/"+disabilitie);
	    URLConnection uc = url.openConnection();
	    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
	    String inputLine;
	
	    while ((inputLine = in.readLine()) != null) {
	    	if(inputLine.startsWith("  \"http")) {
	    		urls.add(inputLine.substring(inputLine.indexOf('"')+1, inputLine.lastIndexOf('"')));
	        }
	    }
		in.close();
		return urls;
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	  	try {
	  		List<String> urls = this.getUrlsByDisabilitie(disabilitie);
			createCSEAnnotations(disabilitie, urls);

			resp.setContentType("text/xml;charset=UTF-8");
			resp.getWriter().println(documentToString(CSEAnnotations));
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		disabilitie = req.getParameter("disabilitie");
	}

}
