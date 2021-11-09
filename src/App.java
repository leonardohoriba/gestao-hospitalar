import java.sql.Date;
import java.text.SimpleDateFormat;

public class App {
    
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
        // Date date = new Date(timestamp.getTime());
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp.getTime());
        System.out.println(date);
    }
}
 