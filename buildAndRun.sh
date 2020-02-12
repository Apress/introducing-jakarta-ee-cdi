#!/bin/sh
mvn clean package && docker build -t com.pedantic/jee-book .
docker rm -f jee-book || true && docker run -d -p 8080:8080 -p 4848:4848 --name jee-book com.pedantic/jee-book