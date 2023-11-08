
import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[] numbers, answerArr;
    static int N, M;
    static boolean[] visit;
    static Set<String> answer = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        input();
        DFS(0);
        output();
    }

    static void DFS(int L) {
        if (L == M) {
            StringBuilder builder = new StringBuilder();
            for (int x : answerArr) builder.append(x).append(" ");
            answer.add(builder.toString());
            return;
        }

        for (int i=0; i<N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                answerArr[L] = numbers[i];
                DFS(L + 1);
                visit[i] = false;
            }
        }


    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        numbers = new int[N];

        tokenizer = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(numbers);


        visit = new boolean[N];
        answerArr = new int[M];
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();
        for (String x : answer) builder.append(x).append("\n");
        bw.write(builder.toString());
        bw.flush();
    }
}
