package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        int ret = 0;
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);

        while (!q.isEmpty()) {
            Employee e = map.get(q.poll());
            ret += e.importance;
            for (int i : e.subordinates) {
                q.offer(i);
            }
        }

        return ret;
    }

    Map<Integer, Employee> emap;

    public int getImportanceV1(List<Employee> employees, int queryid) {
        emap = new HashMap<>();
        for (Employee e : employees)
            emap.put(e.id, e);
        return dfs(queryid);
    }

    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid : employee.subordinates)
            ans += dfs(subid);
        return ans;
    }
}
