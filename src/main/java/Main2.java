import design.Application;
import design.ApplicationConfig;
import design.DefaultApplication;
import design.file.io.TxtFile;
import design.word.Word;

import java.io.IOException;

/**
 * Create by young on 2020/6/8
 * Copyright © 2020 young. All rights reserved.
 */

public class Main2 {

    public static void main(String[] args) throws IOException {
        ApplicationConfig instance = ApplicationConfig.INSTANCE;
        instance.setInputFile(new TxtFile()).setInputPath("d:/1.txt");
        instance.setContent(new Word());
        instance.setOutputFile(new TxtFile()).setOutputPath("d:/2out.txt");
        instance.setLimit(3);
        Application application = new DefaultApplication();

        application.run(instance);
    }

}
