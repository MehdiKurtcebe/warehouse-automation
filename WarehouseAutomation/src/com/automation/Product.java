package com.automation;

public class Product implements Comparable<Product> {
    private int id;
    private int storeId;
    private String name;
    private int stockCount;
    private ProductCategory category;

    Product(){}

    Product(int storeId, String name, int stockCount, ProductCategory category_){
        id = IdGenerator.GetFreshProductId();
        this.storeId = storeId;
        this.name = name;
        this.stockCount = stockCount;
        category = category_;
    }

    public int getId() {
        return id;
    }


    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category_) {
        category = category_;
    }

    @Override
    public int compareTo(Product o) {
        return id - o.getId();
    }
}
