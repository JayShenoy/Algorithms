public class HashNode<K, V> {
  private K key;
  private V value;
  private HashNode<K, V> next;

  public HashNode(K key, V value) {
    this.key = key;
    this.value = value;
    this.next = null;
  }

  public HashNode(K key, V value, HashNode<K, V> next) {
    this.key = key;
    this.value = value;
    this.next = next;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public K getKey() {
    return this.key;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public V getValue() {
    return this.value;
  }

  public HashNode<K, V> getNext() {
    return this.next;
  }

  public void setNext(HashNode<K, V> next) {
    this.next = next;
  }
}