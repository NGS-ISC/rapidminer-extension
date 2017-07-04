.PHONY: all install

GRADLEW=./gradlew

SRC=$(shell find src/main/java/com/rapidminer -name *.java)

all: install

install: $(SRC)
	$(GRADLEW) installExtension

init:
	$(GRADLEW) initializeExtensionProject
