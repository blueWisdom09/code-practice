package algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjianhua
 * @see <a href= https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn5z8r/>题目</a>
 * @Description 字符串中的第一个唯一字符
 * @title FirstUniqCharString
 * @date 2022/6/28
 */
public class FirstUniqCharString {

    /**
     * char数组
     * @param s
     * @return int
     * @author chenjianhua
     * @date 2022/6/28 11:35
     */
    public int firstUniqCharOne(String s) {
        int[] a = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            a[chars[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++){
            if (a[chars[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 利用hashmap结构特点
     * @param s
     * @return int
     * @author chenjianhua
     * @date 2022/6/28 11:35
     */
    public int firstUniqCharTwo(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i] - 'a',map.getOrDefault(chars[i] - 'a',0) + 1);
        }
        for (int i = 0; i < chars.length; i++){
            if (map.get(chars[i] - 'a') == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 利用api
     * @param s
     * @return int
     * @author chenjianhua
     * @date 2022/6/28 13:27
     */
    public int firstUniqCharThree(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
