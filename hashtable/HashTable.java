public class HashTable<K, V> {
  private HashNode<K, V>[] buckets;
  private int size;
  private int numBuckets;
  public static final double MAX_LOAD_FACTOR = 0.7;

  public HashTable() {
    this.buckets = new HashNode[100];
    this.size = 0;
    this.numBuckets = 100;
  }

  public V get(K key) {
    HashNode<K, V> node = buckets[hashIndex(key)];

    while(node != null) {
      if(key.equals(node.getKey()))
        return node.getValue();
      node = node.getNext();
    }

    return null;
  }

  private int hashIndex(K key) {
    int hashCode = key.hashCode();
    return hashCode % numBuckets;
  }

  public int getSize() {
    return this.size;
  }

  public void add(K key, V value) {
    HashNode<K, V> node = buckets[hashIndex(key)];

    // Increment number of filled buckets if this bucket contains no nodes
    if(node == null) size++;

    while(node != null) {
      if(key.equals(node.getKey())) {
        node.setValue(value);
        return;
      }
    }

    HashNode<K, V> firstNode = buckets[hashIndex(key)];
    node = new HashNode<>(key, value, firstNode);
    buckets[hashIndex(key)] = node;

    // Make hash table larger if too many buckets are filled
    checkLoadFactor();
  }

  public void remove(K key) {
    HashNode<K, V> node = buckets[hashIndex(key)];

    if(node != null && key.equals(node.getKey())) {
      buckets[hashIndex(key)] = node.getNext();
      if(node.getNext() == null) size--;
      return;
    }

    while(node.getNext() != null) {
      HashNode<K, V> nextNode = node.getNext();

      if(key.equals(nextNode.getKey())) {
        node.setNext(nextNode.getNext());
        return;
      }

      node = nextNode;
    }
  }

  private void checkLoadFactor() {
    double loadFactor = 1.0 * size / numBuckets;

    if(loadFactor > MAX_LOAD_FACTOR) {
      numBuckets = numBuckets * 2;
      HashNode<K, V>[] oldBuckets = buckets;
      buckets = new HashNode[size];

      for(HashNode<K, V> bucket : oldBuckets) {
        HashNode<K, V> node = bucket;

        while(node != null) {
          add(node.getKey(), node.getValue());
          node = node.getNext();
        }
      }
    }
  }

  public static void main(String[] args) {
    HashTable<String, Integer> ht = new HashTable<>();
    ht.add("Hello", 500);
    System.out.println(ht.get("Hello"));
    ht.add("Hello", 600);
    System.out.println(ht.get("Hello"));
    ht.remove("Hello");
    System.out.println(ht.get("Hello"));
  }
}