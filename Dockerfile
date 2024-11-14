# Utilizamos una imagen base de Java adecuada (ajustar según tu versión de Java)
FROM openjdk:23

# Establecemos la carpeta de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo pom.xml para construir la aplicación
COPY pom.xml pom.xml

# Instalamos las dependencias
RUN mvn dependency:go-offline

# Copiamos el resto del código fuente
COPY src src

# Construimos la aplicación
RUN mvn package

# Exponemos el puerto donde se ejecutará la aplicación (ajustar según tu configuración)
EXPOSE 8081

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/*.jar"]