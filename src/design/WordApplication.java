package design;

import design.file.io.File;
import design.file.io.TxtFile;
import design.word.Word;

import java.io.IOException;

/**
 * Create by young on 2020/6/2
 * Copyright © 2020 young. All rights reserved.
 * 应用的模板
 */
public class WordApplication{
    /**
     * 每个功能的步骤基本一致
     * @param word 输入对象
     * @throws IOException IO 出现问题
     */
    public void run(Word word) throws IOException {
        File file = new TxtFile();
        String content = file.readContent("");
        // 分析内容
        word.analysis(content);
        // 文件写出
        word.write("out path");
    }


}
