import java.util.Arrays;
class Solution {
    /*
        스킬트리의 맨 앞부터 탐색하여, 우선순위에 따른 
    */
    String[] split;
    public int solution(String skill, String[] skill_trees) {
        split = skill.split("");
        int answer = 0, stl = skill_trees.length;
        for (int i = 0; i<stl; i++){
            if (canLearn(skill_trees[i])){
                answer++;
            }
            System.out.println();
        }
        
        return answer;
    }
    
    public boolean canLearn(String skill){ 
        String[] sk = skill.split("");
        int priority = 0;
        for (int j = 0; j<sk.length; j++){
            for (int i = 0; i<split.length; i++){
                if (split[i].equals(sk[j])){
                    if (priority == i){
                        priority++;
                    } else {
                        return false;
                    }
                }
            }

        }
        return true;
    }
    
}