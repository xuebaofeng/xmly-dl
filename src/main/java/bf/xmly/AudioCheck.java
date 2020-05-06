/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bf.xmly;

import de.odysseus.ithaka.audioinfo.AudioInfo;
import de.odysseus.ithaka.audioinfo.m4a.M4AInfo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AudioCheck {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        ArrayList<Path> files = Files.walk(Paths.get("c:\\media\\podcast\\"))
                .filter(Files::isRegularFile)
                .collect(Collectors.toCollection(ArrayList::new));
        for (Path path : files) {
            File file = path.toFile();
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            AudioInfo audioInfo = new M4AInfo(inputStream);
            double x = file.length() / audioInfo.getDuration();
            inputStream.close();
            if (x < 8) {
                System.out.println(path);
                sb.append(path).append("\n");
//                Files.delete(path);
            }
        }

        Files.writeString(Paths.get("error.log"), sb.toString());
    }
}
