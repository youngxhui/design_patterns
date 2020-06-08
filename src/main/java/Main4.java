import design.Application;
import design.ApplicationConfig;
import design.file.io.TxtFile;
import design.word.Word;

import java.io.IOException;

/**
 * Create by young on 2020/6/8
 * Copyright © 2020 young. All rights reserved.
 */

public class Main4 {
    public static void main(String[] args) throws IOException {
        Application application = new ApplicationSort();
        ApplicationConfig config = ApplicationConfig.INSTANCE;
        config.setInputFile(new TxtFile()).setContent(new Word()).setInputPath("d:/1.txt");
        config.setOutputPath("d:/4out.txt").setOutputFile(new TxtFile());
        application.run(config);
    }
}
