/*
 * Copyright (c) Thomas Robbins, Schuyler Goodwin, Miles Camp, Evan Walmer March 1, 2014
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Bubble;
import beans.User;

public class Account {
    private Connection conn;

    public Account(Connection conn) {
        this.conn = conn;
    }

    public void create(String username, String email, String password)
                                                                      throws SQLException {
        String sql = "insert into user_table (username, email, password) values (?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, username);
        stmt.setString(2, email);
        stmt.setString(3, password);

        stmt.executeUpdate();

        stmt.close();
    }

    public boolean emailExists(String email) throws SQLException {
        String sql = "select count(*) as count from user_table where email=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, email);

        ResultSet rs = stmt.executeQuery();

        int count = 0;

        if (rs.next()) {
            count = rs.getInt("count");
        }

        rs.close();
        stmt.close();

        if (count == 0) {
            return false;
        } else {
            return true;
        }

    }

    public boolean usernameExists(String username) throws SQLException {
        String sql = "select count(*) as count from user_table where email=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();

        int count = 0;

        if (rs.next()) {
            count = rs.getInt("count");
        }

        rs.close();
        stmt.close();

        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean login(String username, String password) throws SQLException {

        String sql = "select count(*) as count from user_table where username=? and password=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, username);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();

        int count = 0;

        if (rs.next()) {
            count = rs.getInt("count");
        }

        rs.close();
        stmt.close();

        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }

    public User getUser(String username) throws SQLException {
        String sql = "select * from user_table where username=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();

        User user = null;

        if (rs.next()) {
            String email = rs.getString("email");
            String password = rs.getString("password");
            String github = rs.getString("github");
            String picture = rs.getString("picture");
            String personalWeb = rs.getString("personal_site");

            user = new User(username, email, password, github, picture,
                            personalWeb);

        }
        rs.close();
        stmt.close();
        return user;

    }

    public Bubble getBubble(String bname) throws SQLException {

        String sql = "select summary, title, date, username as author, name "
            + "as hack from idea AS i join hackathon AS h "
            + "on (i.hack_id = h.hackathon_id) join user_table AS u "
            + "on (i.user_id = u.user_id) where title=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, bname);

        ResultSet rs = stmt.executeQuery();

        Bubble b = null;

        if (rs.next()) {
            String title = rs.getString("title");
            String summary = rs.getString("summary");
            String author = rs.getString("author");
            String hack = rs.getString("hack");
            String date = rs.getTimestamp("date").toGMTString();
            b = new Bubble(title, summary, date, hack, author);
        }

        rs.close();
        stmt.close();
        return b;

    }

    public ArrayList<Bubble> getSubBubbles(String parentTitle)
                                                              throws SQLException {

        String sql = "select ii.title, ii.summary, "
            + "ii.date, h.name as hack, u.username as author"
            + "from idea AS i join idea_association as ia "
            + "on (i.idea_id = ia.parent_id) "
            + "join idea as ii on (ia.child_id = ii.idea_id) "
            + "join hackathon AS h on (ii.hack_id = h.hackathon_id) "
            + "join user_table AS u on (ii.user_id = u.user_id) "
            + "where i.title=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, parentTitle);

        ResultSet rs = stmt.executeQuery();

        ArrayList<Bubble> subBubbles = new ArrayList<>();

        if (rs.next()) {
            String title = rs.getString("title");
            String summary = rs.getString("summary");
            String author = rs.getString("author");
            String hack = rs.getString("hack");
            String date = rs.getTimestamp("date").toGMTString();
            Bubble b = new Bubble(title, summary, date, hack, author);
            subBubbles.add(b);

        }

        rs.close();
        stmt.close();

        if (subBubbles.size() > 0) {
            return subBubbles;
        } else {
            return null;
        }

    }
}
