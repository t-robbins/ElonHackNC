/**
 * Bubble.java 1.0 Mar 1, 2014
 * 
 * Copyright (c) 2014 Miles Camp, Schuyler K. Goodwin, Thomas Robbins, Evan Walmer
 *  All Rights Reserved
 */
package beans;

public class Bubble {
    private String title = "";
    private String summary = "";
    private String date = "";
    private String hackathon = "";
    private String author = "";

    public Bubble() {
    }

    /**
     * @param aTitle
     * @param aSummary
     * @param aDate
     * @param aHackathon
     */
    public Bubble(String aTitle, String aSummary, String aDate,
                  String aHackathon, String aAuthor) {
        super();
        title = aTitle;
        summary = aSummary;
        date = aDate;
        hackathon = aHackathon;
        author = aAuthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String aTitle) {
        title = aTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String aSummary) {
        summary = aSummary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String aDate) {
        date = aDate;
    }

    public String getHackathon() {
        return hackathon;
    }

    public void setHackathon(String aHackathon) {
        hackathon = aHackathon;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String aAuthor) {
        author = aAuthor;
    }

}
