import java.io.*;
import java.util.List;

public class Dictionary {
	private Trie dict;

	public Dictionary(String filePath) {
		this.dict = new Trie();

		BufferedReader br = null;
		try {
			File dictFile = new File(filePath);
			br = new BufferedReader(new FileReader(dictFile));
			String key = br.readLine();

			while(key != null) {
				dict.insert(key);
				key = br.readLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean contains(String key) {
		return dict.search(key);
	}

	public List<String> findAll(String prefix) {
		return dict.startsWith(prefix);
	}
}