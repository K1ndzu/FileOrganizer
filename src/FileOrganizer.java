
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOrganizer {
    private static String[] filterFiles(String path, String archiveType) {
        File filePath = new File(path);
        FilenameFilter filenameFilter = (file, name) -> name.endsWith(archiveType);
        return filePath.list(filenameFilter);
    }

    public void organizeFiles(String path, String archiveType) {
        File directory = new File(path + "/Files");
        File[] allFiles = new File[100];
        String[] allFilesString = filterFiles(path, archiveType);

        try {
            if (directory.exists()) {
                for(int i = 0; i < allFilesString.length; ++i) {
                    allFiles[i] = new File(allFilesString[i]);
                    String olderPath = path + "/" + String.valueOf(allFiles[i]);
                    String var10000 = String.valueOf(directory.toPath());
                    String targetPath = var10000 + "/" + String.valueOf(allFiles[i]);
                    Files.move(Paths.get(olderPath), Paths.get(targetPath));
                }
            } else {
                System.out.println(directory.toPath());
                Files.createDirectory(directory.toPath());
                this.organizeFiles(path, archiveType);
            }
        } catch (IOException var9) {
            System.out.println("Something go wrong");
        }

    }
}
