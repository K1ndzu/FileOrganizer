
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, i'm the assistant of FileOrganizer, you want to make what?");
        System.out.println("1.Organize one file for me\n2.Exit");
        short resp = scanner.nextShort();
        switch (resp) {
            case 1 -> takeInformation();
            case 2 -> System.exit(0);
            default -> System.out.println("that is not a correct answer");
        }

        scanner.close();
    }

    public static void takeInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First i need your path");
        String path = scanner.nextLine();
        System.out.println("Now the kind of archive you want to separate");
        String typeArchive = "." + scanner.nextLine();
        scanner.close();
        (new FileOrganizer()).organizeFiles(path, typeArchive);
        System.out.println("all go great, thanks to use\n ********File Organizer********");
    }
}
