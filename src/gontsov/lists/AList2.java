package gontsov.lists;

import gontsov.EList;

import java.util.Arrays;
import java.util.Iterator;

public class AList2<EE extends Comparable<EE>> implements EList<EE>, Iterable<EE> {

    Object[] list = new Object[30];
    public int start = 10;
    public int end = 10;

    public void print(){
        System.out.println("start = "+start);
        System.out.println("end = "+end);
        System.out.println("");
        System.out.println(Arrays.toString(list));
    }

    @Override
    public void addStart(int val) {
        list[start-1] = val;
        start--;
    }

    @Override
    public void addEnd(int val) {
        list[end] = val;
        end++;
    }

    @Override
    public void addPos(int pos, int val) {
        start--;
        for (int i = start; i < start + pos; i++) {
            list[i] = list[i+1];
        }
        list[start+pos] = val;
    }

    @Override
    public EE delStart() {
        if(size() == 0)
            throw new IllegalArgumentException();
        EE deleted = (EE) list[start];
        start++;
        return deleted;
    }

    @Override
    public EE delEnd() {
        if(size() == 0)
            throw new IllegalArgumentException();

        end--;
        return (EE)list[end];
    }

    @Override
    public EE delPos(int pos) {
        if(size() == 0)
            throw new IllegalArgumentException();
        EE deleted = (EE)list[start+pos];
        end--;
        for (int i = start + pos; i < end; i++) {
            list[i] = list[i+1];
        }
        return deleted;
    }

    @Override
    public int size() {
        return end - start;
    }

    @Override
    public void clear() {
        end = start = list.length/2;
    }

    @Override
    public void init(EE[] ini) {
        clear();
        if(ini == null)
            return;
        start = start - ini.length/2;
        for (int i = 0; i < ini.length; i++) {
            list[start+i] = ini[i];
        }
        end = start + ini.length;
    }

    @Override
    public Object[] toArray() {
        Object[] arrCopy = new Object[size()];
        for (int j = 0; j < size(); j++) {
            arrCopy[j] = list[start + j];
        }
        return arrCopy;
    }

    @Override
    public void set(int pos, int val) {
        if (size()==0)
            throw new IllegalArgumentException();
        list[start+pos] = val;
    }

    @Override
    public EE get(int pos) {
        if (size()==0)
            throw new IllegalArgumentException();
        return (EE)list[start+pos];
    }

    @Override
    public int min() {
        if(size() == 0)
            throw new IllegalArgumentException();
        EE min = (EE)list[start];
        for (int i = 0; i < size(); i++) {
            EE tmp = (EE)list[start + i];
            if(min.compareTo(tmp) == 1) {
                min = tmp;
            }
        }
        return (Integer) min;
    }

    @Override
    public int max() {
        if(size() == 0)
            throw new IllegalArgumentException();
        EE max = (EE)list[start];
        for (int i = start+1; i < end; i++) {
            EE tmp = (EE)list[i];
            if(tmp.compareTo(max) == 1){
                max = tmp;
            }
        }
        return (Integer) max;
    }

    @Override
    public int minIndex() {
        if(size() == 0)
            throw new IllegalArgumentException();
        int minIndex = start;
        for (int i = start; i < end; i++) {
            EE tmp = (EE)list[i];
            EE minIndexArray = (EE) list[minIndex];
            if(tmp.compareTo(minIndexArray) == -1)
                minIndex = i;
        }
        return minIndex-start;
    }

    @Override
    public int maxIndex() {
        if(size() == 0)
            throw new IllegalArgumentException();
        int maxIndex = start;
        for (int i = start+1; i < end; i++) {
            EE tmp = (EE)list[i];
            EE maxIndexArray = (EE) list[maxIndex];
            if(tmp.compareTo(maxIndexArray) == 1)
                maxIndex = i;
        }
        return maxIndex-start;
    }

    @Override
    public void reverse() {
        if(size() == 0)
            throw new IllegalArgumentException();
        int temp = end - 1;
        for (int i = start; i < (start + end) / 2; i++) {
            EE tmp = (EE)list[i];
            list[i] = list[temp];
            list[temp] = tmp;
            temp--;
        }
    }

    @Override
    public void halfRevers() {
        if(size() == 0)
            throw new IllegalArgumentException();
        int halfArray = size() / 2;
        int half = size() / 2;
        for(int i = 0; i < half; i++)
        {
            if( size() % 2 == 0)
            {
                EE tmp = (EE)list[start + i];
                list[start + i] = list[start + half + i];
                list[start + half + i]= tmp;
            }
            else
            {
                EE tmp = (EE)list[start + i];
                list[start + i] = list[start + half + i + 1];
                list[start + half + i + 1 ]= tmp;
            }
        }

    }

    @Override
    public void sort() {
        if(size() == 0)
            throw new IllegalArgumentException();
        int out, in;
        for (out = start; out <  end; out++) {
            for (in = start; in <  end; in++) {
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
    public Iterator<EE> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<EE>
    {
        int i = start;

        @Override
        public boolean hasNext() {
            return i < end;
        }

        @Override
        public EE next() {
            return (EE)list[i++];
        }
    }
}
