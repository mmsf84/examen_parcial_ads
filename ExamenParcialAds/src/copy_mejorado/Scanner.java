package copy_mejorado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Scanner implements DispositivoInput{
	@Override
	public String read() throws IOException {
		System.out.print("Scanner - Enter String:");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		return bufferedReader.readLine();
	}
}
