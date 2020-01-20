/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static java.nio.channels.AsynchronousServerSocketChannel.open;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author usuario
 */
public class ProdutoDBDAO implements IConst{
    private Connection db;
    private ResultSet result;
    private String sql;
    private Conexao conexao = new Conexao();
    private PreparedStatement statement ;
    private Produto produto;
    private int id;
    public void dowloadProdutos(ArrayList<Produto> listProdutos) throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            db = conexao.getConnection(url, usuario, senha);
            open();  
        }catch(Exception excecaoConecao){
            JOptionPane.showMessageDialog(null,"Houve um erro na conexao... "+excecaoConecao);
        }
        try{
           sql = "SELECT p.nome, p.idProduto, p.descricao, p.valorUnitario, p.tamanhoProduto,  quan.qtdProduto, foto.urlFoto FROM produto p  JOIN Estoque quan ON quan.idProduto = p.idProduto JOIN fotoilustrativa foto ON foto.idFoto = p.idFoto";
           statement = db.prepareStatement(sql);        
      
            try(ResultSet result = statement.executeQuery(sql)){
               while (result.next()) {
                   
                   produto = new Produto(result.getInt("idproduto"),result.getString("nome"), result.getInt("qtdProduto"), result.getString("descricao"),
                   result.getDouble("valorUnitario"), result.getString("urlFoto"), result.getString("tamanhoProduto"));
                   
                   listProdutos.add(produto);
                 
               }
            }catch(Exception e){
                System.out.println("Erro no select "+e);
                e.printStackTrace();
            }
                   
                   
        }catch(Exception excecaoDowload){
            JOptionPane.showMessageDialog(null,"Houve um erro ao Baixar os dados ... "+ excecaoDowload);
        }finally{
            db.close();
        }
    }
    public void cadastraProduto (Produto produto) throws SQLException{
         try{
            Class.forName("com.mysql.jdbc.Driver");
            db = conexao.getConnection(url, usuario, senha);
            open();  
        }catch(Exception excecaoConexao){
            JOptionPane.showMessageDialog(null,"Houve um erro na conexao... "+excecaoConexao);
            excecaoConexao.printStackTrace();
        } 
        try{
           sql = "INSERT INTO PRODUTO (idProduto,nome, descricao,valorUnitario,TamanhoProduto, idTipoProduto)"
                   + "VALUES (null,'"+produto.getNome()+"','"+produto.getDescricao()+"',"+produto.getValorUnitario()+",'"+produto.getTamanhoProduto()+"',"+produto.getIdTipoProduto()+")";
           statement = db.prepareStatement(sql);     
           statement.executeUpdate();
           
           sql = "SELECT `idProduto` FROM `Produto` ORDER BY idProduto desc LIMIT 1";
           statement = db.prepareStatement(sql);      
           
          try{
            ResultSet result = statement.executeQuery(sql);
            result.next();
              this.id = result.getInt("idProduto");
          }catch(Exception e){
              e.printStackTrace();
          }   

           sql = "INSERT INTO Estoque (idProduto, qtdProduto) VALUES ("+this.id+","+produto.getQuantidade()+")";
           statement = db.prepareStatement(sql);     
           statement.executeUpdate();
           JOptionPane.showMessageDialog(null, "Cadastrado");
        }
        catch(Exception excecaoString){
                JOptionPane.showMessageDialog(null,"Houve um erro ao tentar cadastrar ... "+excecaoString);
                excecaoString.printStackTrace();
        }finally{
            db.close();
        }
    }
    public void filtroPesquisa(ArrayList<Produto> listProdutos, String parametroPesquisa) throws SQLException{
         try{
            Class.forName("com.mysql.jdbc.Driver");
            db = conexao.getConnection(url, usuario, senha);
            open();  
        }catch(Exception excecaoConecao){
            JOptionPane.showMessageDialog(null,"Houve um erro na conexao... "+excecaoConecao);
        }
        try{
           sql = "SELECT p.nome, p.idProduto, p.descricao, p.valorUnitario, p.tamanhoProduto,  quan.qtdProduto, foto.urlFoto FROM produto p  JOIN Estoque quan ON quan.idProduto = p.idProduto JOIN fotoilustrativa foto ON foto.idFoto = p.idFoto "
                   + "WHERE p.nome LIKE '%"+parametroPesquisa+"%'";
            System.out.println(sql);
           statement = db.prepareStatement(sql);        
      
            try(ResultSet result = statement.executeQuery(sql)){
               while (result.next()) {
                   
                   produto = new Produto(result.getInt("idproduto"),result.getString("nome"), result.getInt("qtdProduto"), result.getString("descricao"),
                   result.getDouble("valorUnitario"), result.getString("urlFoto"), result.getString("tamanhoProduto"));
                   if(result == null)
                       JOptionPane.showMessageDialog(null, "Vazio");
                   else
                    listProdutos.add(produto);
                 
               }
            }catch(Exception e){
                System.out.println("Erro no select "+e);
                e.printStackTrace();
            }
                   
                   
        }catch(Exception excecaoDowload){
            JOptionPane.showMessageDialog(null,"Houve um erro ao Baixar os dados ... "+ excecaoDowload);
        }finally{
            db.close();
        }
    }
}
