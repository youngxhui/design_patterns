package design.word;

import java.util.Map;

/**
 * Create by young on 2020/6/3
 * Copyright © 2020 young. All rights reserved.
 */

public interface Content {
    Map<Object, String> analysis(String content,int limit);

}
