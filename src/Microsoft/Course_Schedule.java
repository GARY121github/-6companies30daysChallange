package Microsoft;
import java.util.*;
public class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] prerequisite = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] arr : prerequisites){
            prerequisite[arr[0]]++;
            graph.computeIfAbsent(arr[1], list -> new ArrayList<>()).add(arr[0]);
        }
        List<Integer> finished = new ArrayList<>();
        for(int course = 0; course < numCourses; course++){
            if(prerequisite[course] == 0){
                finished.add(course);
            }
        }
        List<Integer> NULL = new ArrayList<>();
        for(int index = 0; index < finished.size(); index++){
            for(int course : graph.getOrDefault(finished.get(index), NULL)){
                if(--prerequisite[course] == 0){
                    finished.add(course);
                }
            }
        }
        return finished.size() == numCourses;
    }
}
