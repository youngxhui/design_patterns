package design.word;

import java.util.*;

/**
 * Create by young on 2020/6/4
 * Copyright © 2020 young. All rights reserved.
 */
public class Paper implements Content {


    /**
     * 对比文章的内容
     *
     * @param content 内容
     * @param limit   限制
     * @return 相似度报告文本
     */
    @Override
    public Map<Object, String> analysis(String content, int limit) {
        Map<Object, String> objectStringMap = new HashMap<>();
        String[] split = content.split("/@@");
        List<Map<String, Integer>> list = new ArrayList<>();
        int fileIndex = 1;
        for (String s : split) {
            Content word = new Word();
            Map<String, Integer> result = new HashMap<>();
            Map<Object, String> analysis = word.analysis(s, 0);
            for (Map.Entry<Object, String> entry : analysis.entrySet()) {
                String[] fields = entry.getValue().split("/");
                int num = Integer.parseInt(fields[0]);
                result.put(entry.getKey().toString(), num);
            }
            list.add(result);

            objectStringMap.put("content"+fileIndex, s);

            fileIndex += 1;
        }
        double similarity = similarity(list.get(0), list.get(1));

        objectStringMap.put("similarity", String.valueOf(similarity));
        return objectStringMap;
    }


    private double dotProduct(
            final Map<String, Integer> profile1,
            final Map<String, Integer> profile2) {

        // Loop over the smallest map
        Map<String, Integer> small_profile = profile2;
        Map<String, Integer> large_profile = profile1;
        if (profile1.size() < profile2.size()) {
            small_profile = profile1;
            large_profile = profile2;
        }

        double agg = 0;
        for (Map.Entry<String, Integer> entry : small_profile.entrySet()) {
            Integer i = large_profile.get(entry.getKey());
            if (i == null) {
                continue;
            }
            agg += 1.0 * entry.getValue() * i;
        }

        return agg;
    }

    private double norm(final Map<String, Integer> profile) {
        double agg = 0;

        for (Map.Entry<String, Integer> entry : profile.entrySet()) {
            agg += 1.0 * entry.getValue() * entry.getValue();
        }

        return Math.sqrt(agg);
    }

    public final double similarity(
            final Map<String, Integer> profile1,
            final Map<String, Integer> profile2) {

        return dotProduct(profile1, profile2)
                / (norm(profile1) * norm(profile2));
    }
}
