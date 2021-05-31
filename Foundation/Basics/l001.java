import java.util.Scanner;

public class l001{
      
      public static boolean isPrime(int x){
        boolean prime = true;
        if(x==2){
            
            return true;
            
        }else if(x<=1){
            
            return false;
            
        }else{
            
            for ( int i = 2; i*i <=x ; i++ ){
                
                if (x%i==0){
                    prime = false;
                    break;
                }
                
            } 
            return prime;
        }
            
    }

    public static void printFibbo(int n){

        int a=0 , b=1;
    
        for(int temp = 1 ; temp <= n ;temp++){
            System.out.println(a);
            int sum = a+b;
            a = b;
            b = sum;

        }

}

public static int countDigits(int n){

    int count = 0;
    while(n!=0){
        n = n/10;
        count++;
    }
    return count;

}
   
   public static int countAdvance(int n , int r){
    int len = countDigits(n);
    if(len!=0){
        r = r % len;
        if(r<0) r = (r+len)%len;
    }
    int mul = 1, div = 1;
    for(int i=1 ; i<=len; i++){
        if(i <= r) div = div*10;
        else mul = mul*10;
    }

    int A = n%div;
    int B = n/div;

    return A*mul + B;
}
      

public static void DigitsOfNumber(int n) {

    int flag,power = 1;
    int len = countDigits(n);
    for(int i=1;i<len;i++){
        power = power*10;
    }
    for(int i =0;i<len;i++){
        flag = n/power;
        System.out.println(flag);
        n = n%power;
        power = power/10;
    }

}



public static void DigitsOfNumberReverse(int n) {
    int flag;
    while (n != 0) {
        flag = n%10;
        System.out.println(flag);
        n = n/10;
    }
}

public static int inverseOfNumber(int n) {

    int number = n;
    int len = countDigits(number);
    int final_number = 0;
    for (int i = 1; i <= len; i++) {
        int temp = number % 10;
        int power =1;
        for(int j=0;j<temp-1;j++){
            power = power*10;
        }
        final_number = final_number + power * i;
        number = number/10;

    }

    return final_number;

}

public static void GcdAndLcm(int n1,int n2){

    //gcd
    int start,big,gcd=1;
    if(n1>n2) {
        big = n1;
        start = n2;
    }else{
        big = n2;
        start = n1;
    }
    for(int i=start;i!=0;i--){
            if(big%i == 0 && start%i==0){
                gcd = i;
                break;
            }
    }
    System.out.println(gcd);

    //lcm
    int lcm = (n1*n2)/gcd;
    System.out.println(lcm);

}

public static int square(int n){
    return n*n;
}

public static boolean pythagorasTriplet(int n1,int n2,int n3){

    if(square(n1)+square(n2) == square(n3)) return true;
    else if(square(n2)+square(n3) == square(n1)) return true;
    else if(square(n1)+square(n3) == square(n2)) return true;
    else return false;

}
    public static void bulbToggle(int n) {

        int bulbs = n;
        for (int i = 1; i*i <= bulbs; i++) {
            System.out.println(i*i);
        }

    }
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();
        bulbToggle(num);
  
   }
   
  }