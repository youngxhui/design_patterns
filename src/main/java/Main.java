import design.ApplicationConfig;
import design.file.io.TxtFile;
import design.file.io.WordFile;
import design.word.Word;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationTest application = new ApplicationTest();
        ApplicationConfig config = new ApplicationConfig();
        config.setInputFile(new WordFile()).setContent(new Word()).setInputPath("d:/1.docx");
        config.setOutputPath("d:/word_out.txt").setOutputFile(new TxtFile());
        config.setLimit(2);
        application.run(config);

    }
}
