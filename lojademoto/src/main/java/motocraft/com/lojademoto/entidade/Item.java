/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motocraft.com.lojademoto.entidade;

/**
 *
 * @author Daniel
 */
public class Item {
    private Produto product = new Produto();
    private int quantity;
        
    
    public Item(Produto product,int quantity){
        super();
        this.product = product;
        this.quantity = quantity;
    }
    
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the product
     */
    public Produto getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Produto product) {
        this.product = product;
    }
}
