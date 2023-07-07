import java.lang.StringBuilder;

// ********************************************************
// Hash table implementation.
// Assumption: A table contains unique keys with possibly non-unique associated values
// *********************************************************

public class HashTable<K, V> implements HashTableInterface<K, V> {
	private ChainNode[] table; // hash table
	private int size = 0; // number of entries ((key,value) associations)

	public HashTable() {
		table = new ChainNode[3];
	} // end default constructor

// table operations
	public boolean tableIsEmpty() {
		return size == 0;
	} // end tableIsEmpty

	public int tableLength() {
		return size;
	} // end tableLength = number of (key,value) associations in the HashTable

//implement the following 5 methods

// if key is not already in HashTable inserts association (key,value) and returns true
// if key is already in the HashTable it does not re-insert and returns false
	public boolean tableInsert(K key, V value) {

		boolean DNE = true;

		if (size < table.length) {

			if (size > 0) {
				for (int i = 0; i < size; i++) {
					if (table[i].getKey().equals(key)) {
						DNE = false;
					}
				}
			}
			
			if (DNE == true) {
				ChainNode<K, V> newNode = new ChainNode(key, value, null);
				table[size] = newNode;
				size++;

				if (size > 0) {
					table[size - 1].setNext(newNode);
				}

			}
		}
		return DNE;
	}

// if key is in HashTable deletes the key and its association from the HashTable and returns true
// if key is not in the HashTable returns false
	public boolean tableDelete(K searchKey) {
		boolean found = false;

		for (int i = 0; i < size; i++) {
			if (table[i].getNext().getKey().equals(searchKey)) {
				found = true;
				ChainNode toReplace = table[i].getNext();
				table[i].setNext(toReplace.getNext());
				size--;
			}
		}

		return found;
	}

//returns the value associated with searchKey in the HashTable or null if the serchKey is not in the HashTable 
	public V tableRetrieve(K searchKey) {
		V value = null;
		boolean found = false;

		for (int i = 0; i < size && found == false; i++) {
			if (table[i].getKey().equals(searchKey)) {
				value = (V) table[i].getValue();
				found = true;
			}
		}

		return value;
	}

// returns the integer hashCode computed using Horner's rule - assumes K is String 
	public int hashCode(K key) {

		int code = 0;
		String keyString = key.toString();

		for (int i = 0, s = keyString.length()-1; i < keyString.length(); i++, s--) {
			int current = map(keyString.charAt(i));
		
			int power = 1;
			for(int k = s; k > 0; k--)
			{
				if(k == 0)
				{
					power *= 1;
				}
				else
				{
					power *= 32;
				}
			}
			
			code += (current * power);
		}

		return code;
	}

//display all (key,value) associations in the HashTable
	public String toString() {
		StringBuilder build = new StringBuilder();
		String result = "";
		for (int i = 0; i < size; i++) {
			build.append(table[i].getKey().toString() + ", " + table[i].getValue().toString() + " ");
		}

		result = build.toString();
		return result;

	}

	public int map(char character) {
		String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int value = 0;
		boolean found = false;

		for (int i = 1; i < alphabet.length() && found == false; i++) {
			char current = alphabet.charAt(i);
			if (character == current) {
				value = i;
				found = true;
			}
		}

		return value;
	}

} // end HashTable
