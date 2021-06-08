import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

class emp{
	int roll_no;
	String name;
	Date dob;
	Double sal;
	Type type;
	
	public static SimpleDateFormat sdf;
	
	static {
		sdf=new SimpleDateFormat("dd/MM/YYYY");
	}
	
	public emp(int roll_no, String name, Date dob, Double sal, Type type) {
		super();
		this.roll_no = roll_no;
		this.name = name;
		this.dob = dob;
		this.sal = sal;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getRoll_no() {
		return roll_no;
	}
	
	public void setRoll_no(int roll_no) {
		this.roll_no=roll_no;
	}
	
	public double getSalary() {
		return sal;
	}
	public void setsal(double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "emp [roll_no=" + roll_no + ", name=" + name + ", dob=" + dob + ", sal=" + sal + ", type=" + type + "]";
	}
	
}

 enum Type{
	GOLD,SILVER,PLATINUM
}

 class ArrayList1{
	 public static ArrayList<emp> populateSampleData() throws ParseException{
		 ArrayList<emp> al = new ArrayList<>();
		 emp e1;
		 al.add(new emp(101, "aniket",emp.sdf.parse("22/12/94"), 2000.0 ,Type.valueOf("GOLD")));
		 al.add(new emp(102, "vishal", emp.sdf.parse("1/6/96"), 25000.0, Type.valueOf("SILVER")));
		 al.add(new emp(103, "GANESH", emp.sdf.parse("18/2/98"), 35000.0, Type.valueOf("PLATINUM")));
		 
		 
		return al;
		 
	 }
	 
	 
 }
 
 class NameComparator implements Comparator<emp>
 {

	@Override
	public int compare(emp o1, emp o2) {
		int ret = o1.getName().compareTo(o2.getName());
		if(ret !=0 )
			return ret;
		return 0;
	}
	 
 }


public class Emp_Test {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			ArrayList<emp> el = new ArrayList1().populateSampleData();
			boolean exit =false;
			while(!exit) {
				System.out.println("1.Display \n2.Change Name \n3.Change Salary");
				System.out.println("Enter Choice");
				try {
					switch (sc.nextInt())
					{
					case 1:
						el.forEach(e -> System.out.println(e));
						
						break;
					case 2:
						System.out.println("Enter Name u Want To Change");
						String n = sc.next();
						System.out.println("Enter New Name ");
						String n1 = sc.next();
						for(emp e:el) {
							if(e.getName().equals(n)) {
								e.setName(n1);
							}
							else {
							System.out.println("Incorrect Name");}
						}
						break;
					case 3:
						System.out.println("Enter Roll Number U Want to Change Sal");
						int rn = sc.nextInt();
						System.out.println("Enter New Salary");
						double s = sc.nextDouble();
						for (emp e:el) {
							if (e.getRoll_no() == rn) {
								e.setsal(s);}
							else{
							System.out.println("Incorrect Roll Number");}
						}
						break;
						
					case 4:
						System.out.println("Sorting Array By Name");
						Collections.sort(el, new NameComparator());
						
					default:
						break;
					}
					
				}catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
