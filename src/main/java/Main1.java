import design.ApplicationConfig;
import design.file.io.MultiFile;
import design.file.io.WordFile;
import design.word.Paper;

import java.io.IOException;

public class Main1 {
    public static void main(String[] args) throws IOException {
        ApplicationCharacterText application = new ApplicationCharacterText();
        ApplicationConfig config = ApplicationConfig.INSTANCE;
        config.setInputFile(new MultiFile()).setContent(new Paper()).setInputPath("d:/1.docx,d:/2.docx");
        config.setOutputPath("d:/word_out.docx").setOutputFile(new WordFile());
        config.setLimit(2);
        application.run(config);
    }
}
