
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] sudoku = new int[9][9];
    static List<Pair> pairList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        DFS(0);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<9; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++) {
                int token = Integer.parseInt(tokenizer.nextToken());
                if (token == 0) pairList.add(new Pair(i, j));
                sudoku[i][j] = token;
            }
        }

        br.close();
    }

    static void DFS(int index) throws IOException {
        if (index == pairList.size()) {
            output();
        }

        int x = pairList.get(index).x;
        int y = pairList.get(index).y;

        for (int i=1; i<=9; i++) {
            if (isValid(x, y, i)) {
                sudoku[x][y] = i;
                DFS(index + 1);
                sudoku[x][y] = 0;
            }

        }
    }

    static boolean isValid(int row, int col, int value) {

        for (int i=0; i<9; i++) {
            if (sudoku[row][i] == value) return false;
        }

        for (int i=0; i<9; i++) {
            if (sudoku[i][col] == value) return false;
        }

        int cal_x = (row / 3) * 3;
        int cal_y = (col / 3) * 3;

        for (int i=cal_x; i<cal_x + 3; i++) {
            for (int j=cal_y; j<cal_y + 3; j++) {
                if (sudoku[i][j] == value) return false;
            }
        }

        return true;
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                builder.append(sudoku[i][j]).append(" ");
            }
            builder.append("\n");
        }

        bw.write(builder.toString());
        bw.flush();
        bw.close();

        System.exit(0);
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
