docker build -t crudbasico .

// maven -> clean -> install

docker run -d --name meu-crudbasico -p 8080:8080 --restart unless-stopped crudbasico

docker network create minha-rede

docker run --name bancodedados --network minha-rede -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql

docker run -d --name meu-crudbasico --network minha-rede -p 8080:8080 --restart unless-stopped crudbasico

spring.datasource.url=jdbc:mysql://meu-mysql:3306/nome_do_banco?useSSL=false&serverTimezone=UTC-3

