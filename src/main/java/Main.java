import design.ApplicationConfig;
import design.file.io.MultiFile;
import design.file.io.TxtFile;
import design.file.io.WordFile;
import design.word.Paper;
import design.word.Word;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationTest application = new ApplicationTest();
        ApplicationConfig config = ApplicationConfig.INSTANCE;
        config.setInputFile(new MultiFile()).setContent(new Paper()).setInputPath("d:/1.docx,d:/2.docx");
        config.setOutputPath("d:/word_out.txt").setOutputFile(new TxtFile());
        config.setLimit(2);
        application.run(config);
    }
}
