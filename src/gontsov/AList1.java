package gontsov;

import java.util.Iterator;

public class AList1 implements EList, Iterable<Integer> {
    int[] arr = new int[10];
    int top;

    public AList1() {
    }

    public AList1(int[] ini) {
        this.init(ini);
    }

    @Override
    public int size() {
        return this.top;
    }

    @Override
    public void set(int index, int element) {

    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public void clear() {
        top = 0;
    }

    @Override
    public int[] toArray() {
        int[] tmp = new int[this.size()];

        for (int i = 0; i < tmp.length; ++i) {
            tmp[i] = this.arr[i];
        }

        return tmp;
    }

    @Override
    public int min() {
        return 0;
    }

    @Override
    public int max() {
        return 0;
    }

    @Override
    public int minIndex() {
        return 0;
    }

    @Override
    public int maxIndex() {
        return 0;
    }


    @Override
    public void sort() {

    }


    @Override
    public void reverse() {

    }

    @Override
    public void halfRevers() {

    }

    public void init(int[] ini) {
        for (int i = 0; i < ini.length; ++i) {
            this.arr[i] = ini[i];
        }

        this.top = ini.length;
    }

    @Override
    public void addStart(int val) {
        for (int i = this.top; i > 0; --i) {
            this.arr[i] = this.arr[i - 1];
        }

        this.arr[0] = val;
        ++this.top;
    }

    @Override
    public void addEnd(int val) {
        this.arr[this.top++] = val;
    }

    @Override
    public void addPos(int index, int item) {
        for (int i = this.top; i > 0; --i) {
            if (i < index) {
                this.arr[i] = this.arr[i];
            }

            if (i == index) {
                this.arr[i] = item;
                ++this.top;
            }

            if (i > index) {
                this.arr[i] = this.arr[i - 1];
            }
        }

    }

    @Override
    public int delStart() {
        exception(this.arr);
        int delElement = this.arr[0];

        for (int i = 0; i < this.top; ++i) {
            this.arr[i] = this.arr[i + 1];
        }

        this.delEnd();
        return delElement;
    }

    @Override
    public int delEnd() {
        return this.arr[--this.top];
    }

    @Override
    public int delPos(int index) {
        if (index > size())
            throw new ArrayIndexOutOfBoundsException();

        int res = 0;

        for (int i = 0; i < this.top; ++i) {
            if (i == index) {
                res = this.arr[i];
                this.arr[i] = this.arr[i + 1];
                --this.top;
            }

            if (i > index) {
                this.arr[i] = this.arr[i + 1];
            }
        }

        return res;
    }

    private void exception(int[] array) {
        if (array == null || array.length == 0)
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
