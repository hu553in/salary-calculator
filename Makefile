.PHONY: all
all: build run

.PHONY: build
build:
	./gradlew clean assemble

.PHONY: run
run:
	docker-compose up --build

.PHONY: runTestsBackend
runTestsBackend:
	./gradlew test

.PHONY: runTestsFrontend
runTestsFrontend:
	rm -rf ./gui/allure-results
	docker-compose exec ui sh -c 'npx npx wdio run ./wdio.conf.js'
