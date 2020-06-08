package design.word;

import java.util.*;

/**
 * Create by young on 2020/6/4
 * Copyright © 2020 young. All rights reserved.
 */
public class Paper implements Content {

    private Content word = new Word();


    /**
     * 对比文章的内容
     *
     * @param content 内容
     * @param limit   限制
     * @return 相似度报告文本
     */
    @Override
    public Map<Object, String> analysis(String content, int limit) {

        String[] split = content.split("/@@");
        System.out.println(split.length);
        List<Map<Object, String>> list = new ArrayList<>();
        for (String s : split) {

            Map<Object, String> analysis = word.analysis(s, 0);
            list.add(analysis);

        }
        calJackcardSim(list.get(0), list.get(1));

        return null;
    }

    /**
     * 相似度计算
     * @param paper1 文章1
     * @param paper2 文章2
     */
    private void calJackcardSim(Map<Object, String> paper1, Map<Object, String> paper2) {
        Set<String> all = new HashSet<>();

        Set<String> set = new HashSet<>();
        for (Map.Entry<Object, String> entry : paper1.entrySet()) {
            all.add(entry.getKey().toString());
        }
        for (Map.Entry<Object, String> entry : paper2.entrySet()) {
            all.add(entry.getKey().toString());
            set.add(entry.getKey().toString());
        }
        Set<String> both = new HashSet<>();
        for (Map.Entry<Object, String> entry : paper1.entrySet()) {
            all.add(entry.getKey().toString());
        }

        both.retainAll(set);


        System.out.println(both.size() / (double)all.size());


    }
}
