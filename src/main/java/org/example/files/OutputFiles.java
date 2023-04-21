package org.example.files;

public class OutputFiles {
    private static final String[] files = {
                    "./src/main/resources/output-files/file1_out.txt",
                    "./src/main/resources/output-files/file2_out.txt",
                    "./src/main/resources/output-files/file3_out.txt",
                    "./src/main/resources/output-files/file4_out.txt",
                    "./src/main/resources/output-files/file5_out.txt",
                    "./src/main/resources/output-files/file6_out.txt"
    };

    private OutputFiles() {
        super();
    }

    public static String getFile(int i) {
        return files[i];
    }
}
