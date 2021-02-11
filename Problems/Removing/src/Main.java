import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void remove() {
             removed = true;   
        }

        public boolean isRemoved() {
             return removed;   
        }
    }

    private static class HashTable<T> {
        private int capacity;
        private int size;  // the number of entries actually added
        private TableEntry[] table;
        private static final int SCALING_FACTOR = 2;

        public HashTable(int capacity) {
            this.capacity = capacity;
            table = new TableEntry[capacity];
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

        public void remove(int key) {
            int hash = key % capacity;
            TableEntry entry = table[hash];
            int tries = 1;
            while (tries <= capacity && entry != null) {
                if (entry.key == key) {
                    entry.remove();
                    break;
                }
                tries++;
                hash = (hash + 1) % capacity;
                entry = table[hash];
            }
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
                                                + ", value=" + table[i].getValue()
                                                + ", removed=" + table[i].isRemoved());
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
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashTable<String> hashTable = new HashTable<>(5);
        for (int i = 0; i < n; i++) {
            String[] ar = scanner.nextLine().split("\\W+");
            hashTable.put(Integer.parseInt(ar[0]), ar[1]);
        }
        for (int i = 0; i < m; i++) {
            hashTable.remove(Integer.parseInt(scanner.nextLine()));
        }

        System.out.println(hashTable);
    }
}