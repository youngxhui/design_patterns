import design.Application;

import java.util.Map;

/**
 * Create by young on 2020/6/8
 * Copyright © 2020 young. All rights reserved.
 */

public class ApplicationWordTxt  extends Application {   //输出格式
    @Override
    public String format(Map<Object, String> analysis) {
        StringBuilder sb = new StringBuilder();
        analysis.forEach((key, value) -> {
            sb.append(key).append(":").append(value).append("\n");
        });
        return sb.toString();
    }
}
