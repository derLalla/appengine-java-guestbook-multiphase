package com.example.guestbook;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import com.example.guestbook.Greeting;
import com.example.guestbook.Guestbook;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import java.util.List;

public class GuestbookResource extends ServerResource {

	@Get("xml")
	public String represent() {
		Key<Guestbook> theBook = Key.create(Guestbook.class, "default");

		List<Greeting> greetings = ObjectifyService.ofy().load().type(Greeting.class) // We want only Greetings
				.ancestor(theBook) // Anyone in this book
				.order("-date") // Most recent first - date is indexed.
				.list();
		String ret = "";
		ret += "<guestbook xmlns=\"com.example.guestbook\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://localhost:8080/guestbook.xsd\">\n";
		for (Greeting greeting : greetings) {
			ret += "<greeting>\n";
			ret += "<id>" + greeting.id + "</id>\n";
			ret += "<author>" + greeting.author_id + "</author>\n";
			ret += "<email>" + greeting.author_email + "</email>\n";
			ret += "<content>" + greeting.content + "</content>\n";
			ret += "<date>" + greeting.date + "</date>\n";
			ret += "</greeting>";

		}
		ret += "</guestbook>";
		return ret;
	}

}
