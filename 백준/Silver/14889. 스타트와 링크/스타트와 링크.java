
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int ANSWER = Integer.MAX_VALUE;
    static int[][] teamValue;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        input();
        DFS(0,0);
        output();
    }

    static void DFS(int idx, int L) throws IOException {
        if (N / 2 == L) {
            checkValue();
            return;
        }

        for (int i=idx; i<N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                DFS(i + 1, L + 1);
                visit[i] =false;
            }
        }
    }

    static void checkValue() throws IOException {
        int start = 0;
        int link = 0;

        for (int i=0; i<N-1; i++) {
            for (int j=i+1; j<N; j++) {
                if (visit[i] && visit[j]) {
                    start += teamValue[i][j];
                    start += teamValue[j][i];
                } else if (!visit[i] && !visit[j]) {
                    link += teamValue[i][j];
                    link += teamValue[j][i];
                }
            }
        }

        ANSWER = Math.min(ANSWER, Math.abs(start - link));

        if (ANSWER == 0) {
            output();
            System.exit(0);
        }
    }




    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ANSWER));
        bw.flush();
        bw.close();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        teamValue = new int[N][N];
        visit = new boolean[N];

        for (int i=0; i<N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                teamValue[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        br.close();
    }
}
