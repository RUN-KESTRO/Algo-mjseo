import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Pair> Q = new LinkedList<>();
        for (int i=0; i<priorities.length; i++) {
            Q.offer(new Pair(i, priorities[i]));
        }

        while (!Q.isEmpty()) {
            Pair pair = Q.poll();

            boolean isGreat = Q.stream()
                    .anyMatch(findPair -> findPair.priority > pair.priority);
            
            if (isGreat) {
                Q.offer(pair);
            } else {
                answer++;
                if (pair.location == location) return answer;
            }
        }

        return answer;
    }
}

class Pair {
    int location;
    int priority;

    public Pair(int location, int priority) {
        this.location = location;
        this.priority = priority;
    }
    
    @Override
    public String toString() {
        return "Pair{" +
                "location=" + location +
                ", priority=" + priority +
                '}';
    }
}