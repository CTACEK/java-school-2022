package ru.croc.task15;

import ru.croc.task15.organization.StateOrganization;
import ru.croc.task15.utilities.Parser;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path pathOfConfig = Path.of("/Users/ctacek/IdeaProjects/java-school-2022/src/ru/croc/task15/config_file.txt");
        List<String[]> config = Parser.pasreConfig(pathOfConfig);

        StateOrganization jkh = new StateOrganization();
        jkh.addDepartamentsFromConfig(config);
//        jkh.printDepartment();

        System.out.println(jkh.findByName("A").getMaxTime());

    }

}
