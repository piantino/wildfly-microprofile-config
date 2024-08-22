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

## How-to


### Rodando a aplicação

* Baixar o wildfly e executar:

```
WILDFLY_HOME/bin/standalone.sh -c standalone-microprofile.xml
```

* Construir e publicar a aplicação:

`mvn clean package wildfly:deploy`

* Acessa e ver a configuração:

http://localhost:8080/microprofile-config/config/value

### Alterado a variável de configuração


* Arquivo (menor prioridade)

`META-INF/microprofile-config.properties`

* Via variável de ambiente:

```
export CONFIG_PROP=MyPropertyFileConfigValue-ENV-VAR
WILDFLY_HOME/bin/standalone.sh -c standalone-microprofile.xml
```

* Por propriedade do sistema (JVM, standalone, etc...)

```
WILDFLY_HOME/bin/standalone.sh -c standalone-microprofile.xml -Dconfig.prop=MyPropertyFileConfigValue-SYS_PROP
```

