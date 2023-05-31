package pt.tpsi.festa.contactos.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.brunojesus.contactslib.model.Contact;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de teste para a classe WriteandReadJson.
 * 
 * 
 * @author Diogo Carvalho, Francisco Simões, Tomás Monteiro
 * @version 1.0.0
 * @since 26-05-2023
 */
public class WriteandReadJsonTest {
	private WriteandReadJson writeandReadJson;
	private List<Contact> testContactList;

	/**
	 * Configuração inicial antes de cada teste.
	 */
	@BeforeEach
	public void setUp() {
		writeandReadJson = new WriteandReadJson();
		testContactList = new ArrayList<>();

		Contact contact1 = new Contact().setFirstName("Joao").setLastName("Leonardo")
				.setEmail("joao.leonardo@example.com").setPhoneNumber("123456789");

		Contact contact2 = new Contact().setFirstName("Hugo").setLastName("Simao").setEmail("hugo.simao@example.com")
				.setPhoneNumber("987654321");

		testContactList.add(contact1);
		testContactList.add(contact2);
	}

	/**
	 * Testa o método writeListOnFile.
	 */
	@Test
	public void testWriteListOnFile() {
		String filePath = "contactList.json";

		writeandReadJson.writeListOnFile(testContactList);

		File file = new File(filePath);
		assertTrue(file.exists());

		file.delete();
	}

	/**
	 * Testa o método readFiletoList.
	 */
	@Test
	public void testReadFiletoList() {
		writeandReadJson.writeListOnFile(testContactList);

		List<Contact> readContactList = writeandReadJson.readFiletoList(new ArrayList<>());

		assertEquals(testContactList.size(), readContactList.size());
		for (int i = 0; i < testContactList.size(); i++) {
			Contact expectedContact = testContactList.get(i);
			Contact actualContact = readContactList.get(i);
			assertEquals(expectedContact.getFirstName(), actualContact.getFirstName());
			assertEquals(expectedContact.getLastName(), actualContact.getLastName());
			assertEquals(expectedContact.getEmail(), actualContact.getEmail());
			assertEquals(expectedContact.getPhoneNumber(), actualContact.getPhoneNumber());
		}

		File file = new File("contactList.json");
		assertTrue(file.delete());
	}
}
