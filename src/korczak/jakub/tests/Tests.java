package korczak.jakub.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import korczak.jakub.classes.Employee;
import korczak.jakub.classes.Manager;
import korczak.jakub.classes.Trainee;
import korczak.jakub.classes.Worker;

public class Tests
{
	@Test
	public void highSal()
	{
		List<Manager> managers = new ArrayList<>();
		managers.add(new Manager("MANAGER1", "SUR MANAGER 1", 1988, 12, 1));
		managers.add(new Manager("MANAGER2", "SUR MANAGER 2", 1988, 10, 21));

		List<Employee> people = new ArrayList<>();
		people.add(new Worker("W1", "wS1", 1990, 12, 22, 900.0, managers.get(0), 2000, 5, 10, 500));
		people.add(new Worker("W2", "wS2", 1990, 12, 22, 2500.0, managers.get(0), 2000, 5, 10, 500));
		people.add(new Worker("W3", "wS3", 1990, 12, 22, 22500.0, managers.get(0), 2000, 5, 10, 500));
		people.add(new Trainee("T1", "sT1", 1991, 1, 5, 4000, managers.get(1), 2010, 4, 16));
		people.add(new Trainee("T2", "sT2", 1981, 7, 25, 6700, managers.get(1), 610, 4, 16));

		java.util.Optional<Employee> emp = people.stream()
				.sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).findFirst();

		Assert.assertEquals(emp.get().getSalary(), 23000.0, 0.01);

	}
}
