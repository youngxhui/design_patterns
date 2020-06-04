package design.factory;

import design.file.io.File;
import design.file.io.WordFile;

/**
 * Create by young on 2020/6/3
 * Copyright © 2020 young. All rights reserved.
 */
public class WordFileFactory implements FileFactory {
    @Override
    public File create() {
        return new WordFile();
    }
}
