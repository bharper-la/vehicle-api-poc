#!/bin/bash
echo "Building Spring Boot application..."
mvn clean package -DskipTests
echo "Starting Spring Boot application..."
java -jar target/vehicle-api-1.0.0.jar
