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

		final ContactApi contactApi = new ContactApi();
		long start = System.currentTimeMillis();
		List<Contact> l2 = contactApi.generateContacts(10);

		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.printf("Generating %s contacts took %sms\n", l2.size(), timeElapsed);
	}

}
