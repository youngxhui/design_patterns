package design.file.io;

import java.io.*;

/**
 * Create by young on 2020/6/2
 * Copyright © 2020 young. All rights reserved.
 */
public class TxtFile implements File {
    @Override
    public String readContent(String path) throws IOException {
        java.io.File file = new java.io.File(path);
        StringBuilder sb = new StringBuilder();
        if (!file.exists()) {
            throw new FileNotFoundException("文件没找到");
        }
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(file)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line;
        line = br.readLine();
        while (line != null) {

            if (line.trim().isEmpty()) {
                line = br.readLine();
                continue;
            }
            sb.append(line + "\n");
            line = br.readLine(); // 一次读入一行数据
        }
        br.close();
        reader.close();

        return sb.toString();
    }

    /**
     * 将文件写出
     *
     * @param path    文件路径
     * @param content 输出内容
     * @throws IOException 当文档不存在的时候进行输出。
     */
    @Override
    public void output(String path, String content) throws IOException {
        java.io.File file = new java.io.File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(content);
        out.flush();
        out.close();

    }
}
