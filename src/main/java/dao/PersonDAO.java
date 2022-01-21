package dao;

import model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private List<Person> personList;

    public PersonDAO() {
        personList = new ArrayList<>();
        loadFromFile();
    }

    public List<Person> index() {
        return personList;
    }

    private synchronized void loadFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getFileInputStream("/client.txt")));
            String clientInfo;
            while ((clientInfo = bufferedReader.readLine()) != null) {
                String[] tokens = clientInfo.split(":");
                personList.add(new Person(tokens[0], tokens[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream getFileInputStream(String fileName) {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }

}
