package design;

import java.util.Map;

/**
 * Create by young on 2020/6/8
 * Copyright © 2020 young. All rights reserved.
 */

public class DefaultApplication extends Application {
    @Override
    public String format(Map<Object, String> analysis) {
        StringBuilder sb = new StringBuilder();
        analysis.forEach((key, value) -> {
            sb.append(key).append(":").append(value).append("\n");
        });
        return sb.toString();
    }
}
