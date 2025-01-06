package dev.sohaib;

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    protected ListItem next() {
        return rightLink;
    }

    @Override
    protected ListItem setNext(ListItem link) {
        rightLink = link;
        return rightLink;
    }

    @Override
    protected ListItem previous() {
        return leftLink;
    }

    @Override
    protected ListItem setPrevious(ListItem link) {
        leftLink = link;
        return leftLink;
    }

    @Override
    protected int compareTo(ListItem item) {
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }
    }


}
