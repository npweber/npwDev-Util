# v1_6

Additions:
- Runner.java: Runs any executable, given a path.
- Writer and Reader now have "workingDir()", which prints the current directory of the file operation.

Changes:
- "getStringContaining()" now prints a message informing if the Grouper is not of type String
- Corrected Sleeper to use "Thread.sleep()"