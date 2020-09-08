.PHONY: all
all: clean prepareMongoDb build run

.PHONY: clean
clean:
	[ -d ./docker/mongodb/home ] | sudo rm -rf ./docker/mongodb/home

.PHONY: prepareMongoDb
prepareMongoDb:
	mkdir -p ./docker/mongodb/home/mongodb
	touch ./docker/mongodb/home/mongodb/.dbshell
	sudo chown -R 999:999 ./docker/mongodb/home/mongodb

.PHONY: build
build:
	./gradlew clean assemble

.PHONY: run
run:
	docker-compose up --build
