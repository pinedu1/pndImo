#!/bin/bash

NOME_HTTP="httpd"
HTTPD_PATH="/etc/$NOME_HTTP"
HTTPD_LOG_PATH="/var/log/$NOME_HTTP"
HTTPD_ROOT_PATH="/var/www/html"
databases=( "pnd" "joao" "pedro" "antonio" "jose" "felipe" "alberto" )
#psql --username=pinedu --dbname=template1 -h localhost -c "SELECT pid, usename, application_name, client_addr, client_hostname, client_port, query_start FROM pg_stat_activity;"





cria_httpd_virtual_host() {
	NOME_HOST="$(echo $1 | tr '[:upper:]' '[:lower:]' )"
	HOST_URL="$NOME_HOST.local.net"
	cd $HTTPD_PATH/sites-available
	NOME_FILE="99-$NOME_HOST-local-net.conf"
	FILE="$HTTPD_PATH/sites-available/$NOME_FILE"
	mkdir -p "$HTTPD_ROOT_PATH/$NOME_HOST"
	cat << ZEOF > $FILE
<VirtualHost *:80>
	ServerAdmin eduardo@pinedu.com.br
	ServerName $HOST_URL
	DocumentRoot $HTTPD_ROOT_PATH/$NOME_HOST

	ErrorLog $HTTPD_LOG_PATH/$NOME_HOST-error.log
	LogLevel warn
	CustomLog $HTTPD_LOG_PATH/$NOME_HOST-access.log combined

	<Directory "$HTTPD_ROOT_PATH/$NOME_HOST" >
		Options -Indexes +FollowSymLinks +MultiViews
		AllowOverride All
		Require all granted
	</Directory>

	ProxyPass /app http://localhost:8080/app
	ProxyPassReverse /app http://localhost:8080/app
	
	<LocationMatch "/app" >
		Header add X-Tenant-ID "$(echo $NOME_HOST | tr '[:lower:]' '[:upper:]' )"
		RequestHeader set X-Tenant-ID "$(echo $NOME_HOST | tr '[:lower:]' '[:upper:]' )"
	</LocationMatch>
	
	<Proxy "unix:/run/php-fpm/www.sock|fcgi://php-fpm">
		ProxySet disablereuse=off
	</Proxy>

	<FilesMatch \.php$>
		SetHandler proxy:fcgi://php-fpm
	</FilesMatch>    
</VirtualHost>
ZEOF
	FILE="$HTTPD_ROOT_PATH/$NOME_HOST/index.html"
	cat << ZEOF2 > $FILE
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Cliente $(echo $NOME_HOST | tr '[:lower:]' '[:upper:]' )</title>
		<style>
			body {
				font-family: Arial, sans-serif;
				background-color: #f4f4f4;
				margin: 0;
				padding: 0;
			}
			header {
				background-color: #333;
				color: #fff;
				padding: 10px 0;
				text-align: center;
			}
			nav {
				text-align: center;
				margin: 10px 0;
			}
			nav a {
				margin: 0 15px;
				text-decoration: none;
				color: #333;
			}
			main {
				padding: 20px;
			}
			footer {
				background-color: #333;
				color: #fff;
				text-align: center;
				padding: 10px 0;
				position: fixed;
				width: 100%;
				bottom: 0;
			}
		</style>
	</head>
	<body>
	<header>
		<h1>Bem-vindo à Página do Cliente $(echo $NOME_HOST | tr '[:lower:]' '[:upper:]' )</h1>
	</header>
	<nav>
		<a href="#home">Início</a>
		<a href="#sobre">Sobre</a>
		<a href="#contato">Contato</a>
		<a href="/app">Imóveis</a>
	</nav>
	<main>
		<section id="home">
		<h2>Início</h2>
			<p>Esta é uma página de exemplo para $(echo $NOME_HOST | tr '[:lower:]' '[:upper:]' ).</p>
		</section>
		<section id="sobre">
			<h2>Sobre</h2>
			<p>HTML5 é a versão mais recente do HTML, a linguagem usada para criar páginas da web.</p>
		</section>
		<section id="contato">
			<h2>Contato</h2>
			<p>Você pode nos contatar enviando um email para <a href="mailto:eduardo@pinedu.com.br">eduardo@pinedu.com.br</a>.</p>
		</section>
	</main>
	<footer>
		<p>&copy; 2024 Página de Exemplo. Todos os direitos reservados.</p>
	</footer>
	</body>
</html>
ZEOF2
	ln -s "$HTTPD_PATH/sites-available/$NOME_FILE" "$HTTPD_PATH/sites-enabled/$NOME_FILE" 
	systemctl reload $NOME_HTTP
}
cria_role() {
	USERNAME=$1
	PASSWORD=$2
	psql --username=pinedu --dbname=template1 -h localhost -c "CREATE ROLE $USERNAME WITH LOGIN PASSWORD '$PASSWORD';"
}
cria_database() {
	DATABASE=$1
	USERNAME=$2
	psql --username=pinedu --dbname=template1 -h localhost -c "CREATE DATABASE $DATABASE OWNER $USERNAME;"
}
cria_hosts() {
	NOME_HOST=$(echo $1 | tr '[:upper:]' '[:lower:]' )
	HOST_URL="$NOME_HOST.local.net"
	echo "127.0.0.1 $HOST_URL" >> /etc/hosts
}
criar() {
	db=$1
	cria_role "$db" '$db-\$P\$R%ccG!xo9%JFwet'
	cria_database "$db" "$db"
    	cria_httpd_virtual_host $db
    	cria_hosts $db
}
for db in "${databases[@]}"; do
	criar "$db"
done


