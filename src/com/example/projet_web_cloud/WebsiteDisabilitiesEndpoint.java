package com.example.projet_web_cloud;

import com.example.projet_web_cloud.PMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "websitedisabilitiesendpoint", namespace = @ApiNamespace(ownerDomain = "example.com", ownerName = "example.com", packagePath = "projet_web_cloud") )
public class WebsiteDisabilitiesEndpoint {
	
	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listWebsiteDisabilities")
	public CollectionResponse<WebsiteDisabilities> listWebsiteDisabilities(
			@Nullable @Named("cursor") String cursorString, @Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<WebsiteDisabilities> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(WebsiteDisabilities.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<WebsiteDisabilities>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (WebsiteDisabilities obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<WebsiteDisabilities> builder().setItems(execute).setNextPageToken(cursorString)
				.build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getWebsiteDisabilities")
	public WebsiteDisabilities getWebsiteDisabilities(@Named("id") String id) {
		PersistenceManager mgr = getPersistenceManager();
		WebsiteDisabilities websitedisabilities = null;
		try {
			websitedisabilities = mgr.getObjectById(WebsiteDisabilities.class, id);
		} finally {
			mgr.close();
		}
		return websitedisabilities;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param websitedisabilities the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertWebsiteDisabilities")
	public WebsiteDisabilities insertWebsiteDisabilities(WebsiteDisabilities websitedisabilities) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsWebsiteDisabilities(websitedisabilities)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.makePersistent(websitedisabilities);
		} finally {
			mgr.close();
		}
		return websitedisabilities;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param websitedisabilities the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateWebsiteDisabilities")
	public WebsiteDisabilities updateWebsiteDisabilities(WebsiteDisabilities websitedisabilities) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsWebsiteDisabilities(websitedisabilities)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(websitedisabilities);
		} finally {
			mgr.close();
		}
		return websitedisabilities;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeWebsiteDisabilities")
	public void removeWebsiteDisabilities(@Named("id") String id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			WebsiteDisabilities websitedisabilities = mgr.getObjectById(WebsiteDisabilities.class, id);
			mgr.deletePersistent(websitedisabilities);
		} finally {
			mgr.close();
		}
	}

	private boolean containsWebsiteDisabilities(WebsiteDisabilities websitedisabilities) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(WebsiteDisabilities.class, websitedisabilities.getUrl());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}
	
	// Mes méthodes
	@SuppressWarnings("unchecked")
	@ApiMethod(name="listUrlsByDisabilitie")
	public List<String> getUrlsByDisabilitie(@Named("Disabilitie") String disabilitie) {
		disabilitie = disabilitie.toLowerCase();
		disabilitie = disabilitie.replaceFirst(".",(disabilitie.charAt(0)+"").toUpperCase());
		PersistenceManager mgr = null;
		List<WebsiteDisabilities> execute = null;
		List<String> result = new ArrayList<String>();

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(WebsiteDisabilities.class);
			query.setFilter(disabilitie + "== true");
			execute = (List<WebsiteDisabilities>) query.execute();
			for (WebsiteDisabilities obj : execute) {
				result.add(obj.getUrl());
			}
		}
		finally {
			mgr.close();
		}
		return result;
	}

}
