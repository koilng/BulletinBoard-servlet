package dao;

import model.Bulletin;

import java.util.ArrayList;
import java.util.List;

public class BulletinDAO {
    private List<Bulletin> bulletinList;

    public BulletinDAO() {
        bulletinList = new ArrayList<>();
    }

    public List<Bulletin> index() {
        return bulletinList;
    }

    public void add(String header, String text) {
        bulletinList.add(new Bulletin(header, text));
    }

    public Bulletin getByID(int ID) {
        return bulletinList.get(ID);
    }
}
