FROM airhacks/glassfish
COPY ./target/footballtournament-project.war ${DEPLOYMENT_DIR}
