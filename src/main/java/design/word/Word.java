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
public class Word implements Text {

    private final Map<Object, Integer> wordPool = new HashMap<>();

    @Override
    public Map<Object, Integer> analysis(String content) {


        List<Term> termList = IndexTokenizer.segment(content);
        for (Term term : termList) {
            if (term.word.trim().isEmpty()) {
                continue;
            }
            if (term.word.trim().equals("\n")) {
                continue;
            }


            if (wordPool.containsKey(term.word)) {
                wordPool.put(term.word, wordPool.get(term.word) + 1);
            } else {
                wordPool.put(term.word, 1);
            }
        }
        return wordPool;
    }
}
