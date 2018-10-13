
import java.util.*;

public class MyTrieWithHash {
	public class TrieNode {
		HashMap<Character, TrieNode> hs; 
		boolean isLeaf;

		public TrieNode(){
			this.hs = new HashMap<Character, TrieNode>();
		}
	}

	private TrieNode root; 
	
	public MyTrieWithHash(){
		root = new TrieNode();
	}


	public void add(final String ipString){
		if(ipString == null){
			return;
		}
		int ipLen = ipString.length();
		TrieNode cur = root;
		for(int i = 0; i < ipLen; i++){
			char c = ipString.charAt(i);
			TrieNode node = cur.hs.get(c);

			if(node == null){
				node = new TrieNode();
				cur.hs.put(c,node);
			}
			cur = node;
		}
		cur.isLeaf = true;
	}

	public boolean search(final String ipString){
		TrieNode node = searchNode(ipString);

		if(node == null){
			return false;
		}else{
			if (node.isLeaf){
				return true;
			}
		}
		return false;
	}

	public TrieNode searchNode(final String ipString){
		if(ipString == null){
			return null;
		}

		int ipLen = ipString.length();
		TrieNode cur = root;
		for(int i = 0; i < ipLen; i++){
			char c = ipString.charAt(i);
			TrieNode node = cur.hs.get(c);
			if(node != null){
				cur = node;
			}else{
				return null;
			}
		}

		return cur;
	}

	public static void main(String[] args){
		MyTrieWithHash dictionary = new MyTrieWithHash();
		dictionary.add("rajesh");
		System.out.println(dictionary.search("rajesh"));
		System.out.println(dictionary.search("rakesh"));

		dictionary.add("rakesh");
		System.out.println(dictionary.search("rakesh"));
	}
}
