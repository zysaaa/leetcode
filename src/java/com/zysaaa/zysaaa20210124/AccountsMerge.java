package com.zysaaa.zysaaa20210124;

import java.util.*;

/**
 * @description: 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 *
 *  卧槽 好烦
 *
 * @author:zysaaa
 * @date: 2021/1/24 16:48
 */
public class AccountsMerge {

    static List<List<String>> result = new ArrayList<>();



    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        dfs(accounts);
        result.forEach(result0 -> {
            result0.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
        });
        return result;
    }


    public static void dfs(List<List<String>> accounts) {
        if (accounts.isEmpty()) {
            return;
        }
        if (accounts.size() == 1) {
            result.add(new ArrayList<>(new HashSet<>(accounts.get(0))));
            return;
        }

        List<String> list = accounts.get(0);

        Set <String> emails = new HashSet<>();
        for (int i = 1; i<list.size(); i++) {
            emails.add(list.get(i));
        }

        // 和剩下的进行匹配
        for (int i = 1; i<accounts.size(); i++) {
            for (int j = 1; j<accounts.get(i).size(); j++) {
                if (emails.contains(accounts.get(i).get(j))) {
                    // 是同一个账户
                    for (int o = 1; o<accounts.get(i).size(); o++) {
                        emails.add(accounts.get(i).get(o));
                    }
                    // 移除
                    accounts.remove(i);
                    i = 0;
                    break;
                }
            }
        }
        List<String> list1 = new ArrayList<>();
        list1.add(list.get(0));
        list1.addAll(emails);
        result.add(list1);
        accounts.remove(0);
        dfs(accounts);
    }
}
