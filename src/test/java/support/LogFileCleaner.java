package support;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class LogFileCleaner {

    public static void deleteLogFiles() {

        String currentDir = System.getProperty("user.dir");
        Path logDir = Paths.get(currentDir, "logs");

        try {
            Files.walkFileTree(logDir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                   
                    if (file.toString().endsWith(".log")) {
                        Files.delete(file);
                        System.out.println("Deleted file: " + file.toString());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.err.println("Error deleting log files: " + e.getMessage());
        }
    }

	
	 public static void main(String[] args) { deleteLogFiles(); }
	
}

