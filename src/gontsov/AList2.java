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
        int deleted = list[start];
        start++;
        return deleted;
    }

    @Override
    public int delEnd() {
        int deleted = list[end];
        end--;
        return deleted;
    }

    @Override
    public int delPos(int pos) {
        int deleted = list[pos];
        end--;
        for (int i = start + end; i < end; i++) {
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
            throw new ArrayIndexOutOfBoundsException();
        list[start+pos] = val;
    }

    @Override
    public int get(int pos) {
        if (size()==0)
            throw new ArrayIndexOutOfBoundsException();
        return list[start+pos];
    }

    @Override
    public int min() {
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
        int minIndex = start;
        for (int i = start; i < end; i++) {
            if(list[i] < list[minIndex])
                minIndex = i;
        }
        return minIndex-start;
    }

    @Override
    public int maxIndex() {
        int maxIndex = 0;
        for (int i = start; i < end; i++) {
            if(list[i] > list[maxIndex])
                maxIndex = i;
        }
        return maxIndex-start;
    }

    @Override
    public void reverse() {
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

    }

    @Override
    public void sort() {

    }
}
