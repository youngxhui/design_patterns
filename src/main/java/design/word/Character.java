package design.word;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by young on 2020/6/3
 * Copyright © 2020 young. All rights reserved.
 */

public class Character implements Content {

    private final Map<Object, String> characterPool = new HashMap<>();

    @Override
    public Map<Object, String> analysis(String content,int limit) {
        for (int i = 0; i < content.length(); i++) {
            if (!java.lang.Character.isLetter(content.charAt(i))) {
                continue;
            }
            if (characterPool.containsKey(content.charAt(i))) {
                characterPool.put(content.charAt(i), characterPool.get(Integer.parseInt(String.valueOf(content.charAt(i))) + 1));
            } else {
                characterPool.put(content.charAt(i), String.valueOf(1));
            }
        }
        return characterPool;
    }
}
