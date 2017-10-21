package copy1;

public class Copier {
	// remember to reset these flags
	public static boolean scannerFlag = false;
	public static boolean databaseFlag = false;

	public static void copy() throws Exception {
		String inputValue = "";
		while (!(inputValue = (scannerFlag ? Scanner.read() : Keyboard.read())).equals("-1")) {
			if (databaseFlag) {
				Database.write(inputValue);
			} else {
				Printer.write(inputValue);
			}
		}
	}
}