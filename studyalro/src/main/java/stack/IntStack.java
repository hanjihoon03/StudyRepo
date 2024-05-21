package stack;

public class IntStack {
    private int[] stk;
    private int capacity;
    private int ptr;

    public static class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }
    public static class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }
    public IntStack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= capacity) {
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x;
    }
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[--ptr];
    }
    //스택에 맨 위 데이터를 확인하기 위한 메서드
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[ptr-1];
    }
    //배열로 구현했기 때문에 clear는 ptr만 초기화하면 된다.
    public void clear() {
        ptr = 0;
    }
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) {
            if (stk[i] == x) {
                return stk[i];
            }
        }
        //찾는 값이 없는 경우
        return -1;
    }
    //스택 용량
    public int getCapacity() {
        return capacity;
    }
    //현재 스택 사이즈
    public int size() {
        return ptr;
    }
    public boolean isEmpty() {
        return ptr <= 0;
    }
    public boolean isFull() {
        return ptr >= capacity;
    }
    //스택 안 모든 데이터를 바닥에서 꼭대기 순으로 출력
    public void dump() {
        if (ptr <= 0) {
            System.out.println("스택이 비어있습니다.");
        } else {
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + "");
                System.out.println();
            }
        }
    }
}
