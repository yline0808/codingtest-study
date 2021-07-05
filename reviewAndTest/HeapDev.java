package reviewAndTest;

import java.util.ArrayList;

public class HeapDev {
    static class MinHeap {
        private ArrayList<Integer> heap;

        public MinHeap() {
            heap = new ArrayList<>();
            heap.add(0);
        }

        public void insert(int val) {
            heap.add(val);
            int p = heap.size() - 1;

            while (p > 1 && heap.get(p / 2) > heap.get(p)) {
                int tmp = heap.get(p / 2);
                heap.set(p / 2, heap.get(p));
                heap.set(p, tmp);

                p /= 2;
            }
        }

        public int delete() {
            if (heap.size() - 1 < 1) {
                return 0;
            }

            int deleteItem = heap.get(1);

            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int pos = 1;

            while ((pos * 2) < heap.size()) {
                int min = heap.get(pos * 2);
                int minPos = pos * 2;

                if (((pos * 2 + 1) < heap.size()) && min > heap.get(pos * 2 + 1)) {
                    min = heap.get(pos * 2 + 1);
                    minPos = pos * 2 + 1;
                }

                if (heap.get(pos) < min)
                    break;

                int tmp = heap.get(pos);
                heap.set(pos, heap.get(minPos));
                heap.set(minPos, tmp);
                pos = minPos;
            }
            return deleteItem;
        }

        public String toString() {
            return heap.toString();
        }
    }

    public static void main(String[] args) {
        MinHeap mh = new MinHeap();
        for (int i = 20; i > 10; i--) {
            mh.insert(i);
        }
        for (int i = 1; i < 10; i++) {
            mh.insert(i);
        }
        System.out.println(mh.toString());
        for (int i = 1; i < 25; i++) {
            System.out.println(mh.delete() + "|||" + mh.toString());
        }
    }
}
