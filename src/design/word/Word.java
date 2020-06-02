package design.word;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Create by young on 2020/6/2
 * Copyright © 2020 young. All rights reserved.
 * 所有字的抽象接口，包含统计方法
 */
public interface Word {

    /**
     * 字、词频统计方法
     *
     * @return
     */
    int analysis(String content);

    /**
     * 进行文档写出
     */
    void write(String path);
}
