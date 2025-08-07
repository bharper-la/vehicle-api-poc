#!/bin/bash
echo "Waiting for MySQL to be ready..."

# Wait until MySQL is ready to accept connections
until podman exec vehicle-mysql mysqladmin ping -ppassword --silent; do
    sleep 2
done

echo "Dropping existing schema..."
podman exec -i vehicle-mysql mysql -uroot -ppassword -e "DROP DATABASE IF EXISTS vehicles; CREATE DATABASE vehicles;"

echo "Creating schema from normalized_vehicle_schema.sql..."
podman exec -i vehicle-mysql mysql -uroot -ppassword vehicles < src/main/resources/normalized_vehicle_schema.sql

echo "Loading test data from data.sql..."
podman exec -i vehicle-mysql mysql -uroot -ppassword vehicles < src/main/resources/data.sql

echo "Schema and test data loaded."
