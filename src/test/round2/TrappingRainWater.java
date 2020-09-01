package test.round2;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println (trappingRainWater (height));
    }

    static int trappingRainWater(int[] height){

        if(height == null || height.length ==0){
            return 0;
        }

        int water = 0, left =0, right = height.length-1, level = 0;

        while(left < right){
            int lower = height[height[left] < height[right]? left++: right--];

            level = Math.max (level,lower);

            water += level - lower;
        }

        return water;
    }
}
