FROM postgres:latest

ENV POSTGRES_USER=wcu
ENV POSTGRES_PASSWORD=wcu123
ENV POSTGRES_DB=wcu-db

COPY init.sql /docker-entrypoint-initdb.d/
