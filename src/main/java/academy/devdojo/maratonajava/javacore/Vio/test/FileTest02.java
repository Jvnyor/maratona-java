package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {

	public static void main(String[] args) throws IOException {
		File fileDiretorio = new File("pasta");
		boolean isDiretorioCreated = fileDiretorio.mkdir();
		System.out.println("Diretorio criado? " + isDiretorioCreated);
		File fileArquivoDiretorio = new File(fileDiretorio, "arquivo.txt");
		boolean isFileCreated = false;
		isFileCreated = fileArquivoDiretorio.createNewFile();
		System.out.println("File criado? " + isFileCreated);
		File fileRenamed = new File(fileDiretorio, "arquivo_renomeado.txt");
		boolean isRenamed = fileArquivoDiretorio.renameTo(fileRenamed);
		System.out.println("File renomeado? " + isRenamed);
		File diretorioRenamed = new File("pasta2");
		boolean isDiretorioRenamed = fileDiretorio.renameTo(diretorioRenamed);
		System.out.println("Diretorio renomeado? " + isDiretorioRenamed);
	}
}
