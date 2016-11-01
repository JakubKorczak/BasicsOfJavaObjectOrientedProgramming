package korczak.jakub.interf;

public interface IWorking
{
	void working();
	void resting();
	
	default void endWork()
	{
		System.out.println("coming home...");
	}
}
