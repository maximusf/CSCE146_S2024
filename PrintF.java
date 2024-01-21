import java.util.Scanner;

public class PrintF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 Scanner sc=new Scanner(System.in);
		 System.out.println("================================");
         for(int i=0;i<3;i++){
             String s1=sc.next();
             int x=sc.nextInt();
             
             
             
             // left-justified string with a total of 15 characters
              System.out.printf("%-15s",s1);
             
             
             
             // digits start at 16th character
             // gives the right-justified 3-digits 0-padding
             if(x < 100 && x>10){ 
                 System.out.printf("%02d",x);
             } else if (x<10 && x>0){
                 
                 System.out.printf("%01d",x);
             }
             
            System.out.println();
         }
         
         System.out.println("================================");
		
		sc.close();
		
		
		
		
//		printf() =  an optional method to control, format, and display text to the console window
//					two arguments = format string + (object/variable/value)
//					% [flags] [precision] [width] [conversion-character]
		
//		boolean myBoolean = true;
//		char myChar = '@';
//		String myString = "Bro";
//		int myInt = 50;
//		double myDouble = 1000;
//		
		// [conversion-character]
//		System.out.println("Hello boolean" + myBoolean);
//		System.out.printf("Hello boolean, %b",myBoolean);
//		System.out.printf("%c",myChar);
//		System.out.printf("%s",myString);
//		System.out.printf("%d",myInt); //%d works for integers
//		System.out.printf("%f",myDouble); //%f works for floats and doubles
		
		// [width]
		// minimum number of characters to be written as output
//		System.out.printf("Hello %10s",myString);
		
		// [precision]
		// sets number of digits of precision when outputting floating-point values
//		System.out.printf("You have this much money %.2f ",myDouble);
		
		// [flags]
		// adds an effect to output on the flag added to format specifier
		// - : left-justify
		// + : output a plus ( + ) or minus ( - ) sign for a numeric value
		// 0 : numeric values are zero-padded
		// , : comma grouping separator if numbers > 1000
//		System.out.printf("You have this much money %20f ",myDouble); //myDouble is right-justified by 20 characters
//		System.out.printf("You have this much money %+f ",myDouble); //adds '+' before myDouble value if it's positive, else add '-' before myDouble value if it's negative
//		System.out.printf("You have this much money %020f ",myDouble); //adds 0s before myDouble value
//		System.out.printf("You have this much money %,f ",myDouble); //adds a comma to the thousands place
		
		
		
		
	}

}
