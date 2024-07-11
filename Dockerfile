# temp build
FROM docker.io/gradle:8.4.0 AS TEMP_BUILD
ARG SKIP_TESTS=false
# Copy project files
COPY build.gradle settings.gradle /home/gradle/src/
COPY src /home/gradle/src/src
COPY gradle /home/gradle/src/gradle
COPY config /home/gradle/src/config
# COPY applicationinsights-agent-3.4.8.jar  /build/applicationinsights-agent-3.4.8.jar
# COPY applicationinsights.json /build/applicationinsights.json
WORKDIR /home/gradle/src
RUN if [ "$SKIP_TESTS" = "true" ]; then \
    gradle build --no-daemon -x test; \
  else \
    gradle build --no-daemon; \
  fi

# build image
FROM eclipse-temurin:17.0.8.1_1-jre-jammy
ENV APP_CONFIG_SOURCE_NAME=azure
ENV VAULT_ADAPTER_IMPLEMENTATION=azure
# temporary workaround until environment variables are correctly set in the aca
# ENV SPRING_PROFILES_ACTIVE=dev
WORKDIR /app
COPY --from=TEMP_BUILD /home/gradle/src/build/libs/*.jar /app/
# COPY --from=TEMP_BUILD /build/applicationinsights-agent-3.4.8.jar /app/applicationinsights-agent-3.4.8.jar
# COPY --from=TEMP_BUILD /build/applicationinsights.json /app/applicationinsights.json
ENTRYPOINT ["java", "-javaagent:applicationinsights-agent-3.4.8.jar", "-jar", "/app/remote-signature-ms-0.6.0.jar"]