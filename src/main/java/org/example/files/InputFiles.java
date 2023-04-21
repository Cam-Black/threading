package org.example.files;

public class InputFiles {
    private static final String[] files =
                    { "./src/main/resources/input-files/file1.txt",
                                    "./src/main/resources/input-files/file2.txt",
                                    "./src/main/resources/input-files/file3.txt",
                                    "./src/main/resources/input-files/file4.txt",
                                    "./src/main/resources/input-files/file5.txt",
                                    "./src/main/resources/input-files/file6.txt" };

    private InputFiles() {
        super();
    }

    public static String getFile(int i) {
        return files[i];
    }

    public static int getFilesLength() {
        return files.length;
    }
}
