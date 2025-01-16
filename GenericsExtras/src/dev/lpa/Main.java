package dev.lpa;

import dev.lpa.model.LPAStudent;
import dev.lpa.util.QueryList;
import dev.lpa.util.StudentCourseComparator;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i = 0; i < 25; i++) {
            queryList.add(new LPAStudent());
        }

        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.println("Matches");
        var matches = queryList
                .getMatches("percentComplete", "50")
                .getMatches("Course", "Python");
        printList(matches);

        System.out.println("Ordered by Course");
        StudentCourseComparator comparator = new StudentCourseComparator();
        queryList.sort(comparator);
        printList(queryList);
    }

    public static void printList(List<?> students) {
        for (var student : students) {
            System.out.println(student);
        }
    }
}
