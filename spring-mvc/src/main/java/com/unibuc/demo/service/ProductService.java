package com.unibuc.demo.service;

import com.unibuc.demo.dto.ProductDto;
import com.unibuc.demo.mapper.ProductMapper;
import com.unibuc.demo.mapper.ShopMapper;
import com.unibuc.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductMapper productMapper;
    private final ShopMapper shopMapper;
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductMapper productMapper, ShopMapper shopMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.shopMapper = shopMapper;
        this.productRepository = productRepository;
    }

    public void createProduct(ProductDto productDto) {
        productRepository.create(productMapper.convertProductFrom(productDto));
    }
}
