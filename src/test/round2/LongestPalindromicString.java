package test.round2;

public class LongestPalindromicString {

    public static void main(String[] args) {
        System.out.println (findLongestPalindrome ("this is malayalam and works for tamil"));
    }

    static String findLongestPalindrome(String string){

        if(string == null || string.length () ==0){
            return "";
        }
        String output = "";

        for(int i = 0; i<string.length ();i++){
            String odd = findPalindrome (string,i,i);
            if(odd.length ()>output.length ()){
                output = odd;
            }
            String even = findPalindrome (string,i,i+1);
            if(even.length () > output.length ()){
                output = even;
            }
        }

        return output;
    }

    static String findPalindrome(String string, int left, int right){
        int l = left;
        int r = right;
        int n = string.length ();

        while(l>=0 && r < n && string.charAt (l)== string.charAt (r)){
            l--;
            r++;
        }
        return string.substring (l+1,r);
    }
}
