package gontsov.lists;

import gontsov.EList;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;


public class AList1<EE extends Comparable<EE>> implements EList<EE>, Iterable<EE> {
    Object[] list = new Object[10];
    int top;

    public AList1() {
    }

    public AList1(EE[] ini) {
        this.init(ini);
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public void set(int index, int element) {
        if (size() == 0)
            throw new IllegalArgumentException();
        list[index] = element;
    }

    @Override
    public EE get(int index) {
        if (size() == 0)
            throw new IllegalArgumentException();
        return (EE)list[index];
    }

    @Override
    public void clear() {
        top = 0;
    }

    @Override
    public void init(EE[] ini) {
        for (int i = 0; i < ini.length; ++i) {
            this.list[i] = ini[i];
        }

        this.top = ini.length;
    }

    @Override
    public Object[] toArray() {
        Object[] tmp = new Object[this.size()];

        for (int i = 0; i < tmp.length; ++i) {
            tmp[i] = this.list[i];
        }

        return tmp;
    }

    @Override
    public int min() {
        if (size() == 0)
            throw new IllegalArgumentException();
        EE min = (EE)list[0];
        for (int i = 0; i < top; i++) {
            EE tmp = (EE)list[i];
            if(min.compareTo(tmp) == 1)
                min = tmp;
        }
        return (Integer) min;
    }

    @Override
    public int max() {
        if (size() == 0)
            throw new IllegalArgumentException();
        EE max = (EE)list[0];
        for (int i = 0; i < top; i++) {
            EE tmp = (EE)list[i];
            if(tmp.compareTo(max) == 1){
                max = tmp;
            }
        }
        return (Integer) max;
    }

    @Override
    public int minIndex() {
        if (size() == 0)
            throw new IllegalArgumentException();
        int minIndex = 0;
        for (int i = 0; i < top; i++) {
            EE tmp = (EE)list[i];
            EE minIndexArray = (EE) list[minIndex];
            if(tmp.compareTo(minIndexArray) == -1)
                minIndex = i;
        }
        return minIndex;
    }

    @Override
    public int maxIndex() {
        if (size() == 0)
            throw new IllegalArgumentException();
        int maxIndex = 0;
        for (int i = 0; i < top; i++) {
            EE tmp = (EE)list[i];
            EE minIndexArray = (EE) list[maxIndex];
            if(tmp.compareTo(minIndexArray) == 1)
                maxIndex = i;
        }
        return maxIndex;
    }


    @Override
    public void sort() {
        if (size() == 0)
            throw new IllegalArgumentException();

        int out, in;
        for (out = 0; out < top; out++) {
            for (in = 0; in < top; in++) {
                EE arrayIn = (EE)list[in];
                EE arrayOut = (EE)list[out];
                if ( arrayIn.compareTo(arrayOut) == 1) {
                    EE tmp = arrayIn;
                    list[in] = list[out];
                    list[out] = tmp;
                }
            }
        }

    }


    @Override
    public void reverse() {
        if (size() == 0)
            throw new IllegalArgumentException();

        for (int i = 0; i < top / 2; i++) {
            EE tmp = (EE)list[i];
            list[i] = list[top - i - 1];
            list[top - i - 1] = tmp;
        }
    }

    @Override
    public void halfRevers() {
        if (size() == 0)
            throw new IllegalArgumentException();

        int halfArray = top / 2;
        int next = halfArray + top % 2;
        for (int i = 0; i < halfArray; i++) {
            EE temp = (EE)list[i];
            list[i] = list[i + next];
            list[i + next] = temp;
        }
    }

        @Override
    public void addStart(int val) {
        for (int i = this.top; i > 0; --i) {
            this.list[i] = this.list[i - 1];
        }

        this.list[0] = val;
        ++this.top;
    }

    @Override
    public void addEnd(int val) {
        this.list[this.top++] = val;
    }

    @Override
    public void addPos(int pos, int val) {
        top++;
        Object[] arrPartCopy = new Object[top];
        for (int i = 0; i < top; i++) {
            if(i==pos)
                arrPartCopy[i] = val;
            if(i<pos)
                arrPartCopy[i] = (EE)list[i];
            if(i>pos)
                arrPartCopy[i] = (EE)list[i-1];
        }

        for (int i = 0; i < top; i++) {
            list[i] = arrPartCopy[i];
        }
    }

    @Override
    public EE delStart() {
        if (size() == 0)
            throw new IllegalArgumentException();
        EE delElement = (EE)this.list[0];

        for (int i = 0; i < this.top; ++i) {
            this.list[i] = this.list[i + 1];
        }

        this.delEnd();
        return delElement;
    }

    @Override
    public EE delEnd() {
        if (size() == 0)
            throw new IllegalArgumentException();

        return (EE)this.list[--this.top];
    }

    @Override
    public EE delPos(int index) {
        if (size() == 0)
            throw new IllegalArgumentException();

        EE res = null;

        for (int i = 0; i < this.top; ++i) {
            if (i == index) {
                res = (EE)this.list[i];
                this.list[i] = this.list[i + 1];
                --this.top;
            }

            if (i > index) {
                this.list[i] = this.list[i + 1];
            }
        }

        return res;
    }

    private void exception(int[] array) {
        if (size() == 0)
            throw new IllegalArgumentException();
    }

    public Iterator<EE> iterator() {

        return new AList1Iterator(toArray());
    }


    class AList1Iterator implements Iterator<EE> {

        int i = 0;
        Object[] arr = new Object[]{};

        public AList1Iterator(Object[] arr) {
            this.arr = arr;
        }

        @Override
        public boolean hasNext() { return i < arr.length; }

        @Override
        public EE next() { return (EE)arr[i++]; }
    }
}
