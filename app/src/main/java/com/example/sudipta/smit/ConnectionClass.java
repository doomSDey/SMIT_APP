package com.example.sudipta.smit;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ConnectionClass {
    //normal hotspot
    //private static final String ROOT_URL = "http://192.168.43.204/v1/";
    //IONBH
    private static final String ROOT_URL = "http://10.10.10.2/v1/";
    public static final String URL_LOGIN = ROOT_URL + "userLogin.php";
    public static final String URL_COMPLAINMESS=ROOT_URL+"Complain.php";
    public static final String URL_COMPLAINMIS=ROOT_URL+"Complainmis.php";
    public static final String URL_ROOMMIS=ROOT_URL+"roommis.php";
    public static final String URL_LOGIN2=ROOT_URL+"login2.php";
    public static final String URL_MENU=ROOT_URL+"menu.php";
    public static final String URL_ATTENDENCE=ROOT_URL+"attendence.php";
    public static final String URL_MARKS=ROOT_URL+"marks.php";
    public static final String URL_SEARCH_CONTACTS=ROOT_URL+"searchcont.php";

}
    //Connection conn = null;
/*
    private  static  final String driver = "com.mysql.jdbc.Driver";
    private  static final String db = "sql12261075";
    private static  final String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/?user=sql12261075" + db;
    private static final String user = "sql12261075";
    private static final String pass = "bTanZwNa9S";
    Connection conn;
    public Connection CONN() {

            try {

                Class.forName(driver);
                conn = DriverManager.getConnection(url,user,pass);
                //System.out.println("Connected to database : " + db);
            } catch (ClassNotFoundException e1) {
                Log.e("ERRO", e1.getMessage());
            } catch (SQLException se) {
                Log.e("ERRO", "sql");
            }
            catch (Exception e) {
                Log.e("ERRO", "werf");
            }
            return conn;
    }
}*/
    /*    String ip = "10.50.5.61";
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "students";
    String un = "root";
    String url = "jdbc:mysql://localhost:3306/" + db;
    String password = "sudipta@2000";

}
    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {

            Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
                    + "databaseName=" + db + ";user=" + un + ";password="
                    + password + ";";
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }
*/
//}
