package com.eafit.tutorial12.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.eafit.tutorial12.models.Product;
import com.eafit.tutorial12.dto.ProductDTO;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product Controller v2", description = "API REST usando DTOs para separar lógica de presentación.")
@RestController
@RequestMapping("/api/v2")
public class ProductControllerV2 {

    private List<Product> products = List.of(
        new Product(1L, "Producto A", 10.0),
        new Product(2L, "Producto B", 20.0)
    );

    @Operation(summary = "Obtener productos con DTOs", description = "Lista todos los productos usando DTOs.")
    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> index() {
        List<ProductDTO> dtos = products.stream()
            .map(p -> new ProductDTO(p.getId(), p.getName(), p.getPrice()))
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Obtener producto por ID con DTO", description = "Retorna un producto usando DTO por su ID.")
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> show(@PathVariable Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(p -> new ProductDTO(p.getId(), p.getName(), p.getPrice()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
