import java.io.File;

public class Tester {

	public static void main(String[] args) {

		Lexer lexicalAnalyzer = new Lexer();
		String filePath = "test_files" + File.separator +"file_input.txt";
		if (lexicalAnalyzer.initialize(filePath)) {

			Token token;
			try {
				while ((token = lexicalAnalyzer.nextToken()) != null) {
					System.out.println(token);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else
			System.out.println("File not found!!");
	}

}
