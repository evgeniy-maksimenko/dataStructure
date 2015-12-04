package gontsov;

public class HashTable {
    class DataItem {
        private int iData;

        public DataItem(int ii) {
            iData = ii;
        }

        public int getKey() {
            return iData;
        }
    }

    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;


    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public int hashFun(int k) {
        return k % arraySize;
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFun(key);
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem find(int key) {
        int hashVal = hashFun(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }
}
