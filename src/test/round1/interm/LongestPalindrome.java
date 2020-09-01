package test.round1.interm;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println (longestPalindrome ("thisismalayalamthats it"));
        System.out.println (longestPalindrome ("cbbd"));
    }

    //Expand Around Center
    static String longestPalindrome(String string){
        String output = "";
        int n = string.length ();

        for( int i = 0; i<n; i++){

            String odd = expandOnTheCenter(string,i,i);
            if(odd.length ()>output.length ()){
                output = odd;
            }

            String even = expandOnTheCenter (string,i,i+1);
            if(even.length ()>output.length ()){
                output = even;
            }
        }

        return output;
    }

    private static String expandOnTheCenter(String string, int left, int right) {
        int l = left;
        int r = right;
        int n = string.length ();

        while(l>=0 && r<n && string.charAt (l)== string.charAt (r)){
            l--;
            r++;
        }

        return string.substring (l+1,r);
    }
}
