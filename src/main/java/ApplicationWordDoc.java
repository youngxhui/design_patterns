import design.Application;

import java.util.Map;

/**
 * Create by young on 2020/6/8
 * Copyright © 2020 young. All rights reserved.
 */

public class ApplicationWordDoc extends Application {
    @Override
    public String format(Map<Object, String> analysis) {
        StringBuilder sb = new StringBuilder();
        String similarity = analysis.get("similarity");
        sb.append("文本相似度：").append(similarity);
        float similary = Float.parseFloat(similarity);
        if (similary >= 0.8f) {
            sb.append("内容高度相似");
        }
        if (similary >= 0.3f && similary < 0.8f) {
            sb.append("内容部分相似");
        }
        if (similary >= 0.1f && similary < 0.3f) {
            sb.append("内容存在相同点");
        }


//        String content1 = analysis.get("content1");
//        sb.append("内容文本1\r").append(content1).append((char) 11);
//        String content2 = analysis.get("content2");
//        sb.append("内容文本2\r").append(content2).append((char) 11);
        return sb.toString();
    }
}
