package com.kelog.kelog.shared;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class CommonUtils {



    private static final String FILE_EXTENSION_SEPARATOR = ".";

    public static String buildFileName(String originalFileName) {
        int fileExtensionIndex = originalFileName.lastIndexOf(FILE_EXTENSION_SEPARATOR);
        String fileExtension = originalFileName.substring(fileExtensionIndex);
        String fileName = originalFileName.substring(0, fileExtensionIndex);
        String now = String.valueOf(System.currentTimeMillis());

        return  fileName + now + FILE_EXTENSION_SEPARATOR + fileExtension;
    }
}
