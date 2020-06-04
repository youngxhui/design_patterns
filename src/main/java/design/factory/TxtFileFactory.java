package design.factory;

import design.file.io.File;
import design.file.io.TxtFile;

/**
 * Create by young on 2020/6/3
 * Copyright © 2020 young. All rights reserved.
 */

public class TxtFileFactory implements FileFactory {
    @Override
    public File create() {
        return new TxtFile();
    }
}
