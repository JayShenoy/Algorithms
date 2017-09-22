import java.io.*;
import java.util.*;
import java.time.Duration;
import java.time.Instant;

public class DictionaryViewer {
	private Dictionary d;

	public DictionaryViewer(Dictionary d) {
		this.d = d;
	}

	public void search(String key) {
		boolean keyExists = d.contains(key);

		if(keyExists) {
			System.out.println("The word '" + key + "' is in the dictionary.");
		} else {
			String original = key;

			// Keep shortening the key until it exists as a prefix in dictionary
			while(d.findAll(key).isEmpty()) {
				key = key.substring(0, key.length() - 1);
				if(key.equals("")) {
					System.out.println("There are no words similar to '" + original + "' in the dictionary.");
					return;
				}
			}

			List<String> similarWords = d.findAll(key);
			System.out.println("The word '" + original + "' is not in the dictionary.");
			System.out.println("However, these are the most similar words:");

			for(String word : similarWords)
				System.out.println(word);
		}
	}

	public static void main(String[] args) {
		Instant start = Instant.now();
		Dictionary d = new Dictionary("dictionary.txt");
		Instant end = Instant.now();
		Duration diff = Duration.between(start, end);
		double diffSeconds = diff.toMillis() / 1000.0;
		System.out.println("Time to load dictionary: " + diffSeconds + " seconds.");

		DictionaryViewer dv = new DictionaryViewer(d);
		Scanner s = new Scanner(System.in);

		System.out.println("Welcome to Dictionary Viewer!");
		System.out.println("Using this Java program, you can browse the English dictionary.");
		System.out.println("Type a word to see if it is in the dictionary, or click enter to exit:");
		String searchTerm = s.nextLine();

		while(!searchTerm.isEmpty()) {
			dv.search(searchTerm);
			System.out.println("Type another word to see if it is in the dictionary, or click enter to exit:");
			searchTerm = s.nextLine();
		}
	}
}