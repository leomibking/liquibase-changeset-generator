package br.com.whg.utils.liquibase;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class LiquibaseUtils {
    //java -Dsource=c:\translations.sql -Dtarget=d:\lala.sql -Did='72494-DATA' -jar target\liquibase-changeset-generator-1.0.0.jar

    private static final String PATTERN = "--changeset %s:%s";

    public static void main(String[] args) throws Exception {

        final String source = System.getProperty("source");
        final String target = System.getProperty("target");
        final String id = System.getProperty("id");

        int i = 1;
        List<String> lines = Files.readAllLines(Paths.get(source), StandardCharsets.UTF_8);
        List<String> newLines = new ArrayList<>();
        newLines.add("--liquibase formatted sql");
        for (String line : lines) {
            final String format = format(PATTERN, id, i++);
            newLines.add(format);
            newLines.add(line);
            System.out.println(format("[%s] %s", format, line));
        }
        Files.write(Paths.get(target), newLines, StandardCharsets.UTF_8);
    }
}
