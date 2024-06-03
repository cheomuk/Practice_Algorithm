package Programmers.Lv2;

import java.util.LinkedList;

class PrimaryCache {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            city = city.toLowerCase(); // 대소문자 구분 없애기

            // 캐시 히트
            if (cache.remove(city)) {
                cache.addLast(city);
                answer++;
            } else {
                // 캐시 미스
                if (cacheSize > 0 && cache.size() >= cacheSize) {
                    cache.poll();
                }

                if (cacheSize > 0) {
                    cache.addLast(city);
                }

                answer += 5;
            }
        }

        return answer;
    }
}
