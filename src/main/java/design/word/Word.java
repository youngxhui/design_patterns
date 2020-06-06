package design.word;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by young on 2020/6/2
 * Copyright © 2020 young. All rights reserved.
 * 所有字的抽象接口，包含统计方法
 */
public class Word implements Content {

    private final Map<Object, String> wordPool = new HashMap<>();

    @Override
    public Map<Object, String> analysis(String content,int limit) {
        Map<Object,String> result = new HashMap<>();
        // 分段
        String[] paragraphs = content.split("\n");
        for (int i = 0; i < paragraphs.length; i++) {
            int offset = 1;
            String paragraph = paragraphs[i];
            List<Term> termList = IndexTokenizer.segment(paragraph);
            int p = i + 1;
            for (Term term : termList) {
                System.out.print(term.word + " ");

                if (term.word.trim().isEmpty()) {
                    continue;
                }
                if (wordPool.containsKey(term.word)) {
                    String v = wordPool.get(term.word);
                    String[] fields = v.split("/");
                    int count = Integer.parseInt(fields[0]);
                    count += 1;

                    String value = count + "/" + fields[1] + "(" + p + "," + offset + ")";
                    wordPool.put(term.word, value);
                } else {
                    wordPool.put(term.word, "1/(" + p + "," + offset + ")");
                }
                offset += 1;
            }
        }
        for (Map.Entry<Object, String> word : wordPool.entrySet()) {
            String[] fields = word.getValue().split("/");
            int count = Integer.parseInt(fields[0]);
            // 过滤标点符号
            if (word.getKey().equals("。")) {
                continue;
            }


            if (count > limit) {
                String value = count + "/" + fields[1];
                result.put(word.getKey(), value);
            }
        }

        return result;
    }
}
