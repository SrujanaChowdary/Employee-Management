package employeemanagement;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class myConnection {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem?zeroDateTimeBehavior=convertToNull","root","");
        }catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return con;
    }
}
