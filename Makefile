default: buildAndRun

buildAndRun: build run

build: clean
	javac -d . source/*.java

run:
	java code.Demo

clean:
	rm -rf code
