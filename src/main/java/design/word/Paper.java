package design.word;

import java.util.Map;

/**
 * Create by young on 2020/6/4
 * Copyright © 2020 young. All rights reserved.
 */
public class Paper implements Content {

    private Content word;

    /**
     * 设置原始文字
     * @param content 原始文章内容
     */
    public Paper(Content content) {
        this.word = content;
    }

    /**
     * 对比文章的内容
     * @param content 内容
     * @param limit 限制
     * @return 相似度报告文本
     */
    @Override
    public Map<Object, String> analysis(String content,int limit) {
        word.analysis("xxxxx",limit);
        return null;
    }
}
