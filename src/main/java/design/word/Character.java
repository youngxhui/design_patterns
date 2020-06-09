package design.word;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by young on 2020/6/3
 * Copyright © 2020 young. All rights reserved.
 */

public class Character implements Content {

    private final Map<Object, String> characterPool = new HashMap<>();   //定义characterPool

    @Override
    public Map<Object, String> analysis(String content, int limit) {   //content文本读取所有内容，字符串    ，limit缺省值
        for (int i = 0; i < content.length(); i++) {
            if (!java.lang.Character.isLetter(content.charAt(i))) {   //不是字符，跳过
                continue;
            }
            if (characterPool.containsKey(content.charAt(i))) {    //包含出现过的字符，+1
                characterPool.put(content.charAt(i), String.valueOf(Integer.parseInt(characterPool.get(content.charAt(i))) + 1));
            } else {
                characterPool.put(content.charAt(i), "1");   //不包含，设置为1
            }
        }
        return characterPool;
    }
}
