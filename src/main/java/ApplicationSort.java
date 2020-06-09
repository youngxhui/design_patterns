import design.Application;

import java.util.*;

/**
 * Create by young on 2020/6/8
 * Copyright © 2020 young. All rights reserved.
 */

public class ApplicationSort extends Application {  //排序，高频到低频，对format改写

    @Override
    public String format(Map<Object, String> analysis) {
        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<Object, String> entry : analysis.entrySet()) {
            map.put(String.valueOf(entry.getKey()), Integer.parseInt(entry.getValue().split("/")[0]));
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> (o2.getValue() - o1.getValue()));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> me : list) {
            sb.append(me.getKey()).append("\n");
        }
        return sb.toString();
    }
}
