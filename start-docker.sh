#!/bin/bash

mvn clean package wildfly:image

docker compose up --force-recreate
