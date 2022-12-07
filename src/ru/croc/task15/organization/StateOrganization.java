package ru.croc.task15.organization;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.*;

public class StateOrganization {
    private final Map<Department, ArrayList<Department>> departments;
    private Department root;

    public StateOrganization() {
        departments = new HashMap<>();
    }

    public void addDepartamentsFromConfig(Path path) {

        try (Scanner scanner = new Scanner(new FileReader(path.toFile()))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] infoDepart = line.split(",");


                if (Objects.equals(infoDepart[1], "-")) {
                    root = new Department(infoDepart[0], Integer.parseInt(infoDepart[2]));
                    departments.put(root, new ArrayList<>());
                } else {
                    Department parentDep = findByName(infoDepart[1]);

                    Department department = new Department(infoDepart[0], Integer.parseInt(infoDepart[2]));

                    if (parentDep != null) parentDep.getChildDepartments().add(department);
                    departments.put(department, new ArrayList<>());
                }


            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    public void printDepartment() {
        for (Department department : departments.keySet()) {
            System.out.println(department.getName());
            for (Department childDepartment : department.getChildDepartments()) {
                System.out.println(childDepartment.getName() + " " + childDepartment.getTime());
            }
            System.out.println();
        }
    }

    public Department findByName(String name) {
        for (Department department : departments.keySet()) {
            if (Objects.equals(department.getName(), name)) return department;
        }
        return null;
    }
}
