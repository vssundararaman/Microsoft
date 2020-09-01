package test.round1;

import java.util.*;

public class ProductSuggestion {

    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";

        System.out.println (suggestedProducts (products,searchWord));
        System.out.println (suggestedProducts1 (products,searchWord));
    }

    static List<List<String>> suggestedProducts(String[] products, String searchWord){

        Arrays.sort (products);

        Trie root = new Trie ();

        for(String product: products){

            Trie n = root;
            for(char ch: product.toCharArray ()){
                int i = ch - 'a';
                if(n.next[i]==null){
                    n.next[i]= new Trie ();
                }

                n = n.next[i];
                if(n.words.size () < 3){
                    n.words.add (product);
                }
            }
        }

        List<List<String>> result = new ArrayList<> ();
        Trie n = root;

        //Start going over the search word char by
        for(int i=0;i<searchWord.length ();i++){
            n = n.next[searchWord.charAt (i)-'a'];

            // if we net null - means no word matches possible, the result can be filled with empty lists
            if(n == null){
                for(int j = 1; j<searchWord.length ();j++){
                    result.add (Collections.EMPTY_LIST);
                    break;
                }
            }

            result.add (n.words);
        }

        return result;
    }

    static List<List<String>> suggestedProducts1(String[] products, String searchWord) {

        int low = 0;
        int high = 0;
        List<List<String>> lsResult = new ArrayList<>();

        Arrays.sort(products);
        //System.out.println(Arrays.toString(products));

        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);
            while(low < products.length && !products[low].startsWith(prefix)) {
                low++;
            }

            //if no word can be found.
            if(low == products.length) {
                for(int j = i; j < searchWord.length(); j++) {
                    lsResult.add(new ArrayList<>());
                }
                break;
            }

            List<String> ls = new ArrayList<>();
            high = low + 1;
            while(high < low + 3 && high < products.length && products[high].startsWith(prefix)) {
                high++;
            }

            for (int j = low; j < high; j++) {
                ls.add(products[j]);
            }

            lsResult.add(ls);
        }
        return lsResult;
    }
}

