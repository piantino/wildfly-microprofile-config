#!/bin/bash

docker build --tag=microprofile-config:fat .

docker run -d -p 8080:8080 -p 9990:9990 microprofile-config:fat

mvn clean package wildfly:deploy -Dwildfly.username=admin -Dwildfly.password=admin123

echo "http://localhost:8080/microprofile-config/config/value"