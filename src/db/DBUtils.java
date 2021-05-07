import java.io.*;
import java.util.Vector;

public class DBUtils {
    public static Vector<String[]> getData(String db) {
        Vector<String[]> res = new Vector<String[]>();
        String path = "src/files/" + db + ".csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                res.add(values);

            }
            return res;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());

        }
        return null;

    }

    public static void saveData(String db, Vector<String[]> data, boolean append) {
        String path = "src/files/" + db + ".csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append));
                PrintWriter pw = new PrintWriter(bw)) {
            for (String[] row : data) {
                for (String cell : row) {
                    pw.write(cell);
                    pw.append(',');
                }
                pw.append("\n");
            }

            pw.flush();

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());

        }
    }

}