package korczak.jakub.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import korczak.jakub.classes.Employee;
import korczak.jakub.classes.Manager;
import korczak.jakub.classes.Trainee;
import korczak.jakub.classes.Worker;

public class Main
{

	public static void empOfMenager(List<Employee> employees, List<Manager> managers)
	{
		Scanner inputOption = new Scanner(System.in);

		for (Manager manager : managers)
		{
			System.out.println("ID:" + manager.getId() + " " + manager.getFirstName() + " " + manager.getSurname());
		}

		System.out.println("Enter id of menager.");
		int choice = 0;
		if (inputOption.hasNextInt())
		{
			choice = Integer.parseInt(inputOption.nextLine());
		} else
		{
			System.out.println("Sorry, couldn't understand you!");
		}

		if (choice == 0 || (choice > managers.size() + 1))
		{
			System.out.println("Empty");
		} else
		{
			System.out.println("Subordinates of " + managers.get(choice - 1).getFirstName() + " "
					+ managers.get(choice - 1).getSurname() + " are: ");
			for (Employee employee : employees)
			{
				if (employee.getMang().getId() == choice)
				{
					System.out.println(employee.getFirstName() + " " + employee.getSurname());
				}
			}
		}

	}

	public static void highestSalary(List<Employee> people)
	{
		java.util.Optional<Employee> emp = people.stream()
				.sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).findFirst();

		System.out.println("The highest salary in the company: " + emp.get().getSalary() + " PLN");
	}

	public static void moreThanThousand(List<Employee> employees)
	{
		System.out.println("Employees who earn more than 1000 PLN are: ");
		employees.stream().filter(e ->
		{
			return e.getSalary() > 1000;
		}).forEach(e -> System.out.println(e.getFirstName() + " " + e.getSurname() + " " +e.getSalary() + " PLN"));
	}

	public static void payroll(List<Employee> employees)
	{
		employees.forEach(e -> System.out.println(e.getFirstName() + " " + e.getSurname() + " " + e.getSalary() + " PLN"));
	}

	public static void getToWork(List<Employee> employees)
	{

		for (Employee employee : employees)
		{
			if (employee instanceof Worker)
			{
				((Worker) employee).working();
			}
		}

	}

	public static void restMan(List<Manager> managers)
	{
		for (int i = 0; i < managers.size(); i++)
		{
			managers.get(i).resting();
		}
	}

	private static void endWork(List<Employee> employees, List<Manager> managers)
	{
		for (Employee employee : employees)
		{
			if (employee instanceof Worker)
			{
				System.out.print(employee.getFirstName() + " is ");
				((Worker) employee).endWork();
				;
			}
		}

		for (Manager manager : managers)
		{
			System.out.print(manager.getFirstName() + " " + manager.getSurname() + " is ");
			manager.endWork();
		}
	}

	private static void running()
	{
		List<Manager> managers = new ArrayList<>();
		managers.add(new Manager("Antony", "Hopkins", 1968, 12, 8));
		managers.add(new Manager("Bob", "Dylan", 1941, 5, 24));

		List<Employee> employees = new ArrayList<>();
		employees.add(new Worker("Will", "Smith", 1990, 12, 22, 900.0, managers.get(0), 2000, 5, 10, 500));
		employees.add(new Worker("Jon", "Malokvich", 1982, 2, 3, 2500.0, managers.get(0), 3300, 5, 10, 660));
		employees.add(new Worker("Scarlet", "Johanson", 1976, 12, 2, 22500.0, managers.get(0), 200, 5, 10, 70));
		employees.add(new Trainee("Michael", "Jackson", 1991, 1, 5, 4000, managers.get(1), 2010, 4, 16));
		employees.add(new Trainee("Freddie", "Mercury", 1941, 7, 25, 6700, managers.get(1), 610, 4, 16));

		boolean endLoop = false;
		while (endLoop == false)
		{
			System.out.println("Menu");
			System.out.println("1. Search");
			System.out.println("2. Preparing payroll for all the employees");
			System.out.println("3. Workers get to work");
			System.out.println("4. Managers are resting");
			System.out.println("5. Finish work");
			System.out.println("6. END");

			System.out.println("Twoj wybor");
			Scanner inputChoice = new Scanner(System.in);
			int switchChoice = inputChoice.nextInt();
			inputChoice.nextLine();

			switch (switchChoice)
			{
			case 1:
				System.out.println("Searching for:");

				System.out.println("1. The highest salary");
				System.out.println("2. Employees subordinates of the given manager");
				System.out.println("3. Employees who earn more than 1000 PLN.");
				System.out.println("Your choice is:");
				int switchChoiceSerch = inputChoice.nextInt();
				inputChoice.nextLine();

				switch (switchChoiceSerch)
				{
				case 1:
					highestSalary(employees);
					break;
				case 2:
					empOfMenager(employees, managers);
					break;
				case 3:
					moreThanThousand(employees);
					break;
				default:
					System.out.println("Wrong number");
				}
				break;
			case 2:
				payroll(employees);
				break;
			case 3:
				getToWork(employees);
				break;
			case 4:
				restMan(managers);
				break;
			case 5:
				endWork(employees, managers);
				break;
			case 6:
				System.out.println("Company close");
				endLoop = true;
				break;
			default:
				System.out.println("Wrong number");
			}
		}

	}

	public static void main(String[] args)
	{
		running();
	}
}
