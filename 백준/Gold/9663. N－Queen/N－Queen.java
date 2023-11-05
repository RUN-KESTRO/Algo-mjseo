import java.io.*;

public class Main {

    static int ANSWER, N;
    static int[] CHESS_BOARD;

    public static void main(String[] args) throws IOException {
        input();
        DFS(1);
        output();
    }

    static void DFS(int L) {
        if (L == N + 1) {
            ANSWER++;
            return;
        }

        for (int i=1; i<=N; i++) {
            boolean isValidate = true;
            for (int j=1; j<L; j++) {
                isValidate = validate(i, L, CHESS_BOARD[j], j);
                if (!isValidate) break;
            }

            if (isValidate) {
                CHESS_BOARD[L] = i;
                DFS(L + 1);
            }
        }

    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        CHESS_BOARD = new int[N + 1];
    }

   static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ANSWER));
        bw.flush();
    }

    static boolean validate(int co1, int row1, int col2, int row2) {
        // 현재 Queen을 놓으려는 위치가 그 전 행의 Queen의 열과 똑같다면 유망하지 않다.
        if (co1 == col2) return false;
        // 현재 Queen을 높으려는 위치가 그 전 행의 Queen과 오른쪽 대각 관계이면 유망하지 않다.
        if ((co1 - row1) == (col2 - row2)) return false;
        // 현재 Queen을 놓으려는 위치가 그 전 행의 Queen과 왼쪽 대각 관계이면 유망하지 않다.
        if ((co1 + row1) == (col2 + row2)) return false;
        return true;
    }
}