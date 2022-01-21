package model;

import java.util.HashMap;
import java.util.Map;

public class Bulletin {
    private String header;
    private String text;
    private int id;
    private HashMap<String, String> personList;


    public Bulletin(String header, String text) {
        this.header = header;
        this.text = text;
        personList = new HashMap<>();
    }

    public String getHeader() {
        return header;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addToList(String name, String action) {
        personList.put(name, action);
    }

    public boolean checkPerson(String name) {
        boolean checkPerson = false;
        for (Map.Entry<String, String> entry : personList.entrySet()) {
            if (entry.getKey().equals(name)) {
                checkPerson = true;
                break;
            }
        }
        return checkPerson;
    }

    public void changeValue(String name, String action) {
        for (Map.Entry<String, String> entry : personList.entrySet()) {
            if (entry.getKey().equals(name)) {
                entry.setValue(action);
                break;
            }
        }
    }

    public int getLikes() {
        int likes = 0;
        for (Map.Entry<String, String> entry : personList.entrySet()) {
            if (entry.getValue().equals("like")) {
                likes++;
            }
        }
        return likes;
    }

    public int getDislikes() {
        int dislikes = 0;
        for (Map.Entry<String, String> entry : personList.entrySet()) {
            if (entry.getValue().equals("dislike")) {
                dislikes++;
            }
        }
        return dislikes;
    }

    public String getValue(String name) {
        for (Map.Entry<String, String> entry : personList.entrySet()) {
            if (entry.getKey().equals(name)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
