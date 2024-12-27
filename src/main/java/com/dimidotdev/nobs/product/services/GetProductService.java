package com.dimidotdev.nobs.product.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dimidotdev.nobs.Query;
import com.dimidotdev.nobs.product.ProductRepository;
import com.dimidotdev.nobs.product.model.Product;
import com.dimidotdev.nobs.product.model.ProductDTO;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {

    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        Optional<Product> productOptional = productRepository.findById(input);

        if(productOptional.isPresent()) {
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }

        return null;
    }

}
