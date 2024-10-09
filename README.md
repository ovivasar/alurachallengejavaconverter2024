
# Conversor de Moneda

Este proyecto es una aplicación de consola en Java que permite realizar conversiones de monedas entre diversas divisas de América Latina utilizando una API de tipo de cambio en tiempo real. Además, muestra un ranking de la moneda más fuerte en la región.

## Funcionalidades

- Convertir entre las siguientes monedas:
  - Dólar (USD) ↔ Peso Argentino (ARS)
  - Dólar (USD) ↔ Real Brasileño (BRL)
  - Dólar (USD) ↔ Peso Colombiano (COP)
  - Dólar (USD) ↔ Sol Peruano (PEN)
- Visualizar el ranking de la moneda más fuerte de América Latina.
- Guardar el historial de conversiones en un archivo JSON (`conversiones.json`).

## Requisitos

- Java 11+
- Conexión a internet (para consultar la API de tipo de cambio).

## Instalación

1. Clonar el repositorio o descargar los archivos del proyecto.
2. Asegúrate de tener Java 11+ instalado en tu sistema.
3. Compilar el proyecto:

   ```bash
   javac -d bin -sourcepath src src/com/alura/screenmatch/principal/Main.java
   ```

4. Ejecutar el proyecto:

   ```bash
   java -cp bin com.alura.screenmatch.principal.Main
   ```

## Uso

Al ejecutar la aplicación, selecciona una opción del menú para convertir entre las divisas disponibles o visualizar el ranking de la moneda más fuerte. El historial de conversiones se guarda automáticamente en un archivo JSON al finalizar.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Gson**: Librería para manejar JSON.
- **HTTP Client**: Para hacer solicitudes a la API de tipo de cambio.
