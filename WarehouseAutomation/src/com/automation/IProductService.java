package com.automation;
import java.util.List;

public interface IProductService {
    boolean add(Product product);
    boolean remove(int productId);
    Product search(int productId);
    List<Product> searchByCategory(ProductCategory category);
}
