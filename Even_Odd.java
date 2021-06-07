import java.util.Scanner;

public class Even_Odd {

	public static void main(String[] args)
	{
		int n,k,j;
		int i;
		k=0;
		j=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Number: ");
		n = sc.nextInt();
		for (i=1; i<=n; i++)
		{
			if (i%2==0)
			{
				System.out.println(i+ "  is Even");
				k=k+1;
			}
			else
			{
				System.out.println(i+ "  is Odd");
				j=j+1;
			}
		}
		System.out.println("Totle Odd Number is = " + j +"\nTotle Even Number is = "+k);
	}

}
