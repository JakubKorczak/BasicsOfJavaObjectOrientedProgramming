package korczak.jakub.classes;

import java.time.LocalDate;
import java.time.Period;

import korczak.jakub.interf.IWorking;

public class Worker extends Employee implements IWorking
{
	private LocalDate employmentDate;
	private double bonus;
	private int seniority;

	public Worker(String firstName, String surname, int year, int month, int day,
			double salary, Manager mag, int year2, int month2, int day2, double bonus)
	{
		super(firstName, surname, year, month, day, salary + bonus, mag);
		this.employmentDate = LocalDate.of(year2, month2, day2);
		this.bonus = bonus;
		this.seniority = setSeniority();
	}
	
	public int setSeniority()
	{
		LocalDate currentDate = LocalDate.now();
		if ((employmentDate != null) && (currentDate != null))
		{
			return Period.between(employmentDate, currentDate).getYears();
		} else
		{
			return 0;
		}
	}
	
	
	public LocalDate getEmploymentDate()
	{
		return employmentDate;
	}


	public void setEmploymentDate(LocalDate employmentDate)
	{
		this.employmentDate = employmentDate;
	}


	public double getBonus()
	{
		return bonus;
	}


	public void setBonus(double bonus)
	{
		this.bonus = bonus;
	}


	public int getSeniority()
	{
		return seniority;
	}


	@Override
	public String toString()
	{
		return super.toString() + "Worker: [ employmentDate: " + employmentDate + ", bonus: " + bonus + ", seniority: " + seniority + " ]";
	}

	@Override
	public void working()
	{
		System.out.println(getFirstName() + " is programing...");
		
	}

	@Override
	public void resting()
	{
		System.out.println(getFirstName() + " is drinking coffee");
		
	}

	
	
}