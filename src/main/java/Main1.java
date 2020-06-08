import design.Application;
import design.ApplicationConfig;
import design.DefaultApplication;
import design.file.io.TxtFile;
import design.word.Character;

import java.io.IOException;

public class Main1 {
    public static void main(String[] args) throws IOException {
        Application application = new DefaultApplication();
        ApplicationConfig config = ApplicationConfig.INSTANCE;
        config.setInputFile(new TxtFile()).setContent(new Character()).setInputPath("d:/1.txt");
        config.setOutputPath("d:/1out.txt").setOutputFile(new TxtFile());

        application.run(config);
    }
}
