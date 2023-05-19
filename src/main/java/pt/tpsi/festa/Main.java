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

		final ContactApi contactCon = new ContactApi();
		final ContactApi contactPes = new ContactApi();
		final ContactApi contactObr = new ContactApi();
		final ContactApi contactEmp = new ContactApi();

		long start = System.currentTimeMillis();
		List<Contact> l1 = contactCon.generateContacts(75);
		List<Contact> l2 = contactPes.generateContacts(10);
		List<Contact> l3 = contactObr.generateContacts(5);
		List<Contact> l4 = contactEmp.generateContacts(2);

		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;

		System.out.printf("Generating %s contacts to invite took %sms\n", l1.size(), timeElapsed);
		System.out.printf("Generating %s personal contacts took %sms\n", l2.size(), timeElapsed);
		System.out.printf("Generating %s necessary contacts took %sms\n", l3.size(), timeElapsed);
		System.out.printf("Generating %s business contacts took %sms\n", l4.size(), timeElapsed);

	}

}
