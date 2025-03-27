package com.eafit.tutorial12.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.eafit.tutorial12.models.Product;
import com.eafit.tutorial12.dto.ProductDTO;
import com.eafit.tutorial12.dto.ProductCollection;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product Controller v3", description = "API REST avanzada con metadatos y paginación básica.")
@RestController
@RequestMapping("/api/v3")
@CrossOrigin(origins = "*")
public class ProductControllerV3 {

    private List<Product> products = List.of(
        new Product(1L, "Producto A", 10.0),
        new Product(2L, "Producto B", 20.0),
        new Product(3L, "Producto C", 30.0),
        new Product(4L, "Producto D", 40.0),
        new Product(5L, "Producto E", 50.0),
        new Product(6L, "Producto F", 60.0)
    );

    @Operation(summary = "Listar todos los productos con metadatos", description = "Retorna todos los productos junto a información adicional del store.")
    @GetMapping("/products")
    public ResponseEntity<ProductCollection> index() {
        List<ProductDTO> dtos = products.stream()
            .map(p -> new ProductDTO(p.getId(), p.getName(), p.getPrice()))
            .collect(Collectors.toList());

        ProductCollection collection = new ProductCollection(
            dtos,
            new ProductCollection.AdditionalData("Mega Store", "http://localhost:8080/api/v3/products")
        );

        return ResponseEntity.ok(collection);
    }

    @Operation(summary = "Listar productos paginados", description = "Retorna un subconjunto de productos según el número de página.")
    @GetMapping("/products/paginate")
    public ResponseEntity<ProductCollection> paginate(@RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, products.size());

        List<ProductDTO> dtos = (start >= products.size()) ? List.of() :
            products.subList(start, end).stream()
                .map(p -> new ProductDTO(p.getId(), p.getName(), p.getPrice()))
                .collect(Collectors.toList());

        ProductCollection collection = new ProductCollection(
            dtos,
            new ProductCollection.AdditionalData("Mega Store", "http://localhost:8080/api/v3/products")
        );

        return ResponseEntity.ok(collection);
    }
}
