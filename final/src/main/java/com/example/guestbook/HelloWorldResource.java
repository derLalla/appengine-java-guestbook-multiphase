package com.example.guestbook;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Resource which has only one representation.
 *
 */
public class HelloWorldResource extends ServerResource {

	@Get("xml")
	public String represent() {
		String example = "";
		example += "<?xml version=\"1.0\"?>\n";
		example += "<greeting xmlns=\"com.example.guestbook\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://localhost:8080/greeting.xsd\">\n";

		example += "<id>5</id>\n";
		example += "<author>John Doe</author>\n";
		example += "<email>john.doe@example.com</email>\n";
		example += "<content>I did not really like the site, it needs more cats!</content>\n";
		example += "<date>2015-10-27</date>\n";
		example += "</greeting>";
		return example;
	}

}
