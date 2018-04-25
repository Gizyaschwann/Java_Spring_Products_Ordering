package io.innopolis.products.models;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "productName"))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long productId;

    private String productName;

    private Double productPrice;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }


}