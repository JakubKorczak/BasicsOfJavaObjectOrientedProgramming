package korczak.jakub.classes;

public abstract class Employee extends Person
{
	private double salary;
	private Manager mang;

	public Employee(String firstName, String surname, int year, int month, int day, double salary, Manager mang)
	{
		super(firstName, surname, year, month, day);
		this.salary = salary;
		this.mang = mang;

	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	public Manager getMang()
	{
		return mang;
	}

	public void setMang(Manager mang)
	{
		this.mang = mang;
	}

	@Override
	public String toString()
	{
		return super.toString() + "Employee: [ salary: " + salary + ", manger: " + mang + " ]";
	}

}