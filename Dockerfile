FROM eclipse-temurin:23-jdk-noble as build

ENV SRC_HOME=/home/build
WORKDIR $SRC_HOME

COPY gradlew settings.gradle.kts gradle.properties $SRC_HOME/
COPY gradle $SRC_HOME/gradle
COPY build.gradle.kts $SRC_HOME/
RUN chmod +x gradlew && ./gradlew build || exit 0

COPY . .
RUN ./gradlew bootJar


FROM eclipse-temurin:23-jre-noble

ENV SRC_HOME=/home/build
ENV SVG_LOADER_LFS_BASE_PATH=/opt/lovify-server/svgs

COPY --from=build $SRC_HOME/build/libs/lovify-server.jar /opt/lovify-server/lovify-server.jar
COPY --from=build $SRC_HOME/src/test/resources/edited_svgs/ready $SVG_LOADER_LFS_BASE_PATH

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/lovify-server/lovify-server.jar"]