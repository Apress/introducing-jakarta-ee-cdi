FROM payara/server-full:latest
COPY target/jee-book.war $DEPLOY_DIR