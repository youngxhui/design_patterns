package design.word;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by young on 2020/6/3
 * Copyright © 2020 young. All rights reserved.
 */

public class Character implements Text {

    private final Map<Object, Integer> characterPool = new HashMap<>();

    @Override
    public Map<Object, Integer> analysis(String content) {
        for (int i = 0; i < content.length(); i++) {
            if (!java.lang.Character.isLetter(content.charAt(i))) {
                continue;
            }

            if (characterPool.containsKey(content.charAt(i))) {
                characterPool.put(content.charAt(i), characterPool.get(content.charAt(i)) + 1);
            } else {
                characterPool.put(content.charAt(i), 1);
            }
        }
        return characterPool;
    }
}
