#!/bin/bash

docker build --tag=tjsc/microprofile-config .

docker run -d -p 8080:8080 -p 9990:9990 tjsc/microprofile-config

mvn clean package wildfly:deploy -Dwildfly.username=admin -Dwildfly.password=admin123

open http://localhost:8080/microprofile-config/config/value