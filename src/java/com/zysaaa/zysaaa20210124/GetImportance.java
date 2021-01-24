package com.zysaaa.zysaaa20210124;

import java.util.List;

/**
 * @description: 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 *
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 *
 * 注意:
 *
 * 一个员工最多有一个直系领导，但是可以有多个直系下属
 * 员工数量不超过2000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-importance
 * @author:zysaaa
 * @date: 2021/1/24 14:21
 */
public class GetImportance {



    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee1 : employees) {
            if (id == employee1.id) {
                return dfs(employee1, employees);
            }
        }
        return 0;
    }

    private static int dfs(Employee employee, List<Employee> employees) {
        if (employee == null) {
            return 0;
        }
        if (employee.subordinates == null) {
            return employee.importance;
        }
        int result = employee.importance;
        for (Integer integer : employee.subordinates) {
            for (Employee employee1 : employees) {
                if (employee1.id == integer) {
                    result += dfs(employee1, employees);
                }
            }
        }
        return result;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
