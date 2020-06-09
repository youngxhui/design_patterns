package design.file.io;

import design.word.Word;

import java.io.IOException;
import java.util.List;

/**
 * Create by young on 2020/6/6
 * Copyright © 2020 young. All rights reserved.
 */

public class MultiFile implements File {
    private final WordFile wordFile = new WordFile();
    private String content = "";

    /**
     * 多文件读取
     *
     * @param paths 路径采用逗号分割
     * @return
     * @throws IOException
     */
    @Override
    public String readContent(String paths) throws IOException {
        String[] path = paths.split(",");
//        System.out.println(path);
        for (String s : path) {   //第一个路径读取的内容，和第二个读取的内容，两篇内容整体要拼接起来，@@是标识两段内容的
            content = wordFile.readContent(s) + "/@@" + content;
        }

        return content;
    }

    @Override
    public void output(String path, String content) throws IOException {
        wordFile.output(path, content);    //输出的路径和内容
    }
}
