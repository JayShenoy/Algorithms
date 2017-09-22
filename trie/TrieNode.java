public class TrieNode {
  private char value;
  private boolean isEnd;
  private TrieNode[] links = new TrieNode[26];

  public TrieNode() {
    this.isEnd = false;
  }

  public TrieNode(char value) {
    this.value = value;
    this.isEnd = false;
  }

  public void addLink(TrieNode node) {
    char nodeValue = node.getValue();
    links[nodeValue - 97] = node;
  }

  public TrieNode getLink(char value) {
    return links[value - 97];
  }

  public TrieNode[] getAllLinks() {
    return this.links;
  }

  public char getValue() {
    return value;
  }

  public void setValue(char value) {
    this.value = value;
  }

  public boolean isEnd() {
    return isEnd;
  }

  public void setIsEnd(boolean isEnd) {
    this.isEnd = isEnd;
  }
}