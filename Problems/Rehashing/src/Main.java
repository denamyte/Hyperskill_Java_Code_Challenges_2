import java.util.Scanner;

public class Main {
    private static class TableEntry {
        private final int key;
        private final Object value;

        public TableEntry(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }

    private static class HashTable<T> {
        private int capacity;
        private int size;  // the number of actually added entries
        private TableEntry[] table;
        private static final int SCALING_FACTOR = 2;

        public HashTable(int size) {
            this.capacity = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            if (size == capacity) {
                rehash();
            }
            table[findKey(key)] = new TableEntry(key, value);
            size++;
            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();          
        }

        private int findKey(int key) {
            int hash = key % capacity;

            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % capacity;

                if (hash == key % capacity) {
                    return -1;
                }
            }

            return hash;
        }

        private void rehash() {
            capacity = SCALING_FACTOR * capacity;
            size = 0;
            TableEntry[] oldEntries = table;
            table = new TableEntry[capacity];
            for (TableEntry entry : oldEntries) {
                put(entry.key, (T) entry.value);
            }
        }

        @Override
        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    tableStringBuilder.append(i + ": null");
                } else {
                    tableStringBuilder.append(i + ": key=" + table[i].getKey()
                                                + ", value=" + table[i].getValue());
                }

                if (i < table.length - 1) {
                    tableStringBuilder.append("\n");
                }
            }

            return tableStringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTable<String> hashTable = new HashTable<>(5);
        for (long count = Integer.parseInt(scanner.nextLine()); count > 0; count--) {
            String s = scanner.nextLine();
            String[] ar = s.split("\\W+");
            hashTable.put(Integer.parseInt(ar[0]), ar[1]);
        }
        System.out.println(hashTable);
    }
}