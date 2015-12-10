package gontsov;

import java.util.Arrays;

public class AList2 implements EList {

    int[] list = new int[20];
    public int start;
    public int end;

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
    public int delStart() {
        if(size() == 0)
            throw new IllegalArgumentException();
        int deleted = list[start];
        start++;
        return deleted;
    }

    @Override
    public int delEnd() {
        if(size() == 0)
            throw new IllegalArgumentException();

        end--;
        return list[end];
    }

    @Override
    public int delPos(int pos) {
        if(size() == 0)
            throw new IllegalArgumentException();
        int deleted = list[start+pos];
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
    public void init(int[] ini) {
        clear();
        if(ini == null)
            ini = new int[0];
        start = start - ini.length/2;
        for (int i = 0; i < ini.length; i++) {
            list[start+i] = ini[i];
        }
        end = start + ini.length;
    }

    @Override
    public int[] toArray() {
        int[] arrCopy = new int[size()];
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
    public int get(int pos) {
        if (size()==0)
            throw new IllegalArgumentException();
        return list[start+pos];
    }

    @Override
    public int min() {
        if(size() == 0)
            throw new IllegalArgumentException();
        int min = list[start];
        for (int i = 0; i < size(); i++) {
            if(min > list[start + i]){
                min = list[ start + i ];
            }
        }
        return min;
    }

    @Override
    public int max() {
        if(size() == 0)
            throw new IllegalArgumentException();
        int max = list[start];
        for (int i = 0; i < size(); i++) {
            if(max < list[start + i]){
                max = list[ start + i ];
            }
        }
        return max;
    }

    @Override
    public int minIndex() {
        if(size() == 0)
            throw new IllegalArgumentException();
        int minIndex = start;
        for (int i = start; i < end; i++) {
            if(list[i] < list[minIndex])
                minIndex = i;
        }
        return minIndex-start;
    }

    @Override
    public int maxIndex() {
        if(size() == 0)
            throw new IllegalArgumentException();
        int maxIndex = 0;
        for (int i = start; i < end; i++) {
            if(list[i] > list[maxIndex])
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
            int tmp = list[i];
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
                int tmp = list[start + i];
                list[start + i] = list[start + half + i];
                list[start + half + i]= tmp;
            }
            else
            {
                int tmp = list[start + i];
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
                if (list[in] > list[out]) {
                    int tmp = list[in];
                    list[in] = list[out];
                    list[out] = tmp;
                }
            }
        }
    }
}
