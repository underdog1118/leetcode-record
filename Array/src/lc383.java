package Array.src;

import java.util.HashMap;



public class lc383 {
        public boolean canConstruct(String ransomNote, String magazine) {
//        for(char r:ransomNote.toCharArray()){ //加强for循环，遍历ransomNote里所有char
//            int index = magazine.indexOf(r);
//            if(index == -1){ //没有在magazine找到字符r对应的Index
//                 return false;
//           }
//          magazine = magazine.substring(0,index)+magazine.substring(index+1）;
//        }
//       return true;
//    }


//solution2: with hashmap
            HashMap<Character, Integer> magazineLetters = new HashMap<>();
            for(char r: magazine.toCharArray()){
                int currentCount = magazineLetters.getOrDefault(r,0);
                magazineLetters.put(r,currentCount+1);
            }
            for(char r: ransomNote.toCharArray()){
                int CurrentCount = magazineLetters.getOrDefault(r,0);

                if(CurrentCount == 0){
                    return false;
                }
                magazineLetters.put(r, CurrentCount-1);
            }return true;
        }


        // 测试方法， 新建main, 新建class变量， 调用方法并输出
    public static void main(String[] args) {
        lc383 lc = new lc383();
        System.out.println(lc.canConstruct("asd","bab"));


    }
    }
