package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FileTest01 {

	public static void main(String[] args) {
		File file = new File("file.txt");
		try {
			boolean isCreated = file.createNewFile();
			System.out.println("Created " + isCreated);
			System.out.println("path " + file.getPath());
			System.out.println("path absolute " + file.getAbsolutePath());
			System.out.println("is directory " + file.isDirectory());
			System.out.println("is file " + file.isFile());
			System.out.println("is hidden " + file.isHidden());
			System.out.println("last modified " +  Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()).toLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
			boolean exists = file.exists();
			if (exists) {
				System.out.println("Deleted " + file.delete());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
