all: test.java eBook.java Book.java Readable.java Item.java
	javac test.java Book.java Readable.java Item.java
	java test

clean:
	$(RM) *.class output.txt