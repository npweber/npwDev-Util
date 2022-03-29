# v1_1_0-5

  Additions:
  
 - Inputter: Retrieves user input via command line
 - Sleeper: Bundled sleep functionality of program main thread
 - ReaderGrouper: An extension of Reader: Reads an entire file into a `Grouper<String>`, consisting of all the lines in the file as String elements.

  Changes:
  - "print()" has static access
  - Grouper now contains "getStringContaining()": Gets a String in the Grouper with specified Regex
  - Reader can now read without logging a line is read, allowing for the process to be non-verbose.
    
 ## **Author**
Nathan Weber

**GitHub** [@npweber](https://github.com/npweber/)

***Many thanks!***


