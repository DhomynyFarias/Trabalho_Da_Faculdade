/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
/**
 *
 * @author geral
 */
public class conectar {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL ="jdbc:mysql://localhost/";
    private static final String USER ="root";
    private static final String SENHA = "123456789";
    
    public static Connection getConexao() throws SQLException{
        
                
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, SENHA);
            
            
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Erro na conexão",ex);
        }
    }
    public static void closeConexao(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void closeConexao(Connection con, PreparedStatement stmt){
        
        closeConexao(con);
               
            try {
                if(stmt != null){
                    stmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
            }
     
    }
    
    public static void closeConexao(Connection con, PreparedStatement stmt,ResultSet rs){
        
        closeConexao(con, stmt);
               
            try {
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
            }
     
    }
}
