package copy_mejorado;

public class Database implements DispositivoOutput{
	@Override
	public void write(String value) {
		System.out.println(" *Database: " + value);
	}
}
