/**
 * Bubble.java 1.0 Mar 1, 2014
 * 
 * Copyright (c) 2014 Miles Camp, Schuyler K. Goodwin, Thomas Robbins, Evan Walmer
 *  All Rights Reserved
 */
package beans;

import java.util.ArrayList;

public class BubbleBean {
    private Bubble parent = null;
    private ArrayList<Bubble> children = new ArrayList<>();

    public BubbleBean() {

    }

    /**
     * @param aParent
     * @param aChildren
     */
    public BubbleBean(Bubble aParent, ArrayList<Bubble> aChildren) {
        super();
        parent = aParent;
        children = aChildren;
    }

    public Bubble getParent() {
        return parent;
    }

    public void setParent(Bubble aParent) {
        parent = aParent;
    }

    public ArrayList<Bubble> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Bubble> aChildren) {
        children = aChildren;
    }

}
