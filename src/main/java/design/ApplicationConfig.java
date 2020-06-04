package design;

import design.file.io.File;
import design.word.Text;

/**
 * Create by young on 2020/6/4
 * Copyright © 2020 young. All rights reserved.
 */

public class ApplicationConfig {

    private int limit = 0;

    private File inputFile;

    private String inputPath;

    private File outputFile;

    private String outputPath;

    private Text text;

    public File getInputFile() {
        return inputFile;
    }

    public ApplicationConfig setInputFile(File inputFile) {
        this.inputFile = inputFile;
        return this;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public ApplicationConfig setOutputFile(File outputFile) {
        this.outputFile = outputFile;
        return this;
    }

    public Text getText() {
        return text;
    }

    public ApplicationConfig setText(Text text) {
        this.text = text;
        return this;
    }


    public ApplicationConfig setInputPath(String inputPath) {
        this.inputPath = inputPath;
        return this;
    }

    public ApplicationConfig setOutputPath(String outputPath) {
        this.outputPath = outputPath;
        return this;
    }


    public String getInputPath() {
        return inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public int getLimit() {
        return limit;
    }

    public ApplicationConfig setLimit(int limit) {
        this.limit = limit;
        return this;
    }
}

