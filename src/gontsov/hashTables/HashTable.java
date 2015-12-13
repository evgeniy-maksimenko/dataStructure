package gontsov.hashTables;

public class HashTable {

    public int size = 60; //размер хеш таблицы!!! TODO должна изменять размер
    public HashIndex[] hashTable = new HashIndex[size];

    public int hashCode(int key) {
        return 31 * key % size;
    }

    public int hashCodeDouble(int k) {
        return 5 - k %  5 ;
    }

    public int size() {
        int k = 0;
        for (int i = 0; i < size; i++) {
            if(hashTable[i] != null)
                k++;
        }
        return k;
    }

    public void init(int[] ini) {
        for (int i = 0; i < ini.length; i++) {
            HashIndex hashIndex = new HashIndex(ini[i]);
            add(ini[i], hashIndex);
        }
    }

    public void add(int key, HashIndex item){
        int hashCode = hashCode(key);
        int step = hashCodeDouble(key);
        while (hashTable[hashCode] != null && hashTable[hashCode].getVal() != -1) {
            hashCode += step;
            hashCode = hashCode % size;
        }
        hashTable[hashCode] = item;
    }

    public int find(int key) {
        int hashCode = hashCode(key);
        int step = hashCodeDouble(key);
        while (hashTable[hashCode] != null) {
            if(hashTable[hashCode].getVal() == key)
                return hashTable[hashCode].getVal();
            hashCode += step;
            hashCode %= size;
        }
        return 0;
    }

    public int del(int key){
        int hashCode = hashCode(key);
        int step = hashCodeDouble(key);
        while (hashTable[hashCode] != null) {
            if(hashTable[hashCode].getVal() == key) {
                int res = hashTable[hashCode].getVal();
                hashTable[hashCode] = new HashIndex(-1);
                return res;
            }
            hashCode += step;
            hashCode %= size;
        }
        return 0;
    }


    public int[] toArray() {
        int[] arrCopy = new int[size];
        for (int i = 0; i < size; i++) {
            if(hashTable[i] != null)
                arrCopy[i] = hashTable[i].getVal();
        }
        return arrCopy;
    }
}
