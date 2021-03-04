package com.leasingauth.util.files;

import com.leasingauth.util.common.CommonUtil;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtil {

    public static String readFileFromResources(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        File file = ResourceUtils.getFile(CommonUtil.CLASSPATH + filePath);
        try (Stream<String> stream = Files.lines(Paths.get(file.getPath()), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
            return contentBuilder.toString();
        }
    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        return contentBuilder.toString();
    }
}
