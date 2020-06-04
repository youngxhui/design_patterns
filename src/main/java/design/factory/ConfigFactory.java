package design.factory;

import design.ApplicationConfig;

/**
 * Create by young on 2020/6/4
 * Copyright © 2020 young. All rights reserved.
 */

public class ConfigFactory {

    public ApplicationConfig create() {
        return new ApplicationConfig();
    }

}
