#!/bin/bash
echo "Starting MySQL container..."
podman run --name vehicle-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=vehicles -p 3306:3306 -d mysql:8.0
echo "MySQL container started on port 3306"
