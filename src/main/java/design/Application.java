package design;

import design.factory.ContentFactory;
import design.file.io.File;
import design.word.Content;
import design.word.Word;

import java.io.IOException;
import java.util.Map;

/**
 * Create by young on 2020/6/2
 * Copyright © 2020 young. All rights reserved.
 * 应用的模板
 */
public abstract class Application {

    private ContentFactory contentFactory = new ContentFactory();

    public abstract String format(Map<Object, String> analysis);

    /**
     * 每个功能的步骤基本一致
     *
     * @param config 基本配置
     * @throws IOException IO 出现问题
     */
    public final void run(ApplicationConfig config) throws IOException {
        // 文件读取
        File file = config.getInputFile();
        String content = file.readContent(config.getInputPath());

        Content text = contentFactory.createContent(config.getContent().getClass());
        // 分析内容
        Map<Object, String> analysis = text.analysis(content, config.getLimit());
        // 输出格式定制
        String format = format(analysis);
        // 输出内容
        File outputFile = config.getOutputFile();
        outputFile.output(config.getOutputPath(), format);
    }


}
