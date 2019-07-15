import java.util.*;
import java.util.stream.Collectors;

public class EmployeesExample {


    public static void main(String []args)
    {

        List<Employee> employeeList = GenerateEmployees.generateEmployees(30);

        Map<String,List<Employee>> map=employeeList.stream()
            //.filter(employee -> employee.getCity().equals("Skopje") && employee.getSalary()>0)
            .collect(Collectors.groupingBy(employee -> employee.getWorkingPosition(),Collectors.toList()));

        //HomeWork First Exercise
        System.out.println("--------------------------HOMEWORK FIRST EXERCISE------------------------");
        int employeeCount= (int) employeeList
                .stream()
                .filter(employee -> employee.getCity().equals("Bitola") && employee.getSalary()>800)
                .count();
        System.out.println("Number of Employees that live in Bitola and have salary greater than 800E:"+employeeCount);


        //HomeWork Second exercise
         System.out.println("--------------------------HOMEWORK SECOND EXERCISE------------------------");
         int sum = 0;
         sum += employeeList
                 .stream()
                 .filter(employee -> employee.getCity().equals("Skopje"))
                 .mapToInt(Employee::getSalary).sum();

         System.out.println("Salary sum of Employyes from Skopje:"+sum);

         //Homework Third exercise
        System.out.println("--------------------------HOMEWORK THIRD EXERCISE------------------------");
        employeeList.sort(Comparator.comparing(Employee::getSalary));
        System.out.println("Sorted employees based on salary:");
        System.out.println(employeeList.toString());


        System.out.println("--------------------------HOMEWORK BONUS EXERCISE------------------------");
        Optional<Employee> employeeMax;
        employeeMax = employeeList
                .stream()
                .filter(employee -> employee.getCity().equals("Skopje"))
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println("Employe with max salary"+employeeMax.toString());

        System.out.println("--------------------------ALL EMPLOYEES---------------------------------");
        System.out.println(map.entrySet()
            .stream()
            .map(entry->entry.getKey()+" - "+entry.getValue().toString())
            .collect(Collectors.joining("\n","","\n")));

    }
}

