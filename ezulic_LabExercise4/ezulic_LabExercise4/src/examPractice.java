public class examPractice {
    public static void main(String[] args) {
        int x = 2138148,  y = 253928;
        int gcd = 1;

        //x= 348238;
        //y = 4598723; output of gcd of these 2 is 1

        if(y>x){
            int placeHold = x;
            x = y;
            y = placeHold;
            //swap the values if y is bigger than x
        }

        for(int i = 1;i<=y;i++){
            if(x%i==0 && y%i==0){
                gcd = i;
            }
            //i is incremented until it reaches y, once x mod i and y mod i are both equal to 0 i is assigned to the gcd
        }

        System.out.print(gcd);


    }
}
