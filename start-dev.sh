#!/bin/bash

docker compose up db -d

mvn clean wildfly:dev

