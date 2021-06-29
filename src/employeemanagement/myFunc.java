package employeemanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srujana Chowdary
 */

import employeemanagement.myConnection;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.time.LocalDateTime;    
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class myFunc {
    
public ImageIcon resizePic(String picPath,byte BLOBpic[],int width,int height)
    {ImageIcon myImg;
        if(picPath!=null){
         myImg =new ImageIcon(picPath);
        }else{
            myImg =new ImageIcon(BLOBpic);
        }
        Image img=myImg.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
        ImageIcon myPic=new ImageIcon(img);
        return myPic;
        
    }
    private void jButtonBrowseImageMouseClicked(java.awt.event.MouseEvent evt) {                                                
        JFileChooser filec=new JFileChooser();
        filec.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fileFilter= new FileNameExtensionFilter("*.Images","jpg","png","gif");
        int fileState=filec.showSaveDialog(null);
        if(fileState==JFileChooser.APPROVE_OPTION){
            File SelectedFile=filec.getSelectedFile();
            String Path=SelectedFile.getAbsolutePath();
           // jLabelPic.setIcon(resizePic(Path));
           // imgPth=Path;
        } else if(fileState==JFileChooser.CANCEL_OPTION)
        {
            System.out.println("No image Selected");
        }
    }      
   public String getP(String s)
   {
       String P=null;
       Connection con=myConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps=con.prepareStatement("SELECT * FROM `employee_details` WHERE ID=?;");
            ps.setString(1,s);
            
             rs=ps.executeQuery();
             if(rs.next())
             {
                 P=rs.getString("Password");
                 return P;
             }
        }
        catch(SQLException e)
        {
            
             }
      return null;
       
   }
    public String getdate(String date) throws ParseException{
        String s=null;
        if(date.indexOf(47)==2)
        { Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
         LocalDateTime localDateTime = LocalDateTime.now();
  
        ZonedDateTime zdt = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        long date2 = zdt.toInstant().toEpochMilli();
         long time_difference= date2- date1.getTime();
         long d = (time_difference / (1000l*60*60*24*365)); 
         s=d+"";}
        else if(date.indexOf(45)==2){
            Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(date);  
         LocalDateTime localDateTime = LocalDateTime.now();
  
        ZonedDateTime zdt = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        long date2 = zdt.toInstant().toEpochMilli();
         long time_difference= date2- date1.getTime();
         long d = (time_difference / (1000l*60*60*24*365)); 
         s=d+"";
        }

    return s;
        
    }
    public void Create_emp(String id){
         Connection con= myConnection.getConnection();
                PreparedStatement ps;
        try {
            ps=con.prepareStatement("INSERT INTO `attendance`(`ID`) VALUES (?)");
            ps.setString(1,id);
            
            if(ps.executeUpdate()!=0){
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Record_Attendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void Lstatus(String id)
    {
        //INSERT INTO `leave_status`(`ID`, `Status`) VALUES ('[value-1]','[value-2]')
        Connection con= myConnection.getConnection();
                PreparedStatement ps;
                ResultSet rs;
        try {
            ps=con.prepareStatement("INSERT INTO `leave_status`(`ID`) VALUES (?)");
            ps.setString(1,id);
            
            if(ps.executeUpdate()!=0){
                
            }
            else{
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Record_Attendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean isUsernameExist(String un)
    {
        boolean uExist=false;
        Connection con=myConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps=con.prepareStatement("SELECT * FROM `employee_details` WHERE ID=?;");
            ps.setString(1,un);
             rs=ps.executeQuery();
             if(rs.next())
             {
                 uExist=true;
             }          
        }
        catch(HeadlessException | SQLException e)
        {
             Logger.getLogger(Add_employee.class.getName()).log(Level.SEVERE,null,e);
        }
        return uExist;
        
    }
    public String getN(String s)
   {
       String P=null, Q=null;
       Connection con=myConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps=con.prepareStatement("SELECT * FROM `employee_details` WHERE ID=?;");
            ps.setString(1,s);
            
             rs=ps.executeQuery();
             if(rs.next())
             {
                 P=rs.getString("Fname");
                 Q=rs.getString("Lname");
                 return P+" "+Q;
             }
        }
        catch(SQLException e)
        {
            
             }
      return null;
       
   }
    public String getSal(String s)
   {
       String P=null, Q=null;
       Connection con=myConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps=con.prepareStatement("SELECT * FROM `employee_details` WHERE ID=?;");
            ps.setString(1,s);
            
             rs=ps.executeQuery();
             if(rs.next())
             {
                 P=rs.getString("Salary");
                
                 return P;
             }
        }
        catch(SQLException e)
        {
            
             }
      return null;
       
   }

    public String getPost(String ID) {
        Connection con=myConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String P=null;
        try{
            ps=con.prepareStatement("SELECT * FROM `employee_details` WHERE ID=?;");
            ps.setString(1,ID);
             rs=ps.executeQuery();
             if(rs.next())
             {
                 P=rs.getString("Post");
                
                 return P;
             }
        }
        catch(SQLException e)
        {
            
             }
      return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getProject(String ID){
        Connection con=myConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String P=null;
        try{
            ps=con.prepareStatement("SELECT * FROM `employee_details` WHERE ID=?;");
            ps.setString(1,ID);
             rs=ps.executeQuery();
             if(rs.next())
             {
                 String H=rs.getString("Level");
                 if(H==null){
                     if(getPost(ID)=="HR"){return "HR";}
                     
                    else{ return getP1(ID);}
                 }
                 else{
                    return H;
                 }
             }
            
        }catch(Exception e){
            
        }
     return P;
        
    }
    public String getP1(String ID){
        Connection con=myConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String P=null;
        try{
            ps=con.prepareStatement("SELECT * FROM `per` WHERE ID=?;");
            ps.setString(1,ID);
             rs=ps.executeQuery();
            if(rs.next())
             {
                 return rs.getString("team_leader");
             }
            else 
                return null;
             }
        catch(SQLException e){
            
        }
        return null;
    }
}
    
    
 
