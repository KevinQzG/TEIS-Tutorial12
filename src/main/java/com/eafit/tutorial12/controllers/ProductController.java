package com.eafit.tutorial12.controllers;

import java.util.ArrayList;
import java.util.List;

import com.eafit.tutorial12.models.Product;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product Controller v1", description = "API REST básica con lista de productos sin uso de DTOs.")
@RestController
@RequestMapping("/api")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1L, "Producto A", 10.0));
        products.add(new Product(2L, "Producto B", 20.0));
    }

    @Operation(summary = "Obtener todos los productos", description = "Retorna una lista simple de productos.")
    @GetMapping("/products")
    public ResponseEntity<List<Product>> index() {
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Obtener producto por ID", description = "Busca un producto por su ID y lo retorna.")
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> show(@PathVariable Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear nuevo producto", description = "Crea un producto nuevo en la lista simulada.")
    @PostMapping("/products")
    public ResponseEntity<Product> create(@org.springframework.web.bind.annotation.RequestBody Product newProduct) {
        products.add(newProduct);
        return ResponseEntity.ok(newProduct);
    }
}
