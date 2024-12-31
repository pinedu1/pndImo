#!/bin/bash


databases=( "pnd" "joao" "penta" )
HTTPD_ROOT_PATH="/pinedu/contexts"
#databases=( "pnd" "antonio" "jose" "alberto" "vendas" )
for db in "${databases[@]}"; do
    psql --username=pinedu --dbname=template1 -h localhost -c "DROP DATABASE IF EXISTS $db;"
    psql --username=pinedu --dbname=template1 -h localhost -c "DROP ROLE IF EXISTS $db;"
    nomeConf="002-$db-pndimo-com-br.conf"
    rm -Rf HTTPD_ROOT_PATH/$db
    rm -f /etc/httpd/sites-available/$nomeConf
    rm -f /etc/httpd/sites-enabled/$nomeConf
    sed -i "/127.0.0.1 $db.pndimo.com.br/d" /etc/hosts
    systemctl reload httpd
done
