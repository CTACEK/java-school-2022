package ru.croc.task15;

import ru.croc.task15.organization.StateOrganization;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path pathOfConfig = Path.of("/Users/ctacek/IdeaProjects/java-school-2022/src/ru/croc/task15/config_file.txt");

        StateOrganization jkh = new StateOrganization();
        jkh.addDepartamentsFromConfig(pathOfConfig);

        System.out.println(jkh.findByName("A").getMaxTime());

    }

}
