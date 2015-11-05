package com.example.projet_web_cloud;

import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.*;

@SuppressWarnings("serial")
public class Projet_Web_CloudServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		Filter filtreAnxiety = new FilterPredicate("Anxiety", FilterOperator.EQUAL, true);
		
		Query q= new Query("WebsiteDisabilities").setFilter(filtreAnxiety);
		PreparedQuery pq = datastore.prepare(q);
		
		for (Entity result : pq.asIterable()) {
				String url = (String) result.toString();
			  	resp.setContentType("text/plain");
			  	resp.getWriter().println(url);
			}
	}
}
