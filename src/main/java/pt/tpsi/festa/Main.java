package pt.tpsi.festa;

import java.util.List;

import java.util.concurrent.ForkJoinPool;

import pt.brunojesus.contactslib.ContactApi;
import pt.brunojesus.contactslib.model.Contact;

public class Main {

	public static void main(String[] args) {

		System.out.println("IntStream");
		System.out.println("Has " + Runtime.getRuntime().availableProcessors() + " processors");
		System.out.println("Will use " + ForkJoinPool.commonPool().getParallelism() + " processors");

		final ContactApi contact = new ContactApi();

		long start = System.currentTimeMillis();
		List<Contact> l1 = contact.generateContacts(100);

		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;

		System.out.printf("Generating %s contacts to invite took %sms\n", l1.size(), timeElapsed);

	}

}
