/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author usuario
 */
public class Produto {
    
    private String nome, descricao;
    private int id, idTipoProduto;
    private int qtdProduto = 0;
    private boolean selected;
    private double valorUnitario;
    private Button botao;
    private String  TamanhoProduto;
    public Produto(){
        
    }
    public int getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(int idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }
   
    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public ImageView getIcon() {
        return icon;
    }

    public void setIcon(ImageView icon) {
        this.icon = icon;
    }

    public Image getIconImage() {
        return iconImage;
    }

    public void setIconImage(Image iconImage) {
        this.iconImage = iconImage;
    }
    @FXML
    private ImageView icon = new ImageView();
    @FXML
    private Image iconImage;
    public Produto(int id, String nome, int quantidade, String descricao, double valorUnitario, String url, String tamanhoProduto){
        this.nome = nome;
        this.qtdProduto = quantidade;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.iconImage = new Image(url);
        this.icon.setImage(iconImage);
         this.icon.setFitWidth(100);
         this.icon.setPreserveRatio(true);
         this.icon.setSmooth(true);
         this.icon.setCache(true);
        this.id = id;
        this.TamanhoProduto = TamanhoProduto;
        
    }

    public String getTamanhoProduto() {
        return TamanhoProduto;
    }

    public void setTamanhoProduto(String idTamanhoProduto) {
        this.TamanhoProduto = idTamanhoProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Button getBotao() {
        return botao;
    }

    public void setBotao(Button botao) {
        this.botao = botao;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return qtdProduto;
    }

    public void setQuantidade(int quantidade) {
        this.qtdProduto = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
