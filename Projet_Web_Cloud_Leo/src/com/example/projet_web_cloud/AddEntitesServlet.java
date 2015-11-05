package com.example.projet_web_cloud;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class AddEntitesServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		for(int i = 0 ; i < 20 ; i++) {
			WebsiteDisabilities monEntite = new WebsiteDisabilities("http://www.toto" + i + ".fr");
			if(i%2 == 0) {
				monEntite.setAnxiety(true);
			}
			try {
	            pm.makePersistent(monEntite);
	        } catch (Exception e) {
	        	pm.close();
	        }
		}

		resp.setContentType("text/plain");
		for(int i = 0 ; i < 20 ; i++) {
			WebsiteDisabilities monEntite = pm.getObjectById(WebsiteDisabilities.class, "http://www.toto" + i + ".fr");
			resp.getWriter().println(monEntite.getUrl() + " Anxiety : " + monEntite.getAnxiety());
		}
		pm.close();
	}
	
}
