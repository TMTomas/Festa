package pt.tpsi.festa.contactos.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.brunojesus.contactslib.model.Contact;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WriteandReadJsonTest {
	private WriteandReadJson writeandReadJson;
	private List<Contact> testContactList;

	@BeforeEach
	public void setUp() {
		writeandReadJson = new WriteandReadJson();
		testContactList = new ArrayList<>();

		// Create some test contacts
		Contact contact1 = new Contact().setFirstName("John").setLastName("Doe").setEmail("john.doe@example.com")
				.setPhoneNumber("123456789");

		Contact contact2 = new Contact().setFirstName("Jane").setLastName("Smith").setEmail("jane.smith@example.com")
				.setPhoneNumber("987654321");

		testContactList.add(contact1);
		testContactList.add(contact2);
	}

	@Test
	public void testWriteListOnFile() {
		String filePath = "contactList.json";

		// Write the test contact list to file
		writeandReadJson.writeListOnFile(testContactList);

		// Check if the file exists
		File file = new File(filePath);
		assertTrue(file.exists());

		// Delete the file after the test
		file.delete();
	}

	@Test
	public void testReadFiletoList() {
		// Write the test contact list to file
		writeandReadJson.writeListOnFile(testContactList);

		// Read the contact list from file
		List<Contact> readContactList = writeandReadJson.readFiletoList(new ArrayList<>());

		// Check if the read contact list matches the original test contact list
		assertEquals(testContactList.size(), readContactList.size());
		for (int i = 0; i < testContactList.size(); i++) {
			Contact expectedContact = testContactList.get(i);
			Contact actualContact = readContactList.get(i);
			assertEquals(expectedContact.getFirstName(), actualContact.getFirstName());
			assertEquals(expectedContact.getLastName(), actualContact.getLastName());
			assertEquals(expectedContact.getEmail(), actualContact.getEmail());
			assertEquals(expectedContact.getPhoneNumber(), actualContact.getPhoneNumber());
		}

		// Delete the file after the test
		File file = new File("contactList.json");
		assertTrue(file.delete());
	}
}
