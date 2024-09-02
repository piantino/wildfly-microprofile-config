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
   microprofile-openapi
   jpa

[INFO] enabled add-ons
[INFO] - health : Support for runtime health checks.
- openapi : Support for MicroProfile OpenAPI.
- wildfly-cli : Server command line tools: jboss-cli, add-user, elytron-tool.

[INFO] identified errors
[ERROR] * unbound datasources error: java:jboss/datasources/HibernateQuickstartDS
  To correct this error, enable one of the following add-ons:
  - mariadb
  - mssqlserver
  - mysql
  - oracle
  - postgresql

[INFO] suggestions
[INFO] 
* you could set the following configuration at runtime
[INFO] 
base-server environment variables:
 - PORT_OFFSET=If defined changes the socket binding group port offset.
datasources environment variables:
 - DB_SERVICE_PREFIX_MAPPING=It is used to define the mapping prefixes for datasources. The allowed value for this variable is a comma-separated list of POOLNAME-DATABASETYPE=PREFIX triplets, where POOLNAME is used as the pool-name in the datasource, DATABASETYPE is the database driver to use, PREFIX is the prefix used in the names of environment variables that are used to configure the datasource. Required.
 - {POOLNAME}_{DATABASETYPE}_SERVICE_HOST=Defines the database server’s host name or IP address to be used in the datasource’s connection-url property. Required if {PREFIX}_URL is not defined, this variable is required for internal datasources. External datasources don't use this environment variable.
 - {POOLNAME}_{DATABASETYPE}_SERVICE_PORT=Defines the database server’s port for the datasource. Required if {PREFIX}_URL is not defined, this variable is required for internal datasources. External datasources don't use this environment variable.
 - {PREFIX}_BACKGROUND_VALIDATION=When set to true database connections are validated periodically in a background thread prior to use. Defaults to false, meaning the validate-on-match method is enabled by default instead. Defaults to 'false'
 - {PREFIX}_BACKGROUND_VALIDATION_MILLIS=Specifies frequency of the validation, in milliseconds, when the background-validation database connection validation mechanism is enabled ({PREFIX}_BACKGROUND_VALIDATION variable is set to true). Defaults to 10000.
 - {PREFIX}_CONNECTION_CHECKER=Specifies a connection checker class that is used to validate connections for the particular database in use. Optional.
 - {PREFIX}_DATABASE=Defines the database name for the datasource. Required if {PREFIX}_URL is not defined, this variable is required for internal datasources. External datasources don't use this environment variable.
 - {PREFIX}_DRIVER=Defines Java database driver for the datasource. This environment variable must be defined only for external datasources. In case of an internal datasource, the datasource driver name in derived from the type of the datasource in use. For PostgreSQL datasource, the driver name is 'postgresql'. For MySQL, the name is 'mysql'. Optional, for internal datasources. Required for external datasources.
 - {PREFIX}_EXCEPTION_SORTER=Specifies the exception sorter class that is used to properly detect and clean up after fatal database connection exceptions. Optional.
 - {PREFIX}_JNDI=Defines the JNDI name for the datasource. Defaults to java:jboss/datasources/POOLNAME_DATABASETYPE, where POOLNAME and DATABASETYPE are taken from the triplet described in DB_SERVICE_PREFIX_MAPPING. This setting is useful if you want to override the default generated JNDI name.
 - {PREFIX}_JTA=Defines Java Transaction API (JTA) option for the non-XA datasource. The XA datasources are already JTA capable by default. Defaults to 'true'
 - {PREFIX}_MAX_POOL_SIZE=Defines the maximum pool size option for the datasource. Optional.
 - {PREFIX}_MIN_POOL_SIZE=Defines the minimum pool size option for the datasource. Optional.
 - {PREFIX}_NONXA=Defines the datasource as a non-XA datasource. Defaults to false.
 - {PREFIX}_PASSWORD=Defines the password for the datasource. Required.
 - {PREFIX}_TX_ISOLATION=Defines the java.sql.Connection transaction isolation level for the datasource. Optional.
 - {PREFIX}_URL=Defines connection URL for the datasource. Optional for internal data sources. Required for external datasources. In case of an internal datasource, the connection URL is derived from the environment. For PostgreSQL datasource type, the connection-url defaults to 'jdbc:postgresql://{POOLNAME}_{DATABASETYPE}_SERVICE_HOST:{POOLNAME}_{DATABASETYPE}_SERVICE_PORT'
 - {PREFIX}_USERNAME=Defines the username for the datasource. Required.
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
  - database add-ons:
    - h2-database : Support for an H2 datasource.
    - mariadb : Documentation in https://github.com/wildfly-extras/wildfly-datasources-galleon-pack
    - mssqlserver : Documentation in https://github.com/wildfly-extras/wildfly-datasources-galleon-pack
    - mysql : Documentation in https://github.com/wildfly-extras/wildfly-datasources-galleon-pack
    - oracle : Documentation in https://github.com/wildfly-extras/wildfly-datasources-galleon-pack
    - postgresql : Documentation in https://github.com/wildfly-extras/wildfly-datasources-galleon-pack
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

[INFO] * you could enable profiles:
[INFO]   - ha
```