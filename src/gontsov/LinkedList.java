package gontsov;

public class LinkedList {
    class Link {
        public int val;

        public Link(int val) {
            this.val = val;
        }

        public Link next;

        public void displayLink() {
            System.out.print("{" + val + "}");
        }
    }

    public Link first;

    public void insertFirst(int val) {
        Link newLink = new Link(val);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Link find(int val) {
        Link current = first;
        while (current.val != val) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int val) {
        Link current = first;
        Link previous = first;
        while (current.val != val) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }
}
