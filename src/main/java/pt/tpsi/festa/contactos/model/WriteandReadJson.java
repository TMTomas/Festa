package pt.tpsi.festa.contactos.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pt.brunojesus.contactslib.model.Contact;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por escrever e ler uma lista de contactos em um arquivo
 * JSON.
 * 
 * 
 * @author Diogo Carvalho, Francisco Simões, Tomás Monteiro
 * @version 1.0.0
 * @since 26-05-2023
 */
public class WriteandReadJson {
	private final ObjectMapper objectMapper;
	private final File filePath;

	/**
	 * Construtor da classe WriteandReadJson.
	 */
	public WriteandReadJson() {
		objectMapper = new ObjectMapper();
		new ArrayList<>();
		filePath = new File("contactList.json");
	}

	/**
	 * Escreve uma lista de contactos em um arquivo JSON.
	 *
	 * @param list A lista de contactos a ser escrita.
	 */
	public void writeListOnFile(List<Contact> list) {
		try {
			objectMapper.writeValue(filePath, list);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Lê um arquivo JSON e retorna uma lista de contactos. Se o arquivo não
	 * existir, ele será criado e uma lista vazia será retornada.
	 *
	 * @param list A lista de contactos inicial (caso o arquivo não exista).
	 * @return A lista de contactos lida do arquivo.
	 */
	public List<Contact> readFiletoList(List<Contact> list) {
		try {
			if (!filePath.exists()) {
				writeListOnFile(list);
			}
			return objectMapper.readValue(filePath, new TypeReference<List<Contact>>() {
			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
