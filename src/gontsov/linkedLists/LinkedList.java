package gontsov.linkedLists;

import gontsov.EList;
import gontsov.lists.AList0;
public class LinkedList<EE extends Comparable<EE>> implements EList<EE> {
    class Link {
        public Object val;

        public Link(Object val) {
            this.val = val;
        }

        public Link next;

        public void displayLink() {
            System.out.print("{" + val + "}");
        }
    }

    private Link first;
    private Link last;

    @Override
    public void addStart(int val) {
        Link newLink = new Link(val);
        if (isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    @Override
    public void addEnd(int val) {
        Link newLink = new Link(val);
        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    @Override
    public void addPos(int pos, int val) {
        int k = 0;
        Link current = first;
        Link newLink = new Link(val);
        if(pos == 0)
        {
            addStart(val);
        }
        while (current != null && pos != 0) {
            if(k == pos - 1) {
                newLink.next = current.next;
                current.next = newLink;
            }
            k++;
            current = current.next;
        }
    }

    @Override
    public EE delStart() {
        if (isEmpty())
            throw new IllegalArgumentException();
        Link temp = first;
        first = first.next;
        return (EE) temp.val;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    @Override
    public EE delEnd() {
        if (isEmpty())
            throw new IllegalArgumentException();

        EE res = null;
        Link current = first;

        if(current.next == null){
            res = (EE)current.val;
            first = null;
            clear();
            return res;
        }
        else {
            while (current != null) {
                if(current.next.next == null){
                    res =(EE) current.next.val;
                    current.next = null;
                    return res;
                }
                current = current.next;
            }
        }


        return res;
    }

    @Override
    public EE delPos(int pos) {
        if (isEmpty())
            throw new IllegalArgumentException();

        int k = 0;
        Object res = k;
        Link current = first;
        if(pos == k)
        {
            res = current.val;
            delStart();
            return (EE)res;
        }
        while (current != null) {
            if( k == pos - 1) {
                res = current.next.val;
                current.next = current.next.next;
                return (EE)res;
            }
            k++;
            current = current.next;
        }

        return (EE)res;
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
    }

    @Override
    public void init(EE[] ini) {
        clear();
        for (int i = ini.length - 1; i >= 0; i--) {
            addStart((Integer) ini[i]);
        }
    }


    @Override
    public Object[] toArray() {

        AList0<Integer> list = new AList0<Integer>();

        Link current = first;
        while (current != null) {
            list.addEnd((Integer) current.val);
            current = current.next;
        }

        return list.toArray();
    }

    @Override
    public void set(int pos, int val) {
        if (isEmpty())
            throw new IllegalArgumentException();

        int k=0;
        Link current = first;
        while (current != null) {
            if(k == pos)
            {
                current.val = val;
                return;
            }
            k++;
            current = current.next;
        }
    }

    @Override
    public EE get(int pos) {
        if (isEmpty())
            throw new IllegalArgumentException();

        Object res = null;
        int k = 0;
        Link current = first;
        while (current != null) {
            if(k == pos)
                res = current.val;
            k++;
            current = current.next;
        }

        return (EE)res;
    }

    @Override
    public int min() {
        if (isEmpty())
            throw new IllegalArgumentException();

        Link current = first;
        EE min = (EE)current.val;
        while (current != null) {
            EE currentVal = (EE)current.val;
            if(min.compareTo(currentVal) == 1)
                min = currentVal;
            current = current.next;
        }

        return (Integer) min;
    }

    @Override
    public int max() {
        if (isEmpty())
            throw new IllegalArgumentException();

        Link current = first;
        EE max = (EE)current.val;
        while (current != null) {
            EE currentVal = (EE)current.val;
            if(max.compareTo(currentVal) == -1)
                max = currentVal;
            current = current.next;
        }

        return (Integer) max;
    }

    @Override
    public int minIndex() {
        if (isEmpty())
            throw new IllegalArgumentException();


        Link current = first;
        EE min = (EE)current.val;
        int k = 0;
        int minIndex = k;
        while (current != null) {

            EE currentVal = (EE)current.val;
            if(min.compareTo(currentVal) == 1)
            {
                min = currentVal;
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
        EE max = (EE)current.val;
        int k = 0;
        int maxIndex = k;
        while (current != null) {

            EE currentVal = (EE)current.val;
            if(max.compareTo(currentVal) == -11)
            {
                max = currentVal;
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

    public boolean isEmpty() {
        return first == null;
    }

    /*
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
    */
}

