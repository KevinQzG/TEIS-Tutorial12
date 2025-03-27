# TEIS-Tutorial12

# 📦 Tutorial 12 - API REST con Spring Boot

Este proyecto implementa una API REST de productos utilizando Spring Boot. Se desarrollan tres versiones de la API, cada una con mejoras progresivas en arquitectura, organización de datos y presentación con Swagger UI.

---

## 🚀 Tecnologías utilizadas

- ☕ Java 21
- 🧰 Spring Boot 3.4.2
- 📦 Maven
- 🌐 Swagger (springdoc-openapi)
- 💻 Postman
- 🧪 HTML + jQuery para pruebas externas

---

## 🧠 Estructura de versiones

| Versión | Descripción |
|--------|-------------|
| `/api`      | CRUD básico sin DTOs |
| `/api/v2`   | Respuesta con DTOs (ProductDTO) |
| `/api/v3`   | Respuesta con metadatos + paginación (ProductCollection) |

---

## 📂 Estructura del proyecto

```
src/
├── main/
│   ├── java/com/eafit/tutorial12/
│   │   ├── controllers/
│   │   ├── dto/
│   │   ├── models/
│   │   └── config/
│   └── resources/
│       └── application.properties
└── test/
```

---

## ▶️ Cómo ejecutar

```bash
./mvnw clean install
./mvnw spring-boot:run
```

---

## 📮 Endpoints principales

### ✅ V1 – `/api/products`
- `GET /api/products` → Lista todos los productos
- `GET /api/products/{id}` → Devuelve un producto por ID
- `POST /api/products` → Crea un nuevo producto

### ✅ V2 – `/api/v2/products`
- `GET /api/v2/products` → Lista productos usando DTO
- `GET /api/v2/products/{id}` → Devuelve producto con DTO

### ✅ V3 – `/api/v3/products`
- `GET /api/v3/products` → Lista con metadatos
- `GET /api/v3/products/paginate?page=1` → Paginación básica

---

## 🧪 Pruebas

### 🔸 Postman - POST `/api/products`

**URL:** `http://localhost:8080/api/products`  
**Método:** `POST`  
**Body (JSON):**

```json
{
  "id": 3,
  "name": "Producto Nuevo",
  "price": 30.0
}
```

---

### 🔸 Prueba externa desde HTML

Se incluye un archivo `index.html` con jQuery y Bootstrap para probar la API fuera de la app.

```html
<script>
  $.ajax({
    url: "http://localhost:8080/api/products",
    type: "GET",
    dataType: "json",
    success: function(data) {
      console.log(data);
    }
  });
</script>
```

---

## 📑 Swagger UI

Disponible en:  
🔗 [`http://localhost:8080/swagger-ui/index.html`](http://localhost:8080/swagger-ui/index.html)

Muestra y documenta todos los endpoints de forma interactiva con OpenAPI 3.0.

---

## 📸 Evidencias
<img width="1511" alt="Prueba Tuto 12" src="https://github.com/user-attachments/assets/a475e148-7325-4905-beee-2baca79b759f" />
<img width="1510" alt="Prueba Tuto 12_2" src="https://github.com/user-attachments/assets/e1bae82a-3b49-4a77-9028-84675da04ba6" />
<img width="1510" alt="Prueba Tuto12_@" src="https://github.com/user-attachments/assets/7d4f5fdd-7389-48cc-8b9f-33c912a66104" />
<img width="1510" alt="Prueba Tuto12_3" src="https://github.com/user-attachments/assets/0b0b7604-5c5c-48f2-b302-09c9db2e9b5f" />
<img width="1511" alt="Prueba Tuto12_4" src="https://github.com/user-attachments/assets/a246825e-b1af-4bdf-84e7-722b6ba03fdf" />


## 📝 Autor

- 👨‍💻 Kevin Quiroz
