package reviewAndTest;

import java.util.Comparator;

public class HeapDev {
    static class Heap {
        private int[] data;
        private int size;
        private int maximumSize;

        public Heap() {
            data = new int[100];
        }

        public static void main(String[] args) {
            int[] arr = new int[5];
            for (int i : arr) {
                System.out.println(i);
            }
        }

        public Heap(int maximumSize) {
            if (maximumSize < 1) {
                this.maximumSize = 100;
            } else {
                this.maximumSize = maximumSize;
            }
            this.maximumSize = maximumSize;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == 100;
        }

        public void clear() {
            data = null;
        }

        // 새로운 데이터를 삽입
        public void insert(int newInt) {
            int pointer;// 어레이의 인덱스를 가리키는 포인터 이다.
            if (isFull()) {
                throw new FullHeapException();
                // 힙이 꽉 차있다면 Exception(예외) 처리를 해주자
            } else {
                // 아니면 배열의 끝에 새로운 데이터를 삽입한다.
                data[size] = newInt;
                pointer = size;
                size++;

                while (pointer > 0 && data[pointer] > data[(pointer - 1) / 2]) {
                    // 최대 힙에서 자식 노드는 무조건 부모 노드보다 작거나 같아야한다
                    // 그러니 끝에 삽입된 노드를 부모 노드와 비교해서 크다면 부모 노드와 교체해주자
                    int temp = data[pointer];
                    data[pointer] = data[(pointer - 1) / 2];
                    data[(pointer - 1) / 2] = temp;
                    pointer = (pointer - 1) / 2;
                }
            }
        }

        // 힙에서 노드를 제거
        // 힙에서 제거 메소드는 가장 큰 노드 1개, 즉 루트 노드를 제거하고 반환한다.
        public int remove() {
            int toReturn;// 리턴될 인스턴스
            if (!isEmpty()) {
                toReturn = data[0];
                // 어레이의 가장 끝에 존재하는 노드를 루트 노드에 집어넣는다
                data[0] = data[--size];
                data[size] = 0;
            } else {
                // 만약 힙이 텅 빈 상태라면 예외 처리를 해주자
                throw new EmptyHeapException();
            }

            // 어레이의 가장 끝에 있는 노드를 루트 노드에 넣었으니, 힙을 재정렬 해야한다.
            fixRoot();// 재정렬 메소드를 실행하자

            return toReturn;// toReturn 인스턴스에 저장된 값을 반환한다.

        }

        public void fixRoot() {
            // remove 메소드에서 가장 큰 노드,즉 루트 노드를 제거하고 그 자리에 가장 끝에 있는 노드를 삽입했다.
            // 다시 힙을 재정렬 함으로써 루트 노드가 적절값을 가지도록 해야한다.

            int pointer = 0;// 루트 노드에서 시작한다
            while (pointer * 2 + 1 < size) {
                // 자식 노드중 더 큰 노드와 자리를 교체한다.
                if (data[pointer * 2 + 1] > data[pointer * 2 + 2]) {
                    int temp = data[pointer];
                    data[pointer] = data[pointer * 2 + 1];
                    data[pointer * 2 + 1] = temp;
                    pointer = pointer * 2 + 1;
                } else {
                    int temp = data[pointer];
                    data[pointer] = data[pointer * 2 + 2];
                    data[pointer * 2 + 2] = temp;
                    pointer = pointer * 2 + 2;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
