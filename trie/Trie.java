import java.util.*;

public class Trie {
  private TrieNode root;

  public Trie() {
  	this.root = new TrieNode();
  }

  public void insert(String key) {
  	key = key.toLowerCase();

  	TrieNode current = root;

  	for(int i = 0; i < key.length(); i++) {
  		// Check that character is within lowercase alphabet
  		char currentChar = key.charAt(i);
  		if(currentChar - 97 < 0 || currentChar - 97 >= 26) return;

  		TrieNode next = current.getLink(currentChar);

  		if(next == null) {
  			next = new TrieNode(currentChar);
  			current.addLink(next);
  		}

  		current = next;
  	}

  	current.setIsEnd(true);
  }

  public boolean search(String key) {
  	key = key.toLowerCase();

  	TrieNode current = root;

  	for(int i = 0; i < key.length(); i++) {
  		// Check that character is within lowercase alphabet
  		char currentChar = key.charAt(i);
  		if(currentChar - 97 < 0 || currentChar - 97 >= 26) return false;

  		TrieNode next = current.getLink(currentChar);

  		if(next == null) return false;

  		current = next;
  	}

  	return current.isEnd();
  }

  public List<String> startsWith(String prefix) {
  	List<String> keys = new ArrayList<>();

  	// Traverse prefix in trie
  	prefix = prefix.toLowerCase();
  	TrieNode current = root;
  	for(int i = 0; i < prefix.length(); i++) {
  		TrieNode next = current.getLink(prefix.charAt(i));

  		if(next == null) return keys;

  		current = next;
  	}

  	// Generate all possible keys by traversing suffixes
  	Stack<Pair<TrieNode, String>> combos = new Stack<>();
  	combos.push(new Pair<>(current, prefix));

  	while(!combos.isEmpty()) {
  		Pair<TrieNode, String> pairPrefix = combos.pop();
  		TrieNode toCheck = pairPrefix.getLeft();
  		String possibleKey = pairPrefix.getRight();

  		if(toCheck.isEnd()) keys.add(possibleKey);

  		// Iterate over all possible next characters
  		for(TrieNode link : toCheck.getAllLinks()) {
  			if(link == null) continue;

  			combos.push(new Pair<>(link, possibleKey + link.getValue()));
  		}
  	}

  	return keys;
  }

  public static void main(String[] args) {
  	Trie t = new Trie();
  	t.insert("fuckyou");
  	System.out.println(t.search("fuck"));
  	t.insert("fuck");
  	System.out.println(t.search("fuck"));
  	System.out.println(t.startsWith("fu"));
  }
}