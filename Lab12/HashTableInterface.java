public interface HashTableInterface<K, V> {

	public boolean tableIsEmpty();

	public int tableLength();

// if key is not already in HashTable inserts association (key,value) and returns true
// if key is already in the HashTable it does not re-insert and returns false
	public boolean tableInsert(K key, V value);

// if key is in HashTable deletes the key and its association from the HashTable and returns true
// if key is not in the HashTable returns false
	public boolean tableDelete(K searchKey);

//returns the value associated with searchKey in the HashTable or null if the serchKey is not in the HashTable 
	public V tableRetrieve(K searchKey);

// returns the integer hashCode computed using Horner's rule - assumes K is String 
	public int hashCode(K key);

//display all (key,value) associations in the HashTable
	public String toString();

} // end HashTableInterface