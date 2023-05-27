/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes_conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author geral
 */
public class conexao {
    
    
    
    public static Connection faz_conexao() throws SQLException{
                
            try {
                
                Class.forName("com.mysql.jdbc.Driver");
                
                return DriverManager.getConnection("jdbc:mysql://localhost/db_senhas","root","123456789");
                
            } catch (ClassNotFoundException e) {
                throw new SQLException(e.getException());
            }
    }
}
