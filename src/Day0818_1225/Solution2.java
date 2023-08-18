package Day0818_1225;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) throws FileNotFoundException {
        
        System.setIn(new FileInputStream("src/Day0818_1225/input_1225.txt"));

        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            
            sc.nextInt();

            // 큐를 사용하여 입력 숫자들을 저장
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                int m = sc.nextInt();
                queue.offer(m); // 입력 숫자를 큐에 추가
            }

            int cycle = 1; // 현재 사이클
            while (true) {
                int temp = queue.poll() - cycle; // 현재 사이클에서 감소할 양
                if (temp <= 0) {
                    queue.offer(0); // 음수가 나오면 큐에 0을 추가
                    // 큐의 숫자들을 순환하여 이동
                    for (int i = 0; i < 7; i++) {
                        queue.offer(queue.poll());
                    }
                    queue.poll();	//0 제거
                    queue.offer(0); // 큐의 마지막에 0 추가

                    break; // 사이클 종료
                }
                queue.offer(temp); // 감소한 숫자를 큐에 추가

                cycle = (cycle % 5) + 1; // 다음 사이클로 넘어가기 위한 cycle값 조정 (1, 2, 3, 4, 5 순환)
            }

            // 테스트 케이스 번호와 사이클 수행 결과 출력
            System.out.print("#" + tc + " ");
            for (int num : queue) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
