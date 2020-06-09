import design.Application;
import design.ApplicationConfig;
import design.DefaultApplication;
import design.file.io.TxtFile;
import design.word.Character;

import java.io.IOException;

public class Main1 {
    public static void main(String[] args) throws IOException {
        Application application = new DefaultApplication();    //不需要配置，创建新的对象DefaultApplication
        ApplicationConfig config = ApplicationConfig.INSTANCE;   //ApplicationConfig单例，不需要new，直接获取config对象，
        config.setInputFile(new TxtFile()).setContent(new Character()).setInputPath("d:/1.txt");   //配置方式，输入
        config.setOutputPath("d:/1out.txt").setOutputFile(new TxtFile());   //配置输出

        application.run(config);   //运行
    }
}
