package design.file.io;

import java.io.IOException;

/**
 * Create by young on 2020/6/2
 * Copyright © 2020 young. All rights reserved.
 */

public interface File {

    /**
     * 读取内容
     *
     * @return 文本内容
     */
    String readContent(String path) throws IOException;

    /**
     * 进行文本输出
     *
     * @param path    路径
     * @param content 内容
     * @throws IOException
     */
    void output(String path, String content) throws IOException;
}
