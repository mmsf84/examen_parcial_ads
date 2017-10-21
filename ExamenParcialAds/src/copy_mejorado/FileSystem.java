package copy_mejorado;

public class FileSystem implements DispositivoOutput{
	@Override
	public void write(String value) {
		System.out.println(" *Database: " + value);
	}
}
