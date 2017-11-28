package com.example.guestbook;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import com.example.guestbook.Greeting;
import com.example.guestbook.Guestbook;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

public class GreetingResource extends ServerResource {

	@Get("xml")
	public String represent() {
		Key<Guestbook> theBook = Key.create(Guestbook.class, "default");
		long id = Long.parseLong(getAttribute("id"));
		// we can also write to stderr
		System.err.println("Getting object with Id " + id);
		Greeting greeting;
		greeting = ObjectifyService.ofy().load().type(Greeting.class).parent(theBook).id(id).now();
		if (greeting == null) {
			return "<error>No such greeting</error>";
		}
		String ret = "";
		ret += "<greeting>\n";
		ret += "<id>" + greeting.id + "</id>\n";
		ret += "<author>" + greeting.author_id + "</author>\n";
		ret += "<email>" + greeting.author_email + "</email>\n";
		ret += "<content>" + greeting.content + "</content>\n";
		ret += "<date>" + greeting.date + "</date>\n";
		ret += "</greeting>";
		return ret;
	}
}