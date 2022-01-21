package view;

import dao.PersonDAO;
import model.Bulletin;

import java.util.List;

public class BoardView {
    public static String getNotAuthPage(List<Bulletin> bulletinList) {
        StringBuilder sb = new StringBuilder();
        sb.append("<a href=\"/phonebook/login\" style=\"color: green; text-decoration: none; border: 2px solid green\">Log in</a>");
        sb.append("<br>\n");
/*        sb.append("<a href=\"/phonebook/friends\" style=\"color: yellow; text-decoration: none; border: 2px solid black\">FRIENDS</a>");
        sb.append("<a href=\"/phonebook/colleagues\" style=\"color: blue; text-decoration: none; border: 2px solid blue\">COLLEAGUES</a>");
        sb.append("<a href=\"/phonebook/family\" style=\"color: purple; text-decoration: none; border: 2px solid purple\">FAMILY</a>\n");*/
        bulletinList.forEach(bulletin -> {
            sb.append("<p>" + bulletin.getHeader() + " : " + bulletin.getText() + "</p>\n");
        });
        return sb.toString();
    }

/*    public static String getFriendsForm(List<Clients> clientsList) {
        StringBuilder sb = new StringBuilder();
        clientsList.forEach(clients -> {
            if (clients.getCategories().contains("friend")) {
                sb.append("<p>" + clients.getName() + " : " + clients.getPhone() + "<p>\n");
            }
        });
        return sb.toString();
    }*/
}
