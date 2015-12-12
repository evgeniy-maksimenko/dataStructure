package gontsov;

public class DoublyLinkedList implements EList {
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
            first = newLink;
        } else {
            newLink.previous = last;
            last.next = newLink;
        }
        last = newLink;
    }

    @Override
    public void addPos(int pos, int val) {
        int k = 0;
        Link current = first;
        Link newLink = new Link(val);
        if(pos == 0) {
            addStart(val);
        }
        while (current != null && pos != 0) {
            if (pos == k) {
                current.previous.next = newLink;
                newLink.next = current;
                newLink.previous = current.previous;
                current.previous = newLink;
            }
            k++;
            current = current.next;
        }
    }

    public int delStart() {
        if (isEmpty())
            throw new IllegalArgumentException();
        Link temp = first;
        if (first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        return temp.val;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int delEnd() {

        if (isEmpty())
            throw new IllegalArgumentException();
        Link temp = last;
        if (first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp.val;
    }

    @Override
    public int delPos(int pos) {
        if (isEmpty())
            throw new IllegalArgumentException();

        int k = 0;
        int res = get(pos);
        Link current = first;
        if(pos == k) {
            delStart();
        }
        if(pos == size() - 1) {
            delEnd();
        }
        while (current != null && pos != 0) {
            if(k == pos)
            {
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
            k++;
            current = current.next;
        }

        return res;
    }

    @Override
    public int size() {
        int i = 0;
        Link current = first;
        while (current != null) {
            current = current.next;
            i++;
        }
        return i;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public void init(int[] ini) {
        clear();
        for (int i = ini.length - 1; i >= 0; i--) {
            addStart(ini[i]);
        }
    }

    @Override
    public int[] toArray() {
        AList0 list = new AList0();
        Link current = first;
        while (current != null) {
            list.addEnd(current.val);
            current = current.next;
        }
        return list.toArray();
    }

    @Override
    public void set(int pos, int val) {

        if (isEmpty())
            throw new IllegalArgumentException();


        int res = 0;
        int k = 0;
        Link current = first;
        while (current != null) {
            if (k == pos) {
                current.val = val;
                return;
            }

            k++;
            current = current.next;
        }

    }

    @Override
    public int get(int pos) {

        if (isEmpty())
            throw new IllegalArgumentException();

        int res = 0;
        int k = 0;
        Link current = first;
        while (current != null) {
            if (k == pos)
                res = current.val;
            k++;
            current = current.next;
        }
        return res;
    }

    @Override
    public int min() {
        if (isEmpty())
            throw new IllegalArgumentException();

        Link current = first;
        int min = current.val;
        while (current != null) {
            if (min > current.val)
                min = current.val;
            current = current.next;
        }

        return min;
    }

    @Override
    public int max() {
        if (isEmpty())
            throw new IllegalArgumentException();

        Link current = first;
        int max = current.val;
        while (current != null) {
            if (max < current.val)
                max = current.val;
            current = current.next;
        }

        return max;
    }

    @Override
    public int minIndex() {
        if (isEmpty())
            throw new IllegalArgumentException();

        Link current = first;
        int min = current.val;
        int k = 0;
        int minIndex = k;
        while (current != null) {
            if (min > current.val){
                min = current.val;
                minIndex = k;
            }
            k++;
            current = current.next;
        }


        return minIndex;
    }

    @Override
    public int maxIndex() {
        if (isEmpty())
            throw new IllegalArgumentException();

        Link current = first;
        int max = current.val;
        int k = 0;
        int maxIndex = k;
        while (current != null) {
            if (max < current.val) {
                max = current.val;
                maxIndex = k;
            }
            k++;
            current = current.next;
        }


        return maxIndex;
    }

    @Override
    public void reverse() {

        if (isEmpty())
            throw new IllegalArgumentException();

    }

    @Override
    public void halfRevers() {

        if (isEmpty())
            throw new IllegalArgumentException();

    }

    @Override
    public void sort() {
        if (isEmpty())
            throw new IllegalArgumentException();


    }
}
