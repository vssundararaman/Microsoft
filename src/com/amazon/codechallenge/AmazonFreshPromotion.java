package com.amazon.codechallenge;

public class AmazonFreshPromotion {

    public static void main(String[] args) {
        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        System.out.println(solve(codeList1, shoppingCart1));
    }

    static int solve(String[][]codelist, String[]shoppingCart){

        //PriceWinner - if the code is empty
        if(codelist == null || codelist.length == 0){
            return 1;
        }
        //Not price
        if(shoppingCart == null || shoppingCart.length == 0){
            return 0;
        }

        int i = 0, j = 0;
        for(int k = 0 ; k < shoppingCart.length; k++){

            System.out.println (" *** " + codelist[i][j]);
            System.out.println (" **** " + shoppingCart[k]);

            if(codelist[i][j].equals (shoppingCart[k]) || codelist[i][j].equals ("anything")){
                j++;
                if(j == codelist[i].length){
                    i++;
                    j = 0;
                }
                if(i == codelist.length){
                    return 1;
                }
            }else{
                j = codelist[i][0].equals ("anything")? 1:0;
            }
        }
        return 0;
    }
}


