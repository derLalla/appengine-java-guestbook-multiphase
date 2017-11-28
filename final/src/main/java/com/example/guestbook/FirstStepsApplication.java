package com.example.guestbook;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class FirstStepsApplication extends Application {

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/guestbook/", GuestbookResource.class);
		router.attach("/guestbook/{id}", GreetingResource.class);
		return router;
	}
}
