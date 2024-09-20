#!/bin/bash


databases=( "pnd" "joao" "pedro" "antonio" "jose" "felipe" "alberto" )
#databases=( "pnd" "adriano" "alexandre" "alvaro" "andre" "arthur" "augusto" "benicio" "bruno" "caio" "carlos" "daniel" "diego" "edson" "eduardo" "emerson" "ezequiel" "felipe" "fernando" "gabriel" "gustavo" "hugo" "igor" "joaquim" "jorge" "leandro" "leonardo" "lucas" "marco" "matheus" "murilo" "nathan" "otavio" "paulo" "pedro" "rafael" "ramiro" "raoni" "renato" "robson" "samuel" "sidney" "silvio" "thiago" "tiago" "vinicius" "vitor" "wesley")
for db in "${databases[@]}"; do
    psql --username=pinedu --dbname=template1 -h localhost -c "DROP DATABASE IF EXISTS $db;"
    psql --username=pinedu --dbname=template1 -h localhost -c "DROP ROLE IF EXISTS $db;"
    rm -Rf /var/www/html/$db
    rm -f /etc/httpd/sites-available/99-$db-local-net.conf
    rm -f /etc/httpd/sites-enabled/99-$db-local-net.conf
    sed -i "/127.0.0.1 $db.local.net/d" /etc/hosts
    systemctl reload httpd
done
