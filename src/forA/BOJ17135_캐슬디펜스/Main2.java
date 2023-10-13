package forA.BOJ17135_캐슬디펜스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

    static int N, M, D, totalEnemy, enemy, result;
    static int[] archer;
    static int[][] arr, copyarr;
    static boolean[][] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException{
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        archer = new int[3];
        totalEnemy = 0;
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) totalEnemy++;
            }
        }
        
        combination(0,0);
        bw.write(String.valueOf(result));
        bw.close();
    }//main
    
    public static void combination(int start, int idx) {
        if(idx == 3) {
            result = Math.max(result, game());
            return;
        }
        
        for(int i=start; i<M; i++) {
            archer[idx] = i;
            combination(i+1, idx+1);
        }
    }
    
    public static int game() {
        int enemy = totalEnemy;
        int[] dr = {0, -1, 0};
        int[] dc = {-1, 0, 1};
        
        // arr 복사
        copyarr = new int[N][M];
        for(int i=0; i<N; i++) copyarr[i] = Arrays.copyOf(arr[i], M);
        
        //계산
        int line = N;
        while(enemy>0 && line>0) {
            
            for(int i=0; i<3; i++) {
                Queue<int[]> queue = new LinkedList<int[]>();
                queue.offer(new int[] {line, archer[i]});
                visited = new boolean[N][M];
                
                // 사정거리
                int dist = 1;
                loop : while(!queue.isEmpty()) {
                    if(dist++>D) break;
                    
                    for(int j=0, size=queue.size(); j<size; j++) {
                        int[] cur = queue.poll();
                        int r = cur[0];
                        int c = cur[1];
                        
                        for(int k=0; k<3; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            
                            if(nr<0 || nc<0 || nr>=line || nc>=M || visited[nr][nc]) continue;
                            
                            if(copyarr[nr][nc] == 1) {
                                enemy--;
                                copyarr[nr][nc] = -line;
//                                System.out.print(copyarr[nr][nc] + " ");
                                break loop;

                            }
                            else if(copyarr[nr][nc] == -line) {
                                break loop;
                            }
                            queue.offer(new int[] {nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
            line--;
        }
        return totalEnemy - enemy;
    }
}

