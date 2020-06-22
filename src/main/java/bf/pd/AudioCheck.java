/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bf.pd;

import de.odysseus.ithaka.audioinfo.AudioInfo;
import de.odysseus.ithaka.audioinfo.m4a.M4AInfo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AudioCheck {

    public static void main(String[] args) {
        checkM4a();
    }


    private static void checkM4a() {
        ArrayList<Path> files;
        try {
            files = Files.walk(Paths.get("c:\\media\\podcast\\"))
                    .filter((path) -> {
                        String pathStr = path.toString();
                        return pathStr.endsWith(".m4a")
                                && !pathStr.contains("S05E01");
                    })
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        InputStream inputStream;
        for (Path path : files) {
            File file = path.toFile();
            try {
                inputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            AudioInfo audioInfo;

            try {
                audioInfo = new M4AInfo(inputStream);
            } catch (IOException e) {
                deleteFile(path);
                continue;
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("error:" + path);
                }
            }

            long fileLength = file.length();

            double x = fileLength / audioInfo.getDuration();
            if (x < 8) {
                System.out.println(file.getAbsolutePath() + ": " + x);
                deleteFile(path);
            }
        }
    }

    private static void deleteFile(Path path) {
        System.out.println("delete:" + path);
        /*try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            System.out.println("error when delete:" + path);
        }*/
    }
}
