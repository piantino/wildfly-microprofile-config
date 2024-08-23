# Não é necessária no profile openshit
# Apenas para rodar a imagem inteira do wildfly

FROM quay.io/wildfly/wildfly:33.0.0.Final-2-jdk21
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin123 --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone-microprofile.xml", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]