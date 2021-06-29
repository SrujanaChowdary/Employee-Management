/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import javax.swing.JFrame;

/**
 *
 * @author Srujana Chowdary
 */
public class EmployeeManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
       Login m=new Login();
                 m.setVisible(true);
                 m.pack();
                 m.setLocationRelativeTo(null);
                 m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
