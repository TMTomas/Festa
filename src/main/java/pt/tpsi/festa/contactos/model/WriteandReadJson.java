package pt.tpsi.festa.contactos.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pt.brunojesus.contactslib.model.Contact;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteandReadJson {
    private final ObjectMapper objectMapper;
    private List<Contact> contactList;
    private final File filePath;

    public WriteandReadJson() {
        objectMapper = new ObjectMapper();
        contactList = new ArrayList<>();
        filePath = new File("contactList.json");
    }

    public void writeListOnFile(List<Contact> list){
        try {
            objectMapper.writeValue(filePath, list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Contact> readFiletoList(List<Contact> list){
        try {
            if(!filePath.exists()){
                writeListOnFile(list);
            }
            return contactList = objectMapper.readValue(filePath, new TypeReference<List<Contact>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
		}
	}
}
