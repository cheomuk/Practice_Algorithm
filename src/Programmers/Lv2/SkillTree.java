package Programmers.Lv2;

import java.util.*;

public class SkillTree {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            boolean isValid = true;
            int index = 0;

            for (int i = 0; i < skillTree.length(); i++) {
                char c = skillTree.charAt(i);

                if (skill.contains(String.valueOf(c))) {
                    if (skill.indexOf(c) != index) {
                        isValid = false;
                        break;
                    }
                    index++;
                }
            }

            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
}
