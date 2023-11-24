

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Set<String> answerSet = new LinkedHashSet<>();
    static int[] numArr, selected;

    public static void main(String[] args) throws IOException {
        input();
        DFS(0);
        output();
    }

    static void DFS(int L) {
        if (L == M) {
            StringBuilder sb = new StringBuilder();
            for (int x : selected) sb.append(x).append(" ");
            answerSet.add(sb.toString());
            return;
        }

        for (int i=0; i<N; i++) {
            if (validate(L, numArr[i])) {
                selected[L] = numArr[i];
                DFS(L + 1);
            }
        }
    }

    static boolean validate(int L, int number) {

        for (int i=0; i<L; i++) {
            if (selected[i] > number) return false;
        }

        return true;
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        for (String answer : answerSet) {
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        numArr = new int[N];
        selected = new int[M];
        tokenizer = new StringTokenizer(br.readLine());



        for (int i=0; i<N; i++) {
            numArr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(numArr);

        br.close();
    }
}
