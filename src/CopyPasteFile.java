

import java.io.*;

/**
 * Write a program to copy and paste a file to other location
 */

public class CopyPasteFile {

    private void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            os.flush();
            is.close();
            os.close();
        }
    }

    private void copyFileUsingBufferedStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        BufferedInputStream bin = null;
        BufferedOutputStream bos = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            bin = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);

            int length;
            while ((length = bin.read()) > 0) {
                bos.write(length);
            }
        } finally {
            bos.flush();
            bos.close();
            bin.close();
            is.close();
            os.flush();
            os.close();
        }
    }

    public static void main(String[] args) throws IOException {
        CopyPasteFile cp = new CopyPasteFile();
        File inputFile = new File("/home/akhil/Downloads/input.txt");
        File outputFile = new File("/home/akhil/Desktop/output.txt");
//        cp.copyFileUsingStream(inputFile, outputFile);
        cp.copyFileUsingBufferedStream(inputFile, outputFile);
    }
}
