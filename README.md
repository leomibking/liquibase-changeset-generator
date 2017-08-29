How to use:
1. First, generate the .sql file using liquibase
```
java -jar liquibase.jar --changeLogFile="path/to/source/sql/file" --diffTypes=data generateChangeLog
```

2. Run this command: 
```
java -Dsource="path/to/source/sql/file" -Dtarget="path/to/output/sql/file"  -Did="some-id" -jar liquibase-changeset-generator-1.0.0.jar
```
This command will generate a new sql file, with this pattern on each line: 
```
--changeset some-id:1
... sql data ...
```