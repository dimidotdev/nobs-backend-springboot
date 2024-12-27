package com.dimidotdev.nobs.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dimidotdev.nobs.product.model.Product;
import com.dimidotdev.nobs.product.model.ProductDTO;
import com.dimidotdev.nobs.product.model.UpdateProductCommand;
import com.dimidotdev.nobs.product.services.CreateProductService;
import com.dimidotdev.nobs.product.services.DeleteProductService;
import com.dimidotdev.nobs.product.services.GetProductService;
import com.dimidotdev.nobs.product.services.GetProductsService;
import com.dimidotdev.nobs.product.services.UpdateProductService;

@RestController
public class ProductController {

    private final CreateProductService createProductService;

    private final GetProductService getProductService;

    private final GetProductsService getProductsService;

    private final UpdateProductService updateProductService;

    private final DeleteProductService deleteProductService;


    public ProductController(CreateProductService createProductService, GetProductService getProductService, GetProductsService getProductsService,
                             UpdateProductService updateProductService, DeleteProductService deleteProductService) {
        this.createProductService = createProductService;
        this.getProductService = getProductService;
        this.getProductsService = getProductsService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return createProductService.execute(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return getProductsService.execute(null);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        return getProductService.execute(id);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return updateProductService.execute(new UpdateProductCommand(id, product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        return deleteProductService.execute(id);
    }
}