MAIN = Main

all:
	javac *.java

run: all
	java $(MAIN)

clean:
	rm -f *.class
