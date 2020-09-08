FROM openjdk:11-slim

ADD https://github.com/ufoscout/docker-compose-wait/releases/latest/download/wait /wait
RUN chmod +x /wait
