package gontsov.lists;

import gontsov.EList;

import java.util.Iterator;



public class AList0<EE extends Comparable<EE>> implements EList<EE>, Iterable<EE> {
    public Object[] list = {};


    @Override
    public Object[] toArray() {
        Object[] in = new Object[size()];
        for (int i = 0; i < size(); i++) {
            in[i] = list[i];
        }
        return in;
    }


    private void exception(Object[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException();
    }

    @Override
    public int min() {
        exception(list);

        EE min = (EE)list[0];
        for (int i = 0; i < list.length; i++) {
            EE tmp = (EE)list[i];
            if(min.compareTo(tmp) == 1) {
                min = tmp;
            }
        }
        return (Integer) min;

    }

    @Override
    public int max() {
        exception(list);
        EE max = (EE)list[0];
        for (int i = 0; i < list.length; i++) {
            EE tmp = (EE)list[i];
            if(tmp.compareTo(max) == 1){
                max = tmp;
            }
        }
        return (Integer)max;
    }


    @Override
    public int minIndex() {
        exception(list);
        EE result = (EE)list[0];
        int index = 0;
        for (int i = 0; i < list.length; i++) {
            EE tmp = (EE)list[i];
            if(tmp.compareTo(result) == -1)
                index = i;
        }
        return index;
    }

    @Override
    public int maxIndex() {
        exception(list);

        int maxIndex = 0;
        for (int i = 0; i < list.length; i++) {
            EE tmp = (EE)list[i];
            EE maxIndexArray = (EE) list[maxIndex];
            if(tmp.compareTo(maxIndexArray) == 1)
                maxIndex = i;
        }
        return maxIndex;
    }

    @Override
    public void sort() {
        exception(list);
        int out, in;
        for (out = 0; out < list.length; out++) {
            for (in = 0; in < list.length; in++) {
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

    public void print() {
        exception(list);

        for (int j = 0; j < list.length; j++)
            System.out.print(list[j] + " ");
        System.out.println("");
    }

    @Override
    public void reverse() {
        exception(list);

        for (int i = 0; i < list.length / 2; i++) {
            Object tmp = list[i];
            list[i] = list[list.length - i - 1];
            list[list.length - i - 1] = tmp;
        }
    }


    @Override
    public void halfRevers() {
        exception(list);
        int halfArray = list.length / 2;
        int next = halfArray + list.length % 2;
        for (int i = 0; i < halfArray; i++) {
            Object temp = list[i];
            list[i] = list[i + next];
            list[i + next] = temp;
        }
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public void set(int index, int element) {
        exception(list);
        list[index] = element;
    }

    @Override
    public EE get(int index) {
        exception(list);
        return (EE)list[index];
    }

    @Override
    public void clear() {
        list = new Object[0];
    }


    @Override
    public void init(EE[] in) {
        if (in == null) {
            return;
        }
        list = new Object[in.length];
        for (int i = 0; i < in.length; i++) {
            list[i] = in[i];
        }
    }


    @Override
    public void addStart(int element) {
        int LENGTH = list.length;
        Object[] baseArray = new Object[LENGTH + 1];

        for (int i = 0; i < baseArray.length; i++) {
            if (i == 0) {
                baseArray[0] = element;
            } else {
                baseArray[i] = list[i - 1];
            }
        }

        list = baseArray;
    }

    @Override
    public void addEnd(int element) {
        int LENGTH = list.length;
        Object[] baseArray = new Object[LENGTH + 1];

        for (int i = 0; i < baseArray.length; i++) {

            if (i == LENGTH) {
                baseArray[i] = element;
            } else {
                baseArray[i] = list[i];
            }
        }

        list = baseArray;
    }

    @Override
    public void addPos(int index, int element) {
        exception(list);
        int LENGTH = list.length;
        Object[] baseArray = new Object[LENGTH + 1];


        for (int i = 0; i < baseArray.length; i++) {
            if (i < index) {
                baseArray[i] = list[i];
            }
            if (i == index) {
                baseArray[i] = element;
            }
            if (i > index) {
                baseArray[i] = list[i - 1];
            }
        }

        list = baseArray;
    }

    @Override
    public EE delStart() {
        exception(list);
        Object delElement = list[0];
        int LENGTH = list.length;
        Object[] baseArray = new Object[LENGTH - 1];

        for (int i = 0; i < baseArray.length; i++)
            baseArray[i] = list[i + 1];

        list = baseArray;
        return (EE)delElement;
    }

    @Override
    public EE delEnd() {
        exception(list);
        int LENGTH = list.length;
        Object delElement = list[LENGTH - 1];
        Object[] baseArray = new Object[LENGTH - 1];

        for (int i = 0; i < baseArray.length; i++) {
            baseArray[i] = list[i];

        }

        list = baseArray;
        return (EE)delElement;
    }

    @Override
    public EE delPos(int index) {
        exception(list);

        exception(list);
        Object delElement = list[index];
        int LENGTH = list.length;
        Object[] baseArray = new Object[LENGTH - 1];

        for (int i = 0; i < baseArray.length; i++) {
            if (i < index) baseArray[i] = list[i];

            if (i >= index) baseArray[i] = list[i + 1];
        }
        list = baseArray;
        return (EE)delElement;
    }


    public Iterator<EE> iterator() {
        return new AList0Iterator(toArray());
    }

    class AList0Iterator implements Iterator<EE> {

        int i = 0;
        Object[] arr = new Object[]{};

        public AList0Iterator(Object[] arr) {
            this.arr = arr;

        }

        @Override
        public boolean hasNext() {
            return i < arr.length;
        }

        @Override
        public EE next() { return (EE)arr[i++]; }
    }

}
