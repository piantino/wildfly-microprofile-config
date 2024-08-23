Glow
====

Exemplo de saída que mostra o glow:

* Analisando as layers (módulos) necessárias
* Mostrando as configurações que podem ser usadas
* Listando os add-ons (plugins) que podem ser adionados


```
[INFO] Glow is scanning... 
[INFO] Glow scanning DONE.
[INFO] context: cloud
[INFO] enabled profile: none
[INFO] galleon discovery
[INFO] - feature-packs
   org.wildfly:wildfly-galleon-pack:33.0.0.Final
   org.wildfly.cloud:wildfly-cloud-galleon-pack:7.0.1.Final
- layers
   ee-core-profile-server
   jaxrs
   microprofile-config

[INFO] enabled add-ons
[INFO] - health : Support for runtime health checks.
- wildfly-cli : Server command line tools: jboss-cli, add-user, elytron-tool.

[INFO] suggestions
[INFO] 
* you could set the following configuration at runtime
[INFO] 
base-server environment variables:
 - PORT_OFFSET=If defined changes the socket binding group port offset.
deployment-scanner environment variables:
 - AUTO_DEPLOY_EXPLODED=Controls whether exploded deployment content should be automatically deployed.
elytron environment variables:
 - ELYTRON_SECDOMAIN_CORE_REALM=If set to true, the default elytron security domain will be used. The users and roles are retrieved from the server default files.
 - ELYTRON_SECDOMAIN_NAME=Elytron application security domain to configure undertow and ejb3.
 - ELYTRON_SECDOMAIN_ROLES_PROPERTIES=Absolute or relative to jboss.server.config.dir path to properties file that contains users to roles mapping.
 - ELYTRON_SECDOMAIN_USERS_PROPERTIES=Absolute or relative to jboss.server.config.dir path to properties file that contains users and passwords.
 - HTTPS_KEYSTORE=If defined along with HTTPS_PASSWORD and HTTPS_KEYSTORE_DIR, sets the name of the keystore containing the key to use for TLS.
 - HTTPS_KEYSTORE_DIR=If defined along with HTTPS_PASSWORD and HTTPS_KEYSTORE, sets the path to directory containing keystore file. If leading directory separator is omitted, interpreted to be relative to jboss.server.config.dir.
 - HTTPS_KEYSTORE_TYPE=Optional. The underlying type of the keystore (JKS, JCEKS, etc.). The keystore type is automatically discovered by elytron.
 - HTTPS_KEY_PASSWORD=The password used to protect the private key of the generated key pair. If it is undefined, then the HTTPS_PASSWORD value is used as the HTTPS_KEY_PASSWORD.
 - HTTPS_PASSWORD=If defined along with HTTPS_KEYSTORE_DIR and HTTPS_KEYSTORE, sets the password to open the keystore.
logging environment variables:
 - ENABLE_JSON_LOGGING=Enable JSON-formatted logging
 - LOGGER_CATEGORIES=Comma separated list of <logger-name>:<level>
management environment variables:
 - ADMIN_PASSWORD=Admin user password.
 - ADMIN_USERNAME=Admin user name. Used to secure http management interface.
microprofile-config environment variables:
 - MICROPROFILE_CONFIG_DIR=Absolute path to a directory whose contents should be converted to a Microprofile Config ConfigSource. File names within the directory are converted to configuration keys and the file contents are the associated values. An expected use of this setting would be to mount a ConfigMap to a volume and then use the mount point of that volume as the value for MICROPROFILE_CONFIG_DIR, thus converting the ConfigMap into a ConfigSource.
 - MICROPROFILE_CONFIG_DIR_ORDINAL=Ordinal of the Microprofile Config ConfigSource that will be created if MICROPROFILE_CONFIG_DIR is set. The higher the value the higher the precedence of the ConfigSource. The default precedence for the required Microprofile Config system property and environment variable ConfigSources are 400 and 300, respectively. Defaults to 500.
undertow environment variables:
 - ENABLE_ACCESS_LOG=If true add the access-log to the hosts in the undertow subsystem.
 - ENABLE_ACCESS_LOG_TRACE=If true and ENABLE_ACCESS_LOG is also true, adds a TRACE level log category to the logging subsystem
 - FILTERS=Comma separated list of filter names. For each filter the following env vars must be set: <filter>_FILTER_RESPONSE_HEADER_NAME, <filter>_FILTER_RESPONSE_HEADER_VALUE. Optionaly <filter>_FILTER_REF_NAME can be set.
[INFO] * you could enable the following add-ons:
[INFO]   - clustering add-ons:
    - infinispan : Brings in infinispan caches.
    - jgroups-aws : Brings in JBoss Modules modules required to configure the 'aws.S3_PING' discovery protocol.
    - mod_cluster : Support for mod_cluster integration.
  - jaxrs add-ons:
    - openapi : Support for MicroProfile OpenAPI.
  - lra add-ons:
    - lra-coordinator : Support for MicroProfile LRA Coordinator.
  - management add-ons:
    - hal-web-console : Management Web console. Make sure to add an initial user.
    - jdr : Support for the JBoss Diagnostic Reporting (JDR).
  - observability add-ons:
    - metrics : Support for base metrics from the WildFly Management Model and JVM MBeans.
    - micrometer : Support for Micrometer.
  - rpc add-ons:
    - grpc : Support for gRPC.
    - iiop : Support for IIOP.
  - security add-ons:
    - ssl : Support for the Undertow HTTPS listener.
  - web add-ons:
    - load-balancer : Support for Undertow configured as a load balancer.
```
