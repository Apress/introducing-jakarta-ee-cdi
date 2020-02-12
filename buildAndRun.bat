@echo off
call mvn clean package
call docker build -t com.pedantic/jee-book .
call docker rm -f jee-book
call docker run -d -p 8080:8080 -p 4848:4848 --name jee-book com.pedantic/jee-book