FROM postgres
COPY baseDatos.sql /docker-entrypoint-initdb.d/
