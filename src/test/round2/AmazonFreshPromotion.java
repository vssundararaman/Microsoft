package test.round2;

public class AmazonFreshPromotion {

    public static void main(String[] args) {
        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "orange", "orange", "banana"};

        String[][] codeList7= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "apple", "apple", "banana", "banana"};

        System.out.println (winPrize (codeList1,shoppingCart1));

        System.out.println (winPrize (codeList7,shoppingCart7));
    }

    static int winPrize(String[][] codeList, String[] shoppingCart){
        if(codeList == null || codeList.length ==0){
            return 1;
        }

        if(shoppingCart == null || shoppingCart.length ==0){
            return 0;
        }

        int i = 0, j = 0;

        for(int k = 0; k< shoppingCart.length;k++){
            if(codeList[i][j] == shoppingCart[k] || codeList[i][j] == "anything"){
                j++;
                if(j == codeList[0].length){
                    i++;
                    j=0;
                }

                if(i == codeList.length){
                    return 1;
                }
            }
            else{
                j = codeList[i][0] == "anything" ? 1: 0;
            }
        }

        return 0;
    }
}
