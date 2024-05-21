package queue;

public class IntQueue {
    private int[] que; //큐
    private int capacity; // 용량
    private int front; // 맨 앞 포인터
    private int rear; // 맨 뒤 포인터
    private int num; //현재 데이터 개수

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public IntQueue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity =0;
        }
    }
    public int enque(int x) throws OverflowIntQueueException {
        if (num >= capacity) {
            throw new OverflowIntQueueException();
        }
        que[rear++] = x;
        num++;
        if (rear == capacity) {
            rear = 0;
        }
        return x;
    }

    public int deque() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        int x = que[front++];
        num--;
        if (front == capacity) {
            front = 0;
        }
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        return que[front];
    }

    public void clear() {
        num = rear = front = 0;
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;
            if (que[idx] == x) {
                return idx;
            }
        }
            return -1;
    }

    public int getCapacity() {
        return capacity;
    }
    public int size() {
        return num;
    }
    public boolean isEmpty() {
        return num <= 0;
    }
    public boolean isFull() {
        return num >= capacity;
    }
    public void dump() {
        if (num <= 0) {
            System.out.println("큐가 비었습니다.");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[(i + front) % capacity] + "");
                System.out.println();
            }
        }
    }
}
