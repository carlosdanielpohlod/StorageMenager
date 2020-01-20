/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Thais Amanda Santos
 */
public class Conexao implements IConst {
    public static Connection getConnection(String url, String usuario, String senha) throws ClassNotFoundException{
        try{
            
         
            return DriverManager.getConnection(url, usuario, senha);
        }catch(SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
}
