package ru.croc.task15.organization;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private final String name;
    private final int time;
    private final List<Department> childDepartments;


    public Department(String name, Integer time) {
        this.name = name;
        this.time = time;
        childDepartments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Integer getTime() {
        return time;
    }

    public List<Department> getChildDepartments() {
        return childDepartments;
    }

    public int getMaxTime(){
        int maxTime = 0;

        for (Department childDepartment : childDepartments) {
            int childTime = childDepartment.getMaxTime();
            if (childTime > maxTime) maxTime = childTime;
        }
        maxTime += time;
        return maxTime;
    }
}
