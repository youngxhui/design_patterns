import design.Application;
import design.ApplicationConfig;
import design.file.io.MultiFile;
import design.file.io.WordFile;
import design.word.Paper;

import java.io.IOException;

/**
 * Create by young on 2020/6/8
 * Copyright © 2020 young. All rights reserved.
 */

public class Main2 {

    public static void main(String[] args) throws IOException {
        ApplicationConfig instance = ApplicationConfig.INSTANCE;
        instance.setInputFile(new MultiFile()).setInputPath("d:/1.docx,d:/2.docx");
        instance.setContent(new Paper());
        instance.setOutputFile(new WordFile()).setOutputPath("d:/out.docx");
        Application application = new ApplicationWordDoc();
        application.run(instance);
    }

}
