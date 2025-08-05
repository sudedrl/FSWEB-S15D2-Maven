package org.example;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<org.example.entity.Task> annsTasks;
    private Set<org.example.entity.Task> bobsTasks;
    private Set<org.example.entity.Task> carolsTasks;
    private Set<org.example.entity.Task> unassignedTasks;

    public TaskData(Set<org.example.entity.Task> annsTasks, Set<org.example.entity.Task> bobsTasks, Set<org.example.entity.Task> carolsTasks, Set<org.example.entity.Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<org.example.entity.Task> getTasks(String person) {
        switch (person.toLowerCase()) {
            case "ann": return annsTasks;
            case "bob": return bobsTasks;
            case "carol": return carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
            default: return new HashSet<>();
        }
    }

    // Union
    @SafeVarargs
    public final Set<org.example.entity.Task> getUnion(Set<org.example.entity.Task>... sets) {
        Set<org.example.entity.Task> union = new HashSet<>();
        for (Set<org.example.entity.Task> s : sets) {
            union.addAll(s);
        }
        return union;
    }

    // Intersection
    public Set<org.example.entity.Task> getIntersection(Set<org.example.entity.Task> set1, Set<org.example.entity.Task> set2) {
        Set<org.example.entity.Task> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);
        return intersect;
    }

    // Difference
    public Set<org.example.entity.Task> getDifferences(Set<org.example.entity.Task> set1, Set<org.example.entity.Task> set2) {
        Set<org.example.entity.Task> diff = new HashSet<>(set1);
        diff.removeAll(set2);
        return diff;
    }
}
