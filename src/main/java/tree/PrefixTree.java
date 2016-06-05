package tree;

/**
 * Created by gs on 2016-06-05.
 */
public class PrefixTree {


    final static int SIZE = 'z' - 'a' + 1;

    static class Trie {
        static class Node {
            Node[] children = new Node[SIZE];
            boolean isLeaf;
            int count;
        }

        Node root = new Node();

        void add(String word) {

            Node current = root;

            for (int i = 0; i < word.length(); i++) {
                int index = (int) word.charAt(i) - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new Node();
                    current = current.children[index];
                } else {
                    current = current.children[index];
                }
                current.count++;

            }
            current.isLeaf = true;

        }

        int findPrefix(String word) {
            Node current = root;
            for (int i = 0; i < word.length(); i++) {
                int index = (int) word.charAt(i) - 'a';
                if (current.children[index] != null) {
                    current = current.children[index];
                } else {
                    return 0;
                }
            }
            if (current == null) return 0;
            else {
                return current.count;
            }
        }
    }

    public static void main(String[] args) {
        Trie prefixTree = new Trie();


        prefixTree.add("hack");
        prefixTree.add("hackerrank");
        System.out.println(prefixTree.findPrefix("ha"));
    }
}
