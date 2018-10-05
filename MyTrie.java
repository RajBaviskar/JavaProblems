

public class MyTrie {
	public class TrieNode {
		TrieNode[] arr;
		boolean isLeaf;

		public TrieNode(){
			this.arr = new TrieNode[26];
		}
	}

	private TrieNode root; 
	
	public MyTrie(){
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
			int index = c-'a';

			if(cur.arr[index] == null){
				TrieNode temp = new TrieNode();
				cur.arr[index] = temp;
				cur = temp;
			}else{
				cur = cur.arr[index];
			}
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
			int index = c-'a';
			if(cur.arr[index] != null){
				cur = cur.arr[index];
			}else{
				return null;
				
			}
		}

		return cur;
	}

	public static void main(String[] args){
		MyTrie dictionary = new MyTrie();
		dictionary.add("rajesh");
		System.out.println(dictionary.search("rajesh"));
		System.out.println(dictionary.search("rakesh"));

		dictionary.add("rakesh");
		System.out.println(dictionary.search("rakesh"));
	}
}