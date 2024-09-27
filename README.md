MicroProfile Config QuickStart
==============================

## Requisitos

### WildFly 33

* Release em Julho de 2024 (A cada 3 meses)
* https://www.wildfly.org/news/2024/07/23/WildFly33-Released/
* Imagem docker: quay.io/wildfly/wildfly:33.0.0.Final-2-jdk21

### Jakarta EE 10

* Release em Setembro de 2022 (Anual)
* https://jakarta.ee/specifications/

### Java SE 21

* Informação extrainda da imagem do wildfly
* Openjdk 21.0.4 2024-07-16 LTS (Extraído)
* Runtime Environment Temurin-21.0.4+7 (build 21.0.4+7-LTS) (64-Bit Server VM)

### Maven 3.9.9

* Release em Agosto de 2024 (Versão minor anual)
* https://maven.apache.org/docs/history.html

### wildfly-maven-plugin 5.0

* https://docs.wildfly.org/wildfly-maven-plugin/releases/5.0/

## Funcionalidades

### REST API

https://jakarta.ee/specifications/restful-ws/3.1/

Documentação da API:

* MicroProfile OpenAPI Subsystem - https://github.com/wildfly/wildfly/blob/main/docs/src/main/asciidoc/_admin-guide/subsystem-configuration/MicroProfile_OpenAPI.adoc
* Open-API - http://localhost:8080/openapi?format=JSON
* Swagger UI - http://localhost:8080/microprofile-config/openapi-ui

### Status do servidor (probes)

MicroProfile Health - https://github.com/wildfly/quickstart/blob/main/microprofile-health/README.adoc

http://localhost:9990/health/live

### Persistência

http://localhost:8080/microprofile-config/todo

Para testar com o swagger:

http://localhost:8080/microprofile-config/openapi-ui

### Autenticação SSO com OpenId Connect

O wildfly já vêm com o Elytron que dá suporte a OpenId Connect.
Basta rodar informando as configurações do SSO.

```
mvn clean wildfly:dev \
    -Dapp.sso.url=https://<servidor keycloak>/realms/<realm> \
    -Dapp.sso.client.id=<id cliente> \
    -Dapp.sso.client.secret=<credencial cliente>
```

http://localhost:8080/microprofile-config/secured/

http://localhost:8080/microprofile-config/secured/username

#### Configurações

* WEB-INF/web.xml
* WEB-INF/oidc.json
  * https://docs.wildfly.org/33/Admin_Guide.html#deployment-configuration

## How-to


### Rodando a aplicação localmente

Não é preciso baixar ou configurar um servidor, basta usar o wildfly-glow:

https://docs.wildfly.org/wildfly-glow/

"WildFly Glow is an evolution of the WildFly Galleon provisioning tooling."

```
./start-dev.sh
```
Ou subir o banco e executar via maven:

```
docker compose up db -d

mvn clean package wildfly:dev
```

Ver a configuração:

http://localhost:8080/microprofile-config/config/value

### Deploy em um servidor já existente

Se preferir configurar o widlfy e standalone na mão (não recomendado):

`mvn clean wildfly:deploy`

### Alterado a variável de configuração


* Arquivo (menor prioridade)

`META-INF/microprofile-config.properties`

* Via variável de ambiente:

```
mvn clean wildfly:dev -Dapp.conf.prop=MyPropertyFileConfigValue-COMMAND_LINE
```

```
mvn clean wildfly:provision
export CONFIG_PROP=MyPropertyFileConfigValue-ENV-VAR
./target/server/bin/standalone.sh -c standalone-microprofile.xml
```

* Por propriedade do sistema (JVM, standalone, etc...)

```
mvn clean wildfly:provision
./target/server/bin/standalone.sh -Dconfig.prop=MyPropertyFileConfigValue-SYS_PROP
```

### Imagem otimizada para Cloud

Construir:

`mvn clean package wildfly:image`

Rodando no docker compose:

`./start-docker.sh`

Abrindo a aplicação:

`open http://localhost:8080/microprofile-config/config/value`

[Exemplo de saída do glow](doc/glow.md)

### Rodando no K8s com minicube

* Acesse o dashboard

`minikube dashboard`

* Construia a imagem acessível para o minikube

`eval $(minikube docker-env)`

`mvn clean package wildfly:image -P openshift`

* Aplique as configurações

`kubectl apply -f ./k8s/postgres-deployment.yaml`

`kubectl apply -f ./k8s/deployment.yaml`

* Acesse o serviço

`minikube service microprofile-config`

### Rodando com helm

É preciso estar com o postgres rodando:

`kubectl apply -f ./k8s/postgres-deployment.yaml`

#### Resolvendo problema ao baixar imagem

É possível usar um register local para contornar problemas.

Instalando serviço de registro de imagem:

`minikube addons enable registry`

Redirecionando porta 500 local para o registry:

`docker run --rm -it --network=host alpine ash -c "apk add socat && socat TCP-LISTEN:5000,reuseaddr,fork TCP:$(minikube ip):5000"`

Criando uma tag local e enviando para o registry do minikube:

```
docker tag microprofile-config:1.0-SNAPSHOT localhost:5000/microprofile-config:1.0-SNAPSHOT
docker push localhost:5000/microprofile-config:1.0-SNAPSHOT
```

Testando o catálogo:

`curl http://localhost:5000/v2/_catalog`

Deve retornar:

```
{"repositories":["microprofile-config"]}
```

#### Usando charts

Subindo com helm:

`helm install microprofile-config wildfly/wildfly -f ./helm/values.yaml`

Redirecionando portas:

`kubectl port-forward service/microprofile-config 8080:8080`

Status:

`kubectl get deployment microprofile-config -w`

Atualizando:

`helm upgrade microprofile-config wildfly/wildfly -f ./helm/values.yaml`

Removendo:

`helm uninstall microprofile-config`

### Analisando recurso

`kubectl top pod microprofile-config-<random>`

```
NAME                                   CPU(cores)   MEMORY(bytes)   
microprofile-config-74c86b5b97-bb6f2   4m           352Mi
```