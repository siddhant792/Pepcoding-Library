import java.util.Scanner;

public class l001Pattern {

    public static void Pattern1(int n) {
        int nst = 1;
        for (int i = 1; i <= n; i++) {
            for (int cst = 1; cst <= nst; cst++) {

                System.out.print("*" + "\t");

            }

            System.out.print("\n");
            nst++;
        }
    }

    public static void Pattern2(int n) {
        int nst = n;
        for (int i = 1; i <= n; i++) {
            for (int cst = 1; cst <= nst; cst++) {

                System.out.print("*" + "\t");

            }

            System.out.print("\n");
            nst--;
        }
    }

    public static void Pattern3(int n) {
        int nst = 1;
        int nos = n-1;
        for (int i = 1; i <= n; i++) {
            for (int cst = 1; cst <= nos; cst++) {

                System.out.print("\t");

            }

            for (int cst = 1; cst <= nst; cst++) {

                System.out.print("*"+"\t");

            }
            

            System.out.print("\n");
            nst++;
            nos--;
        }
    }

    public static void Pattern4(int n) {
        int nst = n;
        int nos = 0;
        for (int i = 1; i <= n; i++) {
            for (int cst = 1; cst <= nos; cst++) {

                System.out.print("\t");

            }

            for (int cst = 1; cst <= nst; cst++) {

                System.out.print("*"+"\t");

            }
            

            System.out.print("\n");
            nst--;
            nos++;
        }
    }

    public static void Pattern5(int n) {
        int nst = 1;
        int nos = n/2;
        for (int i = 1; i <= n; i++) {
            for (int cst = 1; cst <= nos; cst++) {
                System.out.print("\t");
            }

            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*"+"\t");
            }
            if(i <= n/2){
                nos--;
                nst = nst+2;
            }else{
                nos++;
                nst = nst-2;
            }

            System.out.println(" ");

        }
    }

    public static void Pattern6(int n) {
        int nst = (n+1)/2;
        int nos = 1;
        for (int i = 1; i <= n; i++) {
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*"+"\t");
            }

            for (int cst = 1; cst <= nos; cst++) {
                System.out.print("\t");
            }

            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*"+"\t");
            }
            if(i<=n/2){
                nos = nos+2;
                nst--;
            }else{
                nos = nos-2;
                nst++;
            }
            

            System.out.println(" ");

        }
    }

    public static void Pattern15(int n){
        int space = n/2;
        int count = 1;
        int row = 0;
        for(int i=1;i<=n;i++){

            for(int csp = 1;csp<=space;csp++){
                System.out.print("\t");
            }

            int number = row;
            for(int num=1;num<=count;num++){
                if(num<=(count+1)/2){
                    number++;
                }else{
                    number--;
                }

                System.out.print(number+"\t");
            }

            for(int csp = 1;csp<=space;csp++){
                System.out.print("\t");
            }

            if(i<=n/2){
                space--;
                count += 2;
                row++;
            }else{
                space++;
                count -= 2;
                row--;
            }

            System.out.println("");

        }


    }

    public static void Pattern7(int n) {
        int nst = 1;
        for (int i = 1; i <= n; i++) {
            for (int cst = 1; cst <= nst; cst++) {
                if(cst==i){
                    System.out.print("*"+"\t");
                }else{
                    System.out.print("\t");
                }
            }
            nst++;
            System.out.println(" ");
        }
    }

    public static void Pattern8(int n) {
        int nst = n;
        for (int i = 1; i <= n; i++) {
            for (int cst = 1; cst <= nst; cst++) {
                if(cst==nst){
                    System.out.print("*"+"\t");
                }else{
                    System.out.print("\t");
                }
            }
            nst--;
            System.out.println(" ");
        }
    }


    public static void Pattern9(int n) {
        int star1 = 1;
        int star2 = n;
        for (int i = 1; i <= n; i++) {
            for(int cst =1;cst<=n;cst++){
                if(cst == star1 || cst == star2){
                    System.out.print("*"+"\t");
                }else{
                    System.out.print("\t");
                }
            }

            star1++;
            star2--;
            System.out.println(" ");
        }
    }

    public static void Pattern10(int n) {
        int star1 = (n+1)/2;
        int star2 = (n+1)/2;
        for (int i = 1; i <= n; i++) {
            for(int cst =1;cst<=n;cst++){
                if(cst == star1 || cst == star2){
                    System.out.print("*"+"\t");
                }else{
                    System.out.print("\t");
                }
            }
            if(i<=n/2){
                star1++;
                star2--;
            }else{
                star2++;
                star1--;
            }
            
            System.out.println(" ");
        }
    }

    public static void Pattern11(int n) {

        int star = 1;
        int value = 1;
        for (int i = 1; i <= n; i++) {
            for (int cst = 1; cst <= i; cst++) {
                if (cst <= star) {
                    System.out.print(value+"\t");
                    value++;

                }
            }
            star++;
            System.out.println("");

        }

    }


public static void Pattern12(int n) {

    int star = 1;
    int a = 0;
    int b = 1;
    int sum;
    for (int i = 1; i <= n; i++) {
        for (int cst = 1; cst <= i; cst++) {
            if (cst <= star) {
                System.out.print(a+"\t");  
                sum = a+b; 
                a = b;
                b = sum; 
            }
        }
        star++;
        System.out.println("");

    }

}

public static void Pattern13(int n){
    for (int i = 0; i < n; i++) {
        int value = 1;
        for (int cst = 0; cst <= i; cst++) {
            System.out.print(value+"\t"); 
            value = ((i-cst)*value/(cst+1));
        }
        System.out.println("");

    }

}

public static void Pattern14(int n){

    for(int i=1;i<=10;i++){
        int ans = n*i;
        System.out.println(n+" * "+i+" = "+ans);
    }

}

public static void Pattern16(int n){
    int num1 = 1;
    int num2 = (n*2)-1;
    for(int i=1;i<=n;i++){
        int count1 = 1;
        int count2;
        if(i==n) count2 = i-1;
        else count2 = i;
        for(int cst=1;cst<=(n*2)-1;cst++){
            if(cst<=num1){
                System.out.print(count1+"\t");
                count1++;
            }else if(cst>=num2){
                System.out.print(count2+"\t");
                count2--;
            }else{
                System.out.print("\t");
            }

        }
        num1++;
        num2--;
        System.out.println("");
    }

}

public static void Pattern17(int n){
    int star = 1;
    for(int i=1;i<=n;i++){
        int star_count = 1;
        for(int cst=1;cst<=n;cst++){
            if(cst>n/2){
                if(star_count<=star){
                    System.out.print("*"+"\t");
                    star_count++;
                }else{
                    System.out.print("\t");
                }
            }else if(cst<=(n+1)/2 && i == (n+1)/2){
                System.out.print("*"+"\t");
            }else{
                System.out.print("\t");
            }
        }
        if(i<=n/2){
            star++;
        }else{
            star--;
        }

        System.out.println("");


    }

}

public static void Pattern18(int n){
    int space1 = 0;
    int space2 = n+1;
    int new_space1=1;
    int new_space2=n;
    for(int i=1;i<=n;i++){
        for(int cst=1;cst<=n;cst++){
            if(cst<=space1 || cst>=space2){
                System.out.print("\t");
            }else if(i!=1 && i<=n/2 && cst==new_space1){
                System.out.print("*"+"\t");
            }else if(i!=1 && i<=n/2 && cst==new_space2){
                System.out.print("*"+"\t");
            }else if(i!=1 && i<=n/2 && cst!=new_space1){
                System.out.print("\t");
            }else if(i!=1 && i<=n/2 && cst!=new_space2){
                System.out.print("\t");
            }else{
                System.out.print("*"+"\t");
            }
        }
        if(i<=n/2){
            space1++;
            space2--;
        }else{
            space1--;
            space2++;
        }
        new_space1++;
        new_space2--;
        System.out.println("");
    }
}

public static void Pattern20(int n){
    int star1 = (n+1)/2;
    int star2 = (n+1)/2;
    for(int i=1;i<=n;i++){
        for(int cst=1;cst<=n;cst++){
            if(i<=n/2){
                if(cst==1 || cst==n){
                    System.out.print("*"+"\t");
                }else{
                    System.out.print("\t");
                }
            }else{
                if(cst==1 || cst==n){
                    System.out.print("*"+"\t");
                }else if(cst==star1 || cst == star2){
                    System.out.print("*"+"\t");
                }else{
                    System.out.print("\t");
                }
            }
        }
        if(i>n/2){
            star1--;
            star2++;
        }
        System.out.println("");
    }
}

public static void Pattern19(int n){

 for(int i=1; i<=n ;i++){

    for(int star=1;star<=n;star++){
        if(i==1){
            if(star<=(n+1)/2 || star == n){
                System.out.print("*"+"\t");
            }else{
                System.out.print("\t");
            }
        }else if(i==n){
            if(star>=(n+1)/2 || star == 1){
                System.out.print("*"+"\t");
            }else{
                System.out.print("\t");
            }
        }else if(i==(n+1)/2){
            System.out.print("*"+"\t");
        }else if(i<=n/2 && i!=1){
            if(star==(n+1)/2 || star == n){
                System.out.print("*"+"\t");
            }else{
                System.out.print("\t");
            }
             
        }else if(i>=n/2 && i!=n){
            if(star==(n+1)/2 || star == 1){
                System.out.print("*"+"\t");
            }else{
                System.out.print("\t");
            }
             
        }
    }

    System.out.println("");

 }   

}



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
          int num = scn.nextInt();
          Pattern19(num);
     }
}
