package gontsov;

public class DoublyLinkedList {
    class Link {
        public Link next;
        public Link previous;
        public int val;

        public Link(int val) {
            this.val = val;
        }

        public void displayLink() {
            System.out.print("{" + val + "}");
        }
    }

    public Link first;
    public Link last;

    public void addStart(int val) {
        Link newLink = new Link(val);
        if (first == null)
            last = newLink;
        else
            first.previous = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void addEnd(int val) {
        Link newLink = new Link(val);
        if (first == null) {
            last = newLink;
        } else {
            newLink.previous = last;
            last.next = newLink;
        }
        last = newLink;
    }

    public Link delStart() {
        Link temp = first;
        if (first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        return temp;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Link deleteLast() {
        Link temp = last;
        if (first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp;
    }

    public void displayForward() {
        Link current = first;
        System.out.print("List (first-->last): ");
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void displayBackward() {
        Link current = last;
        System.out.print("List (last-->first): ");
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println("");
    }

    public boolean insertAfter(int key, int val) {
        Link current = first;
        while (current.val != key) {
            current = current.next;
            if (current == null)
                return false;
        }

        Link newLink = new Link(val);
        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            current.next.previous = newLink;
            newLink.next = current.next;
        }

        newLink.previous = current;
        current.next = newLink;

        return true;
    }

    public Link deleteKey(int key) {
        Link current = first;
        while (current.val != key) {
            current = current.next;
            if (current == null)
                return null;
        }

        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }


        return current;
    }
}
