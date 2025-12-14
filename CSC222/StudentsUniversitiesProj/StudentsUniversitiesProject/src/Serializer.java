import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializer {
    public static void writeObject(String path, Object obj) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
        }
    }

    public static void writeStudents(String path, List<Student> students) throws IOException {
        writeObject(path, students);
    }

    public static void writeUniversities(String path, List<University> universities) throws IOException {
        writeObject(path, universities);
    }
}
