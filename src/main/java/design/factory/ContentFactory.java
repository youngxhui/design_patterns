package design.factory;

import design.word.Content;

/**
 * Create by young on 2020/6/11
 * Copyright © 2020 young. All rights reserved.
 */

public class ContentFactory {

    public Content createContent(Class<? extends Content> clazz) {
        Content content = null;
        try {

            content = (Content) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return content;
    }


}
