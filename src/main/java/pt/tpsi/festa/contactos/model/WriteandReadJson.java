package pt.tpsi.festa.contactos.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pt.brunojesus.contactslib.model.Contact;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteandReadJson {
    private ObjectMapper objectMapper;
    private List<Contact> contactList;
    private File filePath;

    public WriteandReadJson() {
        objectMapper = new ObjectMapper();
        contactList = new ArrayList<>();
        filePath = new File("contactList.json");
    }

    public void writeListOnFile(){
        try {
            objectMapper.writeValue(filePath, contactList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void readFiletoList(){
        try {
            if(!filePath.exists()){
                writeListOnFile();
            }
            contactList = objectMapper.readValue(filePath, new TypeReference<List<Contact>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
