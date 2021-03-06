package design.file.io;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.List;

/**
 * Create by young on 2020/6/2
 * Copyright © 2020 young. All rights reserved.
 */
public class WordFile implements File {
    @Override
    public String readContent(String path) {

        StringBuilder stringBuilder = new StringBuilder();
        InputStream stream = null;
        try {
            stream = new FileInputStream(new java.io.File(path));
            if (path.endsWith(".docx")) {
                XWPFDocument document = new XWPFDocument(stream).getXWPFDocument();

                List<XWPFParagraph> paragraphList = document.getParagraphs();
                System.out.println(paragraphList.size());
                for (XWPFParagraph paragraph : paragraphList) {

                    String para = paragraph.getParagraphText();

                    stringBuilder.append(para);
                    stringBuilder.append("\n");
                }
                document.close();
            } else {

                throw new FileNotFoundException("文件没有找到");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != stream) try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return stringBuilder.toString();
    }


    @Override
    public void output(String path, String content) throws IOException {
        XWPFDocument document = new XWPFDocument();
        FileOutputStream out = new FileOutputStream(new java.io.File(path));
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun xwpfRun = titleParagraph.createRun();
        xwpfRun.setText("相似度文本结果");
        xwpfRun.setFontSize(20);
        XWPFParagraph contentParagraph = document.createParagraph();
        XWPFRun run = contentParagraph.createRun();
        run.setText(content);
        document.write(out);
        document.close();
    }
}
