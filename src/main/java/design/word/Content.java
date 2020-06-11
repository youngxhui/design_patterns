package design.word;

import java.util.Map;

/**
 * Create by young on 2020/6/3
 * Copyright © 2020 young. All rights reserved.
 */

public interface Content {
    /**
     * 分析接口
     * @param content 内容
     * @param limit 限制
     * @return 内容
     */
    Map<Object, String> analysis(String content,int limit);

}
