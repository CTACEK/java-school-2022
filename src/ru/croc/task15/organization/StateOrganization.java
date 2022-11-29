package ru.croc.task15.organization;

import java.util.*;

public class StateOrganization {
    Map<Department, ArrayList<Department[]>> departments;
    Department root;

    public StateOrganization() {
        departments = new HashMap<>();
    }

    public void addDepartamentsFromConfig(List<String[]> config) {
        for (String[] enteredDprtmnt : config) {
            if (Objects.equals(enteredDprtmnt[1], "-")) {
                root = new Department(enteredDprtmnt[0], Integer.parseInt(enteredDprtmnt[2]));
                departments.put(root, new ArrayList<>());
            }else {
                Department parentDep = findByName(enteredDprtmnt[1]);

                Department department = new Department(enteredDprtmnt[0], Integer.parseInt(enteredDprtmnt[2]));

                if (parentDep != null) parentDep.getChildDepartments().add(department);
                departments.put(department, new ArrayList<>());
            }
        }
    }

    public void printDepartment(){
        for (Department department : departments.keySet()) {
            System.out.println(department.getName());
            for (Department childDepartment : department.getChildDepartments()) {
                System.out.println(childDepartment.getName() + " " + childDepartment.getTime());
            }
            System.out.println();
        }
    }

    public Department findByName(String name){
        for (Department department : departments.keySet()) {
            if (Objects.equals(department.getName(), name)) return department;
        }
        return null;
    }
}
