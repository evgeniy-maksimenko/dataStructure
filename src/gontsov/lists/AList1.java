package gontsov.lists;

import gontsov.EList;

import java.util.Iterator;

public class AList1 implements EList, Iterable<Integer> {
    int[] list = new int[10];
    int top;

    public AList1() {
    }

    public AList1(int[] ini) {
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
    public int get(int index) {
        if (size() == 0)
            throw new IllegalArgumentException();
        return list[index];
    }

    @Override
    public void clear() {
        top = 0;
    }

    @Override
    public int[] toArray() {
        int[] tmp = new int[this.size()];

        for (int i = 0; i < tmp.length; ++i) {
            tmp[i] = this.list[i];
        }

        return tmp;
    }

    @Override
    public int min() {
        if (size() == 0)
            throw new IllegalArgumentException();
        int min = list[0];
        for (int i = 0; i < top; i++) {
            if(min > list[i])
                min = list[i];
        }
        return min;
    }

    @Override
    public int max() {
        if (size() == 0)
            throw new IllegalArgumentException();
        int min = list[0];
        for (int i = 0; i < top; i++) {
            if(min < list[i])
                min = list[i];
        }
        return min;
    }

    @Override
    public int minIndex() {
        if (size() == 0)
            throw new IllegalArgumentException();
        int minIndex = 0;
        for (int i = 0; i < top; i++) {
            if(list[i] < list[minIndex])
                minIndex = i;
        }
        return minIndex;
    }

    @Override
    public int maxIndex() {
        if (size() == 0)
            throw new IllegalArgumentException();
        int minIndex = 0;
        for (int i = 0; i < top; i++) {
            if(list[i] > list[minIndex])
                minIndex = i;
        }
        return minIndex;
    }


    @Override
    public void sort() {
        if (size() == 0)
            throw new IllegalArgumentException();

        int out, in;
        for (out = 0; out < top; out++) {
            for (in = 0; in < top; in++) {
                if (list[in] > list[out]) {
                    int tmp = list[in];
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
            int tmp = list[i];
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
            int temp = list[i];
            list[i] = list[i + next];
            list[i + next] = temp;
        }
    }

    public void init(int[] ini) {
        for (int i = 0; i < ini.length; ++i) {
            this.list[i] = ini[i];
        }

        this.top = ini.length;
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
        int[] arrPartCopy = new int[top];
        for (int i = 0; i < top; i++) {
            if(i==pos)
                arrPartCopy[i] = val;
            if(i<pos)
                arrPartCopy[i] = list[i];
            if(i>pos)
                arrPartCopy[i] = list[i-1];
        }

        for (int i = 0; i < top; i++) {
            list[i] = arrPartCopy[i];
        }
    }

    @Override
    public int delStart() {
        if (size() == 0)
            throw new IllegalArgumentException();
        int delElement = this.list[0];

        for (int i = 0; i < this.top; ++i) {
            this.list[i] = this.list[i + 1];
        }

        this.delEnd();
        return delElement;
    }

    @Override
    public int delEnd() {
        if (size() == 0)
            throw new IllegalArgumentException();

        return this.list[--this.top];
    }

    @Override
    public int delPos(int index) {
        if (size() == 0)
            throw new IllegalArgumentException();

        int res = 0;

        for (int i = 0; i < this.top; ++i) {
            if (i == index) {
                res = this.list[i];
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

    public Iterator<Integer> iterator() {
        return new AList1Iterator(toArray());
    }

    class AList1Iterator implements Iterator<Integer> {

        int i = 0;
        int[] arr = new int[]{};

        public AList1Iterator(int[] arr) {
            this.arr = arr;

        }

        @Override
        public boolean hasNext() {
            return i < arr.length;
        }

        @Override
        public Integer next() {
            return arr[i++];
        }
    }
}
