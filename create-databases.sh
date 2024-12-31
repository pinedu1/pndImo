#!/usr/bin/env bash

NOME_HTTP="httpd"
HTTPD_PATH="/etc/$NOME_HTTP"
HTTPD_LOG_PATH="/var/log/$NOME_HTTP"
HTTPD_ROOT_PATH="/pinedu/contexts"
FILECFG="/pinedu/config/appImo.properties"
#psql --username=pinedu --dbname=template1 -h localhost -c "SELECT pid, usename, application_name, client_addr, client_hostname, client_port, query_start FROM pg_stat_activity;"
declare -A mapaDataBase

# Adicionando chaves e valores
mapaDataBase["pnd"]="x8DwsDRMUvxqrq#L"
mapaDataBase["joao"]="vaP#PxZC5kWsT#KR"
mapaDataBase["penta"]="93R6J3cfXSICpkN!"

cria_httpd_virtual_host() {
	NOME_HOST="$(echo $1 | tr '[:upper:]' '[:lower:]' )"
	DOMAIN=$2
	HOST_URL="$NOME_HOST.$DOMAIN"
	cd $HTTPD_PATH/sites-available
	NOME_FILE="002-$NOME_HOST-${DOMAIN//./-}"
	FILE="$HTTPD_PATH/sites-available/$NOME_FILE.conf"
	WEBFOLDER="$HTTPD_ROOT_PATH/$NOME_HOST/public_html"
	mkdir -p $WEBFOLDER
	cat << ZEOF > $FILE
<VirtualHost *:80>
  ServerAdmin eduardo@pinedu.com.br
  ServerName $HOST_URL
  DocumentRoot $WEBFOLDER

  LogLevel warn
  ErrorLog $HTTPD_LOG_PATH/$NOME_HOST-${DOMAIN//./-}-error.log
  CustomLog $HTTPD_LOG_PATH/$NOME_HOST-${DOMAIN//./-}-access.log combined

  <Directory $WEBFOLDER >
    Options -Indexes +FollowSymLinks +MultiViews
    AllowOverride All
    Require all granted
    # Configuração para o WordPress (mod_rewrite)
    <IfModule mod_rewrite.c>
      RewriteEngine On
      RewriteBase /
      RewriteRule ^index\.php$ - [L]
      RewriteCond %{REQUEST_FILENAME} !-f
      RewriteCond %{REQUEST_FILENAME} !-d
      RewriteRule . /index.php [L]
    </IfModule>
  </Directory>

  # Configuração do Proxy para WebSocket (STOMP)
  ProxyPass /app/stomp ws://localhost:8080/app/stomp
  ProxyPassReverse /app/stomp ws://localhost:8080/app/stomp

  ProxyPass /app http://localhost:8080/app
  ProxyPassReverse /app http://localhost:8080/app

  <LocationMatch "/app" >
    Header add X-Tenant-ID $(echo $NOME_HOST | tr '[:lower:]' '[:upper:]' )
    RequestHeader set X-Tenant-ID $(echo $NOME_HOST | tr '[:lower:]' '[:upper:]' )
  </LocationMatch>

  <Proxy "unix:/run/php-fpm/www.sock|fcgi://php-fpm">
    ProxySet disablereuse=off
  </Proxy>
  <FilesMatch \.php$>
    SetHandler proxy:fcgi://php-fpm
  </FilesMatch>
</VirtualHost>
ZEOF
	FILE="$WEBFOLDER/index.html"
	cat << ZEOF > $FILE
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
ZEOF
	ln -s "$HTTPD_PATH/sites-available/$NOME_FILE.conf" "$HTTPD_PATH/sites-enabled/$NOME_FILE.conf"
	systemctl reload $NOME_HTTP
}
cria_role() {
	USERNAME=$1
	PASSWORD=$2
	psql --username=pinedu --dbname=template1 -h localhost -c "CREATE ROLE $USERNAME WITH LOGIN PASSWORD '$PASSWORD'; GRANT pg_read_server_files TO $USERNAME;"
}
cria_database() {
	DATABASE=$1
	USERNAME=$2
	psql --username=pinedu --dbname=template1 -h localhost -c "CREATE DATABASE $DATABASE OWNER $USERNAME;"
}
cria_hosts() {
	NOME_HOST=$(echo $1 | tr '[:upper:]' '[:lower:]' )
	DOMAIN=$2
	HOST_URL=$NOME_HOST.$DOMAIN
	echo "127.0.0.1 $HOST_URL" >> /etc/hosts
}
inicializa_Tenants() {
  FILE=$1
  rm -f $FILE
cat << ZEOF > $FILE
# Configurações da Aplicação
server.servlet.context-path=/app
grails.gorm.reactor.events=false
grails.gorm.multiTenancy.mode=DATABASE
grails.gorm.multiTenancy.tenantResolverClass=br.com.pinedu.tenant.PineduTenantResolver
grails.plugin.databasemigration.updateAllOnStart=true
grails.plugin.databasemigration.updateOnStartFileName=changelog.groovy
grails.plugin.databasemigration.changelogFileName=changelog.groovy
# DataBases
#
ZEOF
}
adicionar_tenant_config() {
	USERNAME=$1
	PASSWORD=$2
	CONTEXT="$(echo $USERNAME | tr '[:lower:]' '[:upper:]')"
	DOMAIN=$3
	FILE=$4
cat << ZEOF >> "$FILE.cfg"
#
# Cliente: $USERNAME
$CONTEXT.ativo=true
$CONTEXT.contexto=$USERNAME
$CONTEXT.documentRoot=/pinedu/contexts/$USERNAME/public_html
$CONTEXT.email=$USERNAME@$DOMAIN
$CONTEXT.maximoSimultaneos=5
$CONTEXT.nome=$USERNAME
$CONTEXT.pathMedia=/pinedu/contexts/$USERNAME/media
$CONTEXT.posicaoLogo=inferior-direito
$CONTEXT.promocao=false
$CONTEXT.serverBaseUrl=http://$USERNAME.$DOMAIN
dataSources.$CONTEXT.contexto=$USERNAME
dataSources.$CONTEXT.dbCreate=none
dataSources.$CONTEXT.password=$PASSWORD
dataSources.$CONTEXT.url=jdbc:postgresql://localhost:5432/$USERNAME?ApplicationName=pndimo_DB:$USERNAME
dataSources.$CONTEXT.username=$USERNAME
dataSources.$CONTEXT.properties.jmxEnabled: true
dataSources.$CONTEXT.properties.initialSize: 3
dataSources.$CONTEXT.properties.maxActive: 5
dataSources.$CONTEXT.properties.minIdle: 2
dataSources.$CONTEXT.properties.maxIdle: 3
#
ZEOF
}
criar() {
	db=$1
	passwd=$2
	domain=$3

	inicializa_Tenants $FILECFG
	if [[ "$db" != "pnd" ]]; then
    adicionar_tenant_config $db $passwd $domain $FILECFG
  fi
  cria_httpd_virtual_host $db $domain
  cria_role $db $passwd
  cria_database $db $db
  cria_hosts $db $domain
}

#!!! PRODUÇÂO !!!
# Configuração do UserDir no Apache
#Habilitar o módulo mod_userdir: O módulo responsável por essa funcionalidade é o mod_userdir. Certifique-se de que ele está habilitado no Apache.
rm -f "$FILECFG.cfg"
for db in ${!mapaDataBase[@]}; do
  criar $db ${mapaDataBase[$db]} 'pndimo.com.br'
done
cat "$FILECFG.cfg" >> "$FILECFG"
rm -f "$FILECFG.cfg"
chown -Rf eduardo: /pinedu
chmod -Rf 777 /pinedu