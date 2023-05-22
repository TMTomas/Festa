package pt.tpsi.festa.contactos;

<<<<<<< HEAD
=======
import pt.brunojesus.contactslib.model.Contact;


>>>>>>> 9f1a02d9a9174b36d65b134243bdf833e24cd1db
import java.util.ArrayList;

public interface ContactInterface {

	// lista os contactos
<<<<<<< HEAD
	public void listarContactos();
=======
	public List<String> listarContactos(List<Contact> Contactos);
>>>>>>> 9f1a02d9a9174b36d65b134243bdf833e24cd1db

	// Lista os contactos
	public List<String> listarConvidados(List<ConvidadosList> contactos);

	// Convida a partir do índice do ArrayList
	public void convidar(int index);

	// Desconvida a partir do índice do ArrayList
	public void desconvidar(int index);

}