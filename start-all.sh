#!/bin/bash

echo "=== Starting MySQL with Podman ==="
./start-mysql.sh

echo "=== Waiting and loading schema + test data ==="
./load-test-data.sh

echo "=== Building and starting Spring Boot application ==="
./run-app.sh
