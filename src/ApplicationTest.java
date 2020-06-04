import design.ApplicationConfig;
import design.WordApplication;
import design.factory.TxtFileFactory;
import design.file.io.TxtFile;
import design.word.Character;
import org.junit.Test;

import java.io.IOException;

/**
 * Create by young on 2020/6/3
 * Copyright © 2020 young. All rights reserved.
 */

public class ApplicationTest {

    @Test
    public void Problem1() throws IOException {
        WordApplication wordApplication = new WordApplication();
        ApplicationConfig config = new ApplicationConfig();
        config.setInputFile(new TxtFile()).setText(new Character()).setInputPath("d:/1.txt");
        wordApplication.run(config);
    }
}
