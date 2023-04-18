
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class EmployeeEMS {
	
	public static ArrayList<Employee> emp = new ArrayList<>();

	public static void readOnLaunch(List<Employee> emp) {
		File launchData = new File("resources/emp.txt");
		FileReader fileReader = null;
		BufferedReader buffReader = null;

		try {
			fileReader = new FileReader(launchData);
			buffReader = new BufferedReader(fileReader);

			String line = buffReader.readLine();


			while(line != null) {
				String[] parts = line.split(", ");
				try {
					emp.add(new Employee(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Enum.valueOf(Employee.Departments.class, parts[3]), Integer.parseInt(parts[4])));
				}
				catch (InputMismatchException e) {
					System.out.println("File formatted incorrectly.");
				}
				catch (NumberFormatException e) {
					System.out.println("File formatted incorrectly.");
				}

				line = buffReader.readLine();
			}


		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println("File could not be read.");
		} finally {
			try {
				if(buffReader != null) buffReader.close();
				if(fileReader != null) fileReader.close();
			} catch (IOException e) {
				System.out.println("File could not be closed.");
			}
		}
	}
}
