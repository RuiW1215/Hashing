public class HashT {
    private int TABLE_SIZE = 128;
    private final double DEFAULT_LOAD_VALUE = 0.75;
    private int numEntries;
    LinkedHashEntry[] table;

    public void HashMap() {
        table = new LinkedHashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    public String get(int key) {
        int hash = (key % TABLE_SIZE);
        if (table[hash] == null)
            return null;
        else {
            LinkedHashEntry entry = table[hash];
            while (entry != null && entry.getKey() != key)
                entry = entry.getNext();
            if (entry == null)
                return null;
            else
                return entry.getValue();
        }
    }

    public void put(int key, String value) {
        int hash = (key % TABLE_SIZE);
        if (table[hash] == null)
            table[hash] = new LinkedHashEntry(key, value);
        else {
            LinkedHashEntry entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != key)
                entry = entry.getNext();
            if (entry.getKey() == key)
                entry.setValue(value);
            else
                entry.setNext(new LinkedHashEntry(key, value));
        }
    }

    public void remove(int key) {
        int hash = (key % TABLE_SIZE);
        if (table[hash] != null) {
            LinkedHashEntry prevEntry = null;
            LinkedHashEntry entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != key) {
                prevEntry = entry;
                entry = entry.getNext();
            }
            if (entry.getKey() == key) {
                if (prevEntry == null)
                    table[hash] = entry.getNext();
                else
                    prevEntry.setNext(entry.getNext());
            }
        }
    }

    public void rehash() {
        /* CIRCUMSTANCES FOR REHASH:
        *  -------------------------------------------
        *  If any link lists are longer than X (i.e. >=5)
        *  If the Hash Table is 70-70% full
        */
        int newTableSize = nextPrime(TABLE_SIZE * 2);
        newTable = new LinkedHashEntry[newTableSize];

        for(int i = 0; i < TABLE_SIZE; i++) {
            LinkedHashEntry entry = table[i];
            while (entry != null) {
                newTable.put(entry.getKey(), entry.getValue());
                entry = entry.getNext(); // Case if a linked list exists in said index
            }
        }
        table = newTable;
    }
    
    public  static int nextPrime(int input) {
        input++;
        //now find if the number is prime or not
        for(int i=2;i<input;i++) {
            if(input % i ==0  ) {
                input++;
                i=2;
            }
            else {
                continue;
            }
        }
        return input;
    }

   

}