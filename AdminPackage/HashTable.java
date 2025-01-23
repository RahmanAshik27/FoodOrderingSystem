// Basic implementation of Hash Table in Java
public class HashTable {
    private static class Node {
        String key;
        String value;
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] table;
    private int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    // Hash function to calculate index based on the key
    private int hash(String key) {
        return key.hashCode() % capacity;
    }

    // Insert key-value pair
    public void put(String key, String value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Get value by key
    public String get(String key) {
        int index = hash(key);
        Node current = table[index];
        
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Return null if the key is not found
    }

    // Remove key-value pair
    public void remove(String key) {
        int index = hash(key);
        Node current = table[index];
        Node previous = null;
        
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    // Main method to test the HashTable
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        
        // Insert key-value pairs
        hashTable.put("name", "Apon");
        hashTable.put("age", "21");
        hashTable.put("city", "Dhaka");
        
        // Get values by keys
        System.out.println("Name: " + hashTable.get("name"));
        System.out.println("Age: " + hashTable.get("age"));
        
        // Remove key-value pair
        hashTable.remove("age");
        System.out.println("Age after removal: " + hashTable.get("age"));
    }
}
