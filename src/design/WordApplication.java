package design;

import design.factory.FileFactory;
import design.file.io.File;
import design.word.Text;

import java.io.IOException;
import java.util.Map;

/**
 * Create by young on 2020/6/2
 * Copyright © 2020 young. All rights reserved.
 * 应用的模板
 */
public class WordApplication {


    /**
     * 每个功能的步骤基本一致
     *
     * @throws IOException IO 出现问题
     */
    public void run(ApplicationConfig config) throws IOException {

        File file = config.getInputFile();
        String content = file.readContent(config.getInputPath());
        Text text = config.getText();
        // 分析内容
        Map<Object, Integer> analysis = text.analysis(content);
        System.out.println(analysis);
        File outputFile = config.getOutputFile();

    }


}
