package com.automation;

import java.util.LinkedList;
import java.util.List;

public class ProductService implements IProductService {
    private static List<Product> products = new LinkedList<>(); //TODO update with selected data structure

    @Override
    public boolean add(Product product) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(int productId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Product search(int productId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Product> searchByCategory(ProductCategory category) {
        throw new UnsupportedOperationException();
    }
}
