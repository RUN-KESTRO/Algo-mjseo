
import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Set<Pair> set = new HashSet<>();
    static int N, A, B, ANSWER;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void solution() {
        for (Pair pair : set) {
            if (isRectangle(pair.x ,pair.y)) ANSWER++;
        }
    }

    static boolean isRectangle(int x, int y) {
        return set.contains(new Pair(x + A, y))
                && set.contains(new Pair(x + A, y + B))
                && set.contains(new Pair(x, y + B));
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        A = Integer.parseInt(tokenizer.nextToken());
        B = Integer.parseInt(tokenizer.nextToken());

        for (int i=0; i<N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            set.add(new Pair(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
        }
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ANSWER));
        bw.flush();
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

