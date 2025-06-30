#!/bin/bash

# Verificar si estamos en el directorio correcto
cd /Users/laurahigueraromero/eclipse-workspace/EmpresaRefactorizada/src

# Compilar los archivos
javac -cp ".:/Users/laurahigueraromero/Desktop/mysql-connector-j-9.3.0.jar" dao/AltasDao.java dao/DatabaseConnection.java dao/AltaEmpleado.java

# Ejecutar el programa
java -cp ".:/Users/laurahigueraromero/Desktop/mysql-connector-j-9.3.0.jar" dao.AltaEmpleado
