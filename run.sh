#!/bin/bash
echo "Limpiando archivos compilados..."
find . -name "*.class" -delete

echo "Compilando proyecto..."
javac -cp ".:$HOME/Desktop/mysql-connector-j-9.3.0.jar:$HOME/Desktop/dotenv-java-3.0.0.jar" src/**/*.java

if [ $? -eq 0 ]; then
    echo "Compilación exitosa. Ejecutando programa..."
    java -cp ".:src:$HOME/Desktop/mysql-connector-j-9.3.0.jar:$HOME/Desktop/dotenv-java-3.0.0.jar" controlador.Main
else
    echo "Error en compilación"
fi
