import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class rubycodecaller {

	public static void main(String[] args) throws Exception {
		System.out.println(runShell("ruby add2numbers.rb 4 3"));
	}
	
	private static String runShell(String command) throws Exception {
		
		String output = "";

		Process execProcess;
		execProcess = Runtime.getRuntime().exec(command);
		execProcess.waitFor();
		InputStream is = execProcess.getInputStream();
		InputStreamReader isReader = new InputStreamReader(is);
		BufferedReader reader = new BufferedReader(isReader);

		try {
			while (true) {
				output = output + reader.lines().iterator().next() + "\n";
			}
		} catch (Exception e) {}
		
		return output;
		
	}
	
}
