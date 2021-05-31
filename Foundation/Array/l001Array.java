import java.util.Arrays;
import java.util.Scanner;



public class l001Array {


    public static int maxElement(int[] arr){
        int max = (int) -1e8;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;

    }

    public static int minElement(int[] arr){
        int min = (int) 1e8;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;

    }

    public static int findNumber(int[] arr,int data){
        int ele = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==data){
                ele = i;
                break;
            }
        }
        return ele;
    }

    public static int firstIndex(int[] arr,int data){
        int ele = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==data){
                ele = i;
                break;
            }
        }
        return ele;
    }

    public static int lastIndex(int[] arr,int data){
        int ele = -1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==data){
                ele = i;
                break;
            }
        }
        return ele;
    }

    public static void SumOfArray_new(int[] arr1,int[] arr2){
        int max;
        int carry = 0;
        int point_1 = arr1.length-1;
        int point_2 = arr2.length-1;
        if(arr1.length>=arr2.length){
            max = arr1.length;
        }
        else{
            max = arr2.length;
        } 
        int[] arr_out = new int[max];
        for(int i=max-1;i>=0;i--){
            if(point_1>=0 && point_2>=0){
                if(arr1[point_1]+arr2[point_2] + carry >= 9){
                    arr_out[i] = (arr1[point_1]+arr2[point_2] + carry)%10;
                    carry = (arr1[point_1]+arr2[point_2]+ carry)/10;
                }else{
                    arr_out[i] = arr1[point_1]+arr2[point_2] + carry;
                    carry = 0;
                }
            }else{
                if(point_1<0){
                    if(0+arr2[point_2] + carry >= 9){
                        arr_out[i] = (0+arr2[point_2] + carry)%10;
                        carry = (0+arr2[point_2]+ carry)/10;
                    }else{
                        arr_out[i] = 0+arr2[point_2] + carry;
                        carry = 0;
                    }
                }else if(point_2<0){
                    if(arr1[point_1]+0 + carry >= 9){
                        arr_out[i] = (arr1[point_1]+0 + carry)%10;
                        carry = (arr1[point_1]+0+ carry)/10;
                    }else{
                        arr_out[i] = arr1[point_1]+0 + carry;
                        carry = 0;
                    }
                }
                
            }
            point_1--;
            point_2--;
        }
        for(int i=0;i<arr_out.length;i++){

            System.out.println(arr_out[i]);

        }
    }

    public static void ReverseOfArray(int[] arr){
        int[] arr_new  = new int[arr.length];
        int max = arr.length-1;
        for(int i=0;i<arr.length;i++){
            arr_new[i] = arr[max];
            max--;
        }
        for(int i=0;i<arr_new.length;i++){
            System.out.println(arr_new[i]);
        }
    }

    

    public static int digitFrequency(int number,int d){
        int find = d;
        int num = number;
        int count = 0;
        while(num!=0){
            int temp = num%10;
            if(temp == find) count++;
            num = num/10;
        }

        return count;
    }

    public static void decimalToAnyBase(int n,int base){
        int result = n;
        int power =1;
        int final_num = 0;
        while(result!=0){           
            final_num =  final_num + (result%base)*power ;
            result = result/base;
            power = power*10;
        }
        System.out.println(final_num);
        
    }

    public static void subtractionOfArray(int[] arr1,int[] arr2){
    
        int max = arr2.length;
        int carry = 0;
        int point1 = arr1.length-1;
        int point2 = arr2.length-1;
        int[] arr_diff = new int[max];
        for(int i= max-1;i>=0;i--){
            if(point1>=0){
                if(arr2[point2]+carry>=arr1[point1]){
                    arr_diff[i] = (arr2[point2] + carry) - arr1[point1];
                    carry = 0;
                }else{
                    arr_diff[i] = ((arr2[point2]+10) +carry) - arr1[point1];
                    carry = -1;
                }
            }else{
                if(arr2[point2]+carry>=0){
                    arr_diff[i] = (arr2[point2]+carry) - 0;
                    carry = 0;
                }else{
                    arr_diff[i] = ((arr2[point2]+10)+carry) - 0;
                    carry = -1;
                }
            }
            
            point1--;
            point2--;
        }

        for(int i=0;i<arr_diff.length;i++){
            System.out.println(arr_diff[i]);
        }

    }

    public static int baseToDecimal(int num,int base){
        int final_num = 0;
        int power = 1;
        int number = num;
        while(number!=0){
            final_num = final_num + (power*(number%10));
            number = number/10;
            power = power*base;
        }
        return final_num;
    }

    public static void RotateArray(int[] arr, int k) {

        int length = arr.length;
        int rot;
        if (k > 0) rot = k;
        else rot = ((k % length) + length) % length;
        int real_rot;
        if (rot > length) real_rot = rot % length;
        else real_rot = rot;
        int start_new = length - real_rot;
        for (int i = start_new; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = 0; i < start_new; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    
    public static void barChart(int[] arr){
        int max = maxElement(arr);
        int tree = max;
        for(int i=0;i<max;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j]>=tree){
                    System.out.print("*"+"\t");
                }else{
                    System.out.print("\t");
                }
            }
            tree--;
            System.out.println("");
        }
    }

    //leetcode

    public static int freqCounter(int[] nums, int val) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val) count++;
        }
        return count;
    }

    public static int removeElement(int[] nums, int val) {
        int count = freqCounter(nums,val);
        for(int i=0;i<count;i++){
            if(nums[i] == val){
                int found = nums[i];
                for(int j=i;j<nums.length;j++){
                    if(j != nums.length-1){
                        nums[j] = nums[j+1];
                    }else{
                        nums[nums.length-1] = found;
                    }
                }
                --i;
            }
        }
        return count;
    }

    public static void inverseArrayOfficial(int[] arr) {

        int[] arr_new = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr_new[arr[i]] = i;
        }
        
        for (int i = 0; i < arr_new.length; i++) {
            System.out.println(arr_new[i]);
        }
    }

    public static void subArray(int[] arr){

        for(int z=0;z<arr.length;z++){
            for(int i=z;i<arr.length;i++){
                for(int j=z;j<=i;j++){
                    System.out.print(arr[j]+" ");
                }
                System.out.println("");
            }
        }
        

    }

    public static int BinarySearch(int[] arr,int value){
        int si=0;
        int ei=arr.length-1;
        while(si <= ei){
            int mid = (si+ei)/2;
            if(arr[mid] == value){
                return mid;
            }else if(value > arr[mid]){
                si = mid+1;
            }else if(value < arr[mid]){
                ei = mid-1;
            }
        }
        return -1;

    }

    public static void ceilFloor(int[] arr,int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i]>value){
                System.out.println(arr[i]);
                System.out.println(arr[i-1]);
                break;
            }
        }
    }

    public static void firstAndLastIndex(int[] arr,int value){
        int[] arr_new = new int[arr.length];
        int counter=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == value){
                arr_new[counter] = i;
                counter++;
            }
        }
        if(counter==0){
            System.out.println("-1");
            System.out.println("-1");
        }else {
            System.out.println(arr_new[0]);
            System.out.println(arr_new[counter-1]);
        } 
    }

    public static void print2dArray(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
              System.out.print(arr[i][j]+"\t");
            }  
            System.out.println("");
          }
    }

    public static void waveTraversal(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        for(int i=0;i<col;i++){
            if(i%2==0){
                for(int j=0;j<row;j++){
                    System.out.println(arr[j][i]);
                }
            }else{
                for(int j=row-1;j>=0;j--){
                    System.out.println(arr[j][i]);
                }
            }
        }
    }

    public static void entryAndExit(int[][] arr){
        int row = arr.length;
        int i=0,j=0,d=0;
        int col = arr[0].length;
        while(true){
            d = ( d + arr[i][j])% 4;
            if(d==0){
                if(j+1==col) break;
                j++;
            }else if(d==1){
                if(i+1==row) break;
                i++;
            }else if(d==2){
                if(j-1==-1) break;
                j--;
            }else{
                if(i-1==-1) break;
                i--;
            }
        }
        System.out.println(i+"\n"+j);

    }

    public static void romanToInteger(String s){
        int length = s.length();
        char alpha;
        int i=0;
        int counter = 0;  
        int prev = 10000000;
        while(i<length){
            alpha = s.charAt(i);
            System.out.println(alpha);
            switch(alpha){
                case 'I' : 
                if(1>prev){
                    counter = counter-1;
                }else{
                    counter = counter+1;
                }
                break;
                case 'V' :
                if(5>prev){
                    counter = counter-5;
                }else{
                    counter = counter+5;
                }
                break;
                case 'X' :
                if(10>prev){
                    counter = counter-10;
                }else{
                    counter = counter+10;
                }
                break;
                case 'L' :
                if(50>prev){
                    counter = counter-50;
                }else{
                    counter = counter+50;
                } 
                break;
                case 'C' :
                if(100>prev){
                    counter = counter-100;
                }else{
                    counter = counter+100;
                }
                break;
                case 'D' :
                if(500>prev){
                    counter = counter-500;
                }else{
                    counter = counter+500;
                }
                break;
                case 'M' :
                if(1000>prev){
                    counter = counter-1000;
                }else{
                    counter = counter+1000;
                }
                break;
                default:
                break;
            }

            i++;
        }
        System.out.println(counter);
    }


    public static void diagonalTraversal(int[][] arr){

        for(int gap = 0;gap<arr[0].length;gap++){
            for(int i=0,j=gap;i<arr.length && j<arr[0].length;i++,j++){
                System.out.println(arr[i][j]);
            }
        }
        
    }
    public static void saddlePoint(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int temp1 = (int)1e8;
        int j1 = 0;
        for(int i=0;i<row;i++){

            for(int j=0;j<col;j++){
                if(arr[i][j]<temp1){
                    temp1 = arr[i][j];
                    j1 = j;
                }
            }
            boolean saddlePoint = true;
            for(int r=0;r<col;r++){
                if(arr[r][j1] > temp1){
                    saddlePoint = false;
                    break;
                }
            }

            if(saddlePoint){
                System.out.println(temp1);
                return;
            } 
            
        }

        
        System.out.println("Invalid input");
    }

    public static void searchingSorted(int[][] arr,int data){
        int row = arr.length;
        int col = arr[0].length;
        int i=row-1,j=0;
        while(i>=0 && j < col){
            if(arr[i][j] == data){
                System.out.println(i+"\n"+j);
            }else if(data > arr[i][j]){
                j++;
            }else if(data < arr[i][j]){
                i--;
            }
        }
        System.out.println("Not found");
    }
    

    public static void rotate90(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        
        //transpose
        for(int i=0;i<row;i++){
            for(int j=i;j<col;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //mirror
        int c1 = 0,c2 = col-1;
        while(c1<c2){

            for(int i =0;i<row;i++){
                int e1 = arr[i][c1];
                int e2 = arr[i][c2];

                arr[i][c1] = e2;
                arr[i][c2] = e1;
            }

            c1++;
            c2--;
        }

    }

    public static void spiralTraversal(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int counter = 0;
        int layer = 1;
        int variable_i=0,variable_j=0;
        int i=0,j=0;
        while(counter<row*col){
            System.out.println(arr[i][j]);
            if(i+layer!=row && j-layer==-1){
                i++;
            }
            else if(i+layer==row && j+layer!=col){
                j++;
            }
            else if(i-layer!=-1 && j+layer==col){
                i--;
            }
            else if(i-layer==-1 && j-layer!=-1){
                
                if(i==variable_i && j-1==variable_j){
                    layer++;
                    variable_i++;
                    variable_j++;
                    i=variable_i;
                    j=variable_j;
                }else{
                    j--;
                }   
            }
            counter++;
        }
    }

    public static void shellRotate(int[][] arr,int set,int rot){
        int row = arr.length;
        int col = arr[0].length;
        int set_number = set;
        int variable_i=set_number-1,variable_j=set_number-1;
        int layer = set;
        int temp = 0;
        int r_n = (((2*(row+col))-4)-8*(layer-1));
        int rot_final = (rot%r_n + r_n)%r_n;
        System.out.println("Rot-"+rot_final);
        for(int x=0;x<rot_final;x++){
            int i=set_number-1,j=set_number-1;
            while(true){          
                if(j+layer!=col && i-layer==-1){
                    j++;  
                    temp = arr[i][j-1];
                    arr[i][j-1] = arr[i][j];
                    arr[i][j] = temp;
                }
                else if(j+layer==col && i+layer!=row){
                    i++;
                    temp = arr[i-1][j];
                    arr[i-1][j] = arr[i][j];
                    arr[i][j] = temp;
                }
                else if(j-layer!=-1 && i+layer==row){
                    j--;
                    temp = arr[i][j+1];
                    arr[i][j+1] = arr[i][j];
                    arr[i][j] = temp;
                }
                else if(j-layer==-1 && i-layer!=-1){

                    if(i-1!= variable_i && j==variable_j){
                        i--;
                        temp = arr[i+1][j];
                        arr[i+1][j] = arr[i][j];
                        arr[i][j] = temp;
                    }else{
                        break;
                    }
                }
            }
        }
        
        for(int x = 0; x < arr.length; x++){
            for(int y = 0; y < arr[0].length; y++){
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static void arrayMerge(int[] arr1,int n,int[] arr2,int m){
        int counter = 0;
        int var = m;
        for(int i = arr1.length-1;i>=0;i--){
            if(var>0){
                    arr1[i] = arr2[counter];
                    counter++;
                    var--;
                } 
        }
        //array sorting
        Arrays.sort(arr1);

        for(int i=0;i<arr1.length;i++){
            System.out.println("ele-"+arr1[i]);
        }
    }

    public static void AnyBaseAddition(int n,int m,int b){
        int result = 0,power = 1,carry = 0;
        while(n!=0 || power!=0 || carry!=0){
            int r1 = n%10;
            int r2 = m%10;
            n = n/10;
            m = m/10;
            int sum = r1+r2+carry;
            int r = sum%b;
            carry = sum/b;
            result = result + (r*power);
            power = power*10;
        }
    }

    public static int AnyBaseSubtraction(int num1,int num2,int b){
        int result = 0,power = 1,carry = 0;
        while(num1!=0 || num2!=0 || carry!=0){
            int r1 = num1%10;
            int r2 = num2%10;
            num1 = num1/10;
            num2 = num2/10;
            int sub = r2 - r1 + carry;
            if(sub<0){
                sub = sub + b;
                carry = -1;
            }else{
               carry = 0; 
            } 
            result = result + (power*sub);
            power = power*10;
        }
        return result;
    }

    public static void anyBaseMultiplication(int n,int m,int b){
        int final_result = 0,power_new = 1,base_num=0,carry_top=0;
        while(m!=0){
            int result = 0,power = 1,carry = 0,num1 = n,num2 = m;
            while( num1!=0 || carry!=0){
                int r1 = num1%10;
                int r2 = num2%10;
                num1 = num1/10;
                int res = (r1*r2) + carry;
                int num_new = res%b;
                carry = res/b;
                result = result + (num_new*power);
                power = power*10;
            }
            System.out.println("Res_init-"+result);
            final_result = final_result + (result*power_new);
            m = m/10;
            power_new = power_new*10;
        }
        int pow =1;
        while(final_result!=0 || carry_top!=0){
            int rem = final_result%10;
            final_result = final_result/10;
            int res = rem + carry_top;
            int temp = res%b;
            carry_top = res/b;
            base_num = base_num + (temp*pow);
            pow = pow*10;
        }
        System.out.println("Value-"+base_num);

    }

    public static void main(String[] args) {
        
        
        Scanner scn = new Scanner(System.in);

        //anyBaseMultiplication(4512,3203,7);
        // String s = scn.nextLine();
        // romanToInteger(s);
         //  int row = scn.nextInt();
        //    int column = scn.nextInt();
        //     int[][] arr1 = new int[row][column];
        //    for(int i=0;i<arr1.length;i++){
        //        for(int j=0;j<arr1[0].length;j++){
        //         arr1[i][j] = scn.nextInt();
        //        }  
        //      }
             //shellRotate(arr1,2,3);
        //exit_point_hcr(arr1);
        
            //  int data = scn.nextInt();
            //  npr_hcr(5,3);
     }
}
