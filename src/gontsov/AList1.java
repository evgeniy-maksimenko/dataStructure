package gontsov;

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
        if (list == null || list.length == 0)
            throw new IllegalArgumentException();
        list[index] = element;
    }

    @Override
    public int get(int index) {
        if (list == null || list.length == 0)
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
        if (list == null || list.length == 0)
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
        if (list == null || list.length == 0)
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
        if (list == null || list.length == 0)
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
        if (list == null || list.length == 0)
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
        if (list == null || list.length == 0)
            throw new IllegalArgumentException();

    }


    @Override
    public void reverse() {

    }

    @Override
    public void halfRevers() {

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
    public void addPos(int index, int item) {
        for (int i = this.top; i > 0; --i) {
            if (i < index) {
                this.list[i] = this.list[i];
            }

            if (i == index) {
                this.list[i] = item;
                ++this.top;
            }

            if (i > index) {
                this.list[i] = this.list[i - 1];
            }
        }

    }

    @Override
    public int delStart() {
        if (list == null || list.length == 0)
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
        return this.list[--this.top];
    }

    @Override
    public int delPos(int index) {
        if (index > size())
            throw new ArrayIndexOutOfBoundsException();

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
