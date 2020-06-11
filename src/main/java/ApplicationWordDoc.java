import design.Application;

import java.util.Map;

/**
 * Create by young on 2020/6/8
 * Copyright © 2020 young. All rights reserved.
 */

public class ApplicationWordDoc extends Application {  //相似度输出格式
    @Override
    public String format(Map<Object, String> analysis) {
        StringBuilder sb = new StringBuilder();
        String similarity = analysis.get("similarity");
        sb.append("文本相似度：").append(similarity);
        float similary = Float.parseFloat(similarity);
        if (similary >= 0.8f) {   //similary相似度值
            sb.append("内容高度相似");
        }
        if (similary >= 0.3f && similary < 0.8f) {
            sb.append("内容部分相似");
        }
        if (similary >= 0.1f && similary < 0.3f) {
            sb.append("内容存在相同点");
        }

        return sb.toString();
    }
}
