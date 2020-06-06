import design.ApplicationConfig;
import design.WordApplication;
import design.file.io.TxtFile;
import design.file.io.WordFile;
import design.word.Character;
import design.word.Word;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Create by young on 2020/6/3
 * Copyright © 2020 young. All rights reserved.
 */
public class ApplicationTest extends WordApplication {

    @Override
    public String format(Map<Object, String> analysis) {
        StringBuilder sb = new StringBuilder();
        analysis.forEach((key, value) -> {
            sb.append(key).append(":").append(value).append("\n");
        });
        return sb.toString();
    }


}
