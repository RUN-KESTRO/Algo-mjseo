

import java.io.*;
import java.util.*;

public class Main {

    static Map<Character, List<Character>> graphMap = new HashMap<>();
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=97; i<=122; i++) {
            List<Character> list = new ArrayList<>();
            graphMap.put((char) i, list);
        }

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            char firstToken = tokenizer.nextToken().charAt(0);
            tokenizer.nextToken();
            char lastToken = tokenizer.nextToken().charAt(0);

            graphMap.get(firstToken).add(lastToken);
        }

        int m = Integer.parseInt(br.readLine());

        for (int i=0; i<m; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            char firstToken = tokenizer.nextToken().charAt(0);
            tokenizer.nextToken();
            char lastToken = tokenizer.nextToken().charAt(0);

            BFS(firstToken, lastToken);
        }

        br.close();
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(builder.toString());
        bw.flush();
        bw.close();
    }

    static void BFS(char start, char target) {
        Queue<Character> Q = new LinkedList<>();
        Q.add(start);

        while (!Q.isEmpty()) {
            char vertex = Q.poll();
            if (vertex == target) {
                builder.append("T").append("\n");
                return;
            }

            List<Character> graphList = graphMap.get(vertex);
            Q.addAll(graphList);
        }

        builder.append("F").append("\n");
    }
}
