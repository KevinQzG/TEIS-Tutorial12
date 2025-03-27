<<<<<<< HEAD
# TEIS-Tutorial12
=======
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

## 📝 Autor

- 👨‍💻 Kevin Quiroz
>>>>>>> master
