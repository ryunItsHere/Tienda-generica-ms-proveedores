# ETAPA 1: Compilación (Build)
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app

# Copiamos el archivo de configuración de dependencias
COPY pom.xml .
# Descargamos las dependencias (esto acelera futuras compilaciones)
RUN mvn dependency:go-offline

# Copiamos el código fuente y compilamos el proyecto saltando los tests
COPY src ./src
RUN mvn clean package -DskipTests

# ETAPA 2: Ejecución (Runtime)
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Usamos el asterisco para que no importe la versión exacta del SNAPSHOT
COPY target/*.jar app.jar
# Verificamos
RUN ls -l app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]