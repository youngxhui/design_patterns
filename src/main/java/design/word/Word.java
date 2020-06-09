package design.word;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by young on 2020/6/2
 * Copyright © 2020 young. All rights reserved.
 * 所有字的抽象接口，包含统计方法
 */
public class Word implements Content {

    private final List<java.lang.Character> stopWord = new ArrayList<java.lang.Character>();


    private final Map<Object, String> wordPool = new HashMap<>();   //定义wordPool

    @Override
    public Map<Object, String> analysis(String content, int limit) {
        Map<Object, String> result = new HashMap<>();
        // 分段
        String[] paragraphs = content.split("\n");
        for (int i = 0; i < paragraphs.length; i++) {   //段是i，offset偏移量，count词出现的次数
            int offset = 1;    //偏移量，第几段第几个字
            String paragraph = paragraphs[i];
            List<Term> termList = IndexTokenizer.segment(paragraph);    //分词方法
            int p = i + 1;
            for (Term term : termList) {   //分词结果统计

                if (term.nature.toString().equals("w")) {    //标点符号，去掉
                    System.out.println(term);
                    continue;
                }
                if (term.word.trim().isEmpty()) {  //空，去掉
                    continue;
                }
                if (wordPool.containsKey(term.word)) {   //分完的词，有+1，没有就添加进去
                    String v = wordPool.get(term.word);
                    String[] fields = v.split("/");
                    int count = Integer.parseInt(fields[0]);   //对/前的数字进行累加
                    count += 1;

                    String value = count + "/" + fields[1] + "(" + p + "," + offset + ")";   //拼接的输出格式
                    wordPool.put(term.word, value);
                } else {
                    wordPool.put(term.word, "1/(" + p + "," + offset + ")");   //存放，key是词，value是1，/是哪一段第几个
                }
                offset += 1;   //偏移量累加
            }
        }
        for (Map.Entry<Object, String> word : wordPool.entrySet()) {   //判断出现的次数，多余规定的次数，过滤掉不够次数的
            String[] fields = word.getValue().split("/");
            int count = Integer.parseInt(fields[0]);
            // 过滤标点符号
            if (word.getKey().equals("。")) {
                continue;
            }


            if (count >= limit) {
                String value = count + "/" + fields[1];
                result.put(word.getKey(), value);
            }
        }

        return result;
    }
}
