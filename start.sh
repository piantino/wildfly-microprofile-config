#!/bin/bash

mvn clean package wildfly:image -P openshift

docker compose up --force-recreate
