package gontsov.hashTables;

public class HashTable {

    public int size = 30; //размер хеш таблицы!!! TODO должна изменять размер
    public HashIndex[] hashTable = new HashIndex[size];

    public int hashCode(int key) {
        return 31 * key % size;
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
            add(hashIndex);
        }
    }

    public void add(HashIndex key){
        int val = key.getVal();
        int hashCode = hashCode(val);
        while (hashTable[hashCode] != null && hashTable[hashCode].getVal() != -1) {
            hashCode++;
            hashCode = hashCode % size;
        }
        hashTable[hashCode] = key;
    }

    public int find(int val) {
        int hashCode = hashCode(val);
        while (hashTable[hashCode] != null) {
            if(hashTable[hashCode].getVal() == val)
                return hashTable[hashCode].getVal();
            hashCode++;
            hashCode %= size;
        }
        return 0;
    }

    public int del(int val){
        int hashCode = hashCode(val);
        while (hashTable[hashCode] != null) {
            if(hashTable[hashCode].getVal() == val) {
                int res = hashTable[hashCode].getVal();
                hashTable[hashCode] = new HashIndex(-1);
                return res;
            }
            hashCode++;
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
