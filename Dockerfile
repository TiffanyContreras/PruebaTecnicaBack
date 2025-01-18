# Etapa 1: Construcción
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app

# Copiar archivos necesarios para construir el proyecto
COPY pom.xml .
COPY src ./src

# Construir el proyecto y generar el archivo JAR
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiar el archivo JAR generado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto que utiliza Spring Boot (por defecto, 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]