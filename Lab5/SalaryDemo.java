package Lab5;
import java.util.Scanner;

//Parent CLass
abstract class Employee{

    //instance Variable
    protected String name;

    //constructor
    public Employee (String name){
        this.name=name;
    }

    //set Method
    public void setName(String name) {
        this.name = name;
    }

    //get method
    public String getName(){
        return name;
    }

    //abstract method to be overridden
    public abstract double weeklyPay(int hours);
}

    // 1st degree Inheritance
    class HourlyEmployee extends Employee{

        //instance variable for Hourly Employee
        private double hourlyWage;

        //constructs a hourly employee witha given name(from parent) and weekly wage
        public HourlyEmployee(String name, double hourlyRate){
            super(name);
            this.hourlyWage = hourlyRate;
        }
@Override
        //calling abstract method with own implimentation
        public double weeklyPay(int hours){
            if (hours  <= 40) {
                return hourlyWage * hours;
                //if hourly employee work overtime = Overtime hours * 1.5
            }else {
                double overtime = (hours - 40) * hourlyWage * 1.5;
                return ( 40* hourlyWage) + overtime;
            }
        }
}


    //Salaried Employees - 1st degree inheritance
        class SalaryEmployee extends Employee{

    private double annualSalary;

    public SalaryEmployee(String name, double annualSalary){
        super(name);
        this.annualSalary = annualSalary;
    }

    @Override
        public double weeklyPay(int hours){
        return annualSalary / 52;
        }
    }

    // Second Degree Inheritance
        class Manager extends SalaryEmployee{
    private double WeeklyBonus;

    public Manager(String name, double salary, double bonus){
        super(name, salary);
        this.WeeklyBonus = bonus;
    }

    @Override
        public double weeklyPay(int hours){
        return super.weeklyPay(hours) + WeeklyBonus;
    }
    }

//mian method
public class SalaryDemo {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            Employee[] staff = new Employee[3];

            staff[0] = new HourlyEmployee("Harry", 300); // Hourly Employee
            staff[1] = new SalaryEmployee("Sally", 52000); // Salaried Employee
            staff[2] = new Manager("Mary", 104000, 50); // Manager



            for (Employee i : staff) {
                System.out.println( "Salary for Employee : " + i.getName() );
                System.out.print("Please Enter No. of Hour Worked by " + i.getName() + ":");
                int hours = sc.nextInt();
                System.out.println(" ");


                double payment = i.weeklyPay(hours);

                System.out.println("Weekly Pay is " + payment);
                System.out.println(" ");
            }

            sc.close();
        }
}